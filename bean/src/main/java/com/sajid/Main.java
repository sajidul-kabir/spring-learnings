package com.sajid;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Conf.class);
        System.out.println(context.getBean("getVehicle","rigg"));
    }
}
