package com.geek.springquartz.quartz;

import org.springframework.stereotype.Component;

/**
 * @author geek
 */
@Component("anotherBean")
public class AnotherBean {

    public void printAnotherMessage() {
        System.out.println("AnotherMessage");
    }

}
