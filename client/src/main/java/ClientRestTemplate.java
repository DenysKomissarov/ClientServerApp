import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientRestTemplate {

    private  static final org.slf4j.Logger loger = LoggerFactory.getLogger(ClientRestTemplate.class);
    //public static final AtomicBoolean isExecutorStoped = new AtomicBoolean(false); // если останавливать по времени
    public static final AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();


        loger.info("start application");
        long startTimer = System.currentTimeMillis();
        long stopTimer;

        for (int i = 0; i < 200; i ++ ){
            ReadWriterThread readWriterThread = new ReadWriterThread();
            executor.submit(readWriterThread);
        }

        executor.shutdown();

        while (!executor.isTerminated()){

        }
        stopTimer = System.currentTimeMillis();
        loger.info("shutdown finished");

        SimpleDateFormat formating = new SimpleDateFormat("mm:ss:SSS");
        loger.info(" Query processing time : " + formating.format(stopTimer - startTimer));

        loger.info("Count Query : " + atomicInteger.get());

        loger.info("Average number of request : " + atomicInteger.get() / ((stopTimer - startTimer) / 1000));







//        try {
////            System.out.println("attempt to shutdown executor");
//            executor.shutdown();
//            //executor.awaitTermination(5, TimeUnit.SECONDS);
//        }
////        catch (InterruptedException e) {
////
////           // System.err.println("tasks interrupted");
////        }
//        finally {
           // isExecutorStoped.set(true);
//            executor.shutdownNow();
//            while (!executor.isTerminated()){
//                //logger.info("tasks interrupted");
//            }
//            stopTimer = System.currentTimeMillis();
//            logger.info("shutdown finished");
//
//            SimpleDateFormat formating = new SimpleDateFormat("HH:mm:ss:SSS");
//            logger.info(" Query processing time : " + formating.format(stopTimer - startTimer));
//
//            logger.info("Count Query : " + atomicInteger.get());
//        }
    }
}
