package edu.coursera.concurrent;

import java.util.stream.IntStream;

public class PoCStructuredLocks {

    public static void main(String... args) throws InterruptedException {
        MsLunch lunch = new MsLunch();

        Thread [] threads = new Thread[10];

        for(int i=0; i < threads.length; i++){
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1_000_000; j++){
                    lunch.inc1();
                }
            });
            
            threads[i].start();
        }

        for(int i=0; i < threads.length; i++){
            threads[i].join();
        }

        System.out.println(lunch.getC1());

    }

}

class MsLunch {
    private long c1 = 0;
    //private Object lock1 = new Object();

    // Data race problemm
    // public void inc1() {
    //     c1++;
    // }
    
    // Solution 1
    // public void inc1() {
    //     synchronized (lock1) {
    //         c1++;
    //     }
    // }

    //Solution 2
    public synchronized void inc1() {
         c1++;
    }

    public long getC1() {
        return c1;
    }
}
