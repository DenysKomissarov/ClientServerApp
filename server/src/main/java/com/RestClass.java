package com;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestClass{
    //private final org.slf4j.Logger loger = LoggerFactory.getLogger(RestClass.class);

    public static long timeStart=0;

    @RequestMapping("/request")
    @ResponseBody
    public String getInfo(){
        if (timeStart==0){
            timeStart= System.currentTimeMillis();
        }
        ScheduledStatistic.TEMPCOUNTREQUEST.incrementAndGet();
        return generateString();
    }


    private String generateString() {
        String result = RandomStringUtils.randomAlphabetic(200);
        //System.out.println(Thread.currentThread().getName());
        return  result;
    }
}
