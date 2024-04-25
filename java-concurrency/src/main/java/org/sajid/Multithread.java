package org.sajid;

public class Multithread implements Runnable{
    @Override
    public  void run() {
       synchronized (this){
           for(int i=0;i<5;i++){
               System.out.println(i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        }

    }
}
