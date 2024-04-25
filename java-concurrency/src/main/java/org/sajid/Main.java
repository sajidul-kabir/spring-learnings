package org.sajid;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main  {
    public static void main(String[] args) {
        Multithread multithread=new Multithread();

//        Thread thread1= new Thread(multithread);
//        Thread thread2= new Thread(multithread);
//        Thread thread3= new Thread(multithread);
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(multithread);
        executor.execute(multithread);
        executor.execute(multithread);

        executor.shutdown();

    }


}
