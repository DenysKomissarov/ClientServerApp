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

    private final org.slf4j.Logger loger = LoggerFactory.getLogger(SheduledStatistic.class);
    public final static AtomicInteger tempCountRequest = new AtomicInteger(0);          /////temp  - потому, что я его обнуляю каждую секунду
    private int countRequest = 0;

    @Scheduled(fixedRate = 1000)
    private void logStatistic(){

        long curentTime = System.currentTimeMillis() - RestClass.timeStart;

        if (tempCountRequest.get()!=0&&countRequest<2000000) {

            this.countRequest += tempCountRequest.get();
            loger.info("Average count of requests in one second: "+(tempCountRequest.get()/(curentTime/1000)));
            tempCountRequest.set(0);

        }
    }
}
