import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


public class ReadWriterThread implements Runnable {
    private final Logger loger = LoggerFactory.getLogger(ReadWriterThread.class);
    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://localhost:8080/request";

    @Override
    public void run() {

        int i = 0;
        while(i < 10000){
//            if(ClientRestTemplate.isExecutorStoped.get())         // если останавливать по времени
//                break;
            try {
                ResponseEntity<String> infoResponce = restTemplate.getForEntity(URL,String.class);
                loger.debug("Thread " + Thread.currentThread() + " :  " + infoResponce.getBody());
                i++;
                ClientRestTemplate.atomicInteger.incrementAndGet();
            }catch(ResourceAccessException ex){
                //loger.info( ex.getMessage());
            }
        }

    }
}
