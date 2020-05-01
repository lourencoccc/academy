package edu.coursera.concurrent;

/**
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
 */
public class PocThread {

    public static void main(String... args) {
        new Thread(new HelloRunnable()).start();

        new Thread(() -> { System.out.println("Thread arows");}).start();

        new HelloThread().start();
    }
}

/**
 * Runnable object, is more general, because the 
 * Runnable object can subclass a class other than Thread.
 */
class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a Runnable!");
    }
}

/**
 * Is easier to use in simple applications, 
 * but is limited by the fact that your task class must 
 * be a descendant of Thread.
 */
class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }
}