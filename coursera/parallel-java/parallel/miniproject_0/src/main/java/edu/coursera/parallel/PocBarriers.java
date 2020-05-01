package edu.coursera.parallel;

import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class PocBarriers {


    public static void main(String[] args) {
        Phaser ph = new Phaser(10);
        int[] indexes = new int[] {0, 1, 2, 3, 4, 5,6,7,8,9 };
        IntStream.range(0, 10).parallel().forEach((i) -> {
            System.out.println("HELLO " + i + "]");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int id = indexes[i]; // lookup
            ph.awaitAdvance(ph.arrive());
            System.out.println("BEY [" + id + "]");
        });


    }




}
