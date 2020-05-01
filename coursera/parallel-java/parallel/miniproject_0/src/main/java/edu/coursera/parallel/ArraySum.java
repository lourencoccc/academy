package edu.coursera.parallel;

import edu.rice.pcdp.PCDP;

public class ArraySum {
    static final int DEFAULT_N = 100_000_000;

    public static double sum1 = 0;
    public static double sum2 = 0;

    public static double seqArraySum(double[] x) {
        long startTime =  System.nanoTime();
        sum1 = 0;
        sum2 = 0;
        for(int i = 0; i < x.length / 2; i++){
            sum1 += 1 / x[i];
        }
        for(int i = x.length / 2; i < x.length / 2; i++){
            sum2 += 1 / x[i];
        }
        double sum = sum1 + sum2;
        long timeInNanos =  System.nanoTime() - startTime;
        printResults("seqArraySum", timeInNanos, sum);
        // Task T0 waits for Task T1 (join)
        return sum;
    }



    public static double parArraySum(double[] x) {
        long startTime =  System.nanoTime();
        sum1 = 0;
        sum2 = 0;
        PCDP.finish(()-> {
            PCDP.async(() ->{
                for(int i = 0; i < x.length / 2; i++){
                    sum1 += 1 / x[i];
                }
            });
            for(int i = x.length / 2; i < x.length / 2; i++){
                sum2 += 1 / x[i];
            }
        });
        double sum = sum1 + sum2;
        long timeInNanos =  System.nanoTime() - startTime;
        printResults("parArraySum", timeInNanos, sum);
        return sum;
    }

    public static void main(String[] args) {
        int n = DEFAULT_N;
        if(args.length != 0){
        try{
            n =  Integer.parseInt(args[0]);
            if(n <= 0) {
                System.out.println();
                n = DEFAULT_N;
            }
        }catch (Throwable e){
        }
        }
        double[] x = new double[n];
        for (int i = 0; i < n; i ++){
            x[i] = (1 + i);
        }

        System.setProperty("java.util.ForkJoinPool.commonPool.parallelism", "2");

        for(int numRun = 0; numRun < 5; numRun++) {
            System.out.printf("Run %d\n", numRun);
            seqArraySum(x);
            parArraySum(x);
        }
    }

    private static void printResults(String name, long timeInannos, double sum){
        System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.3f \n", name, timeInannos / 1e6, sum);
    }

}
