import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;


public class ReadWriterThread implements Runnable {
    private  static final Logger loger = LoggerFactory.getLogger(ReadWriterThread.class);
    private RestTemplate restTemplate;
    private int num;

    public ReadWriterThread(int num) {
        this.restTemplate = new RestTemplate();
        this.num = num;
    }

    @Override
    public void run() {

        int i = 0;
        while(i < 100){

//            if(ClientRestTemplate.isExecutorStoped.get())         // если останавливать по времени
//                break;
            try {
                ResponseEntity<String> infoResponce = restTemplate.getForEntity(ClientRestTemplate.URL,String.class);
                loger.warn("Thread " + num + " :  " + infoResponce.getBody());
                i++;
                ClientRestTemplate.atomicInteger.incrementAndGet();
            }catch(ResourceAccessException ex){
                //loger.info( ex.getMessage());
            }
        }

    }
}
