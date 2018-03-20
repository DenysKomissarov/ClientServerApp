package com;//import org.apache.tomcat.util.http.fileupload.FileUtils;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

@Component
@EnableScheduling
public class SheduledStatistic {

    private  static final org.slf4j.Logger loger = LoggerFactory.getLogger(SheduledStatistic.class);
    public final static AtomicInteger tempCountRequest = new AtomicInteger(0);          /////temp  - потому, что я его обнуляю каждую секунду
    private int countRequest = 0;
    private int countSecond = 0;

    @Scheduled(fixedRate = 1000)
    private void logStatistic(){
        if (tempCountRequest.get()!=0) {

            this.countRequest += tempCountRequest.get();
            this.countSecond++;

            tempCountRequest.set(0);
            loger.info("Average count of requests in one second: "+(countRequest/countSecond));
            //logger.log(Level.INFO, "Average count of requests in one second: "+(countRequest/countSecond));
            //logger.log(Level.INFO,"Count of request in one second " + String.valueOf(com.ServerApplication.tempCountRequest.get()));


//                try {
//                    FileUtils.writeStringToFile(new File("target/loog_info.txt"), "Average count of requests: " +
//                            (countRequest/countSecond) + "\n", "UTF-8",true);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
        }


    }
}
