package edu.coursera.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinArraySum {

    static final int DEFAULT_N = 150_000_000;

    public static double seqArraySum(double[] x) {
        long startTime = System.nanoTime();
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += 1 / x[i];
        }
        long timeInNanos = System.nanoTime() - startTime;
        printResults("seqArraySum", timeInNanos, sum);
        // Task T0 waits for Task T1 (join)
        return sum;
    }

    public static double parArraySum(double[] x) {
        long startTime = System.nanoTime();
        SumArray task = new SumArray(x, 0, x.length);
        ForkJoinPool.commonPool().invoke(task);
        double sum = task.ans;
        long timeInNanos = System.nanoTime() - startTime;
        printResults("parArraySum", timeInNanos, sum);
        return sum;
    }

    public static double parArraySumTask(double[] x) {
        long startTime = System.nanoTime();
        SumArrayTask task = new SumArrayTask(x, 0, x.length);
        double sum = ForkJoinPool.commonPool().invoke(task);
        long timeInNanos = System.nanoTime() - startTime;
        printResults("parArraySumTask", timeInNanos, sum);
        return sum;
    }

    public static void main(String[] args) {
        int n = DEFAULT_N;

        if (args.length != 0) {
            try {
                n = Integer.parseInt(args[0]);
                if (n <= 0) {
                    System.out.println();
                    n = DEFAULT_N;
                }
            } catch (Throwable e) {
            }
        }
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            x[i] = (1 + i);
        }

        //System.setProperty("java.util.ForkJoinPool.commonPool.parallelism", "2");
        System.setProperty("java.util.ForkJoinPool.commonPool.parallelism", "4");

        for (int numRun = 0; numRun < 10; numRun++) {
            System.out.printf("Run %d\n", numRun);
            seqArraySum(x);
            //parArraySum(x);
            parArraySumTask(x);
        }
    }

    private static void printResults(String name, long timeInannos, double sum) {
        System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.3f \n", name, timeInannos / 1e6, sum);
    }

    private static class SumArray extends RecursiveAction {
        
		private static final long serialVersionUID = 1L;
		
		// static int SEQUENTIAL_THRESHOLD = 5; degree performance
        static int SEQUENTIAL_THRESHOLD = 1000;
        int lo;
        int hi;
        double[] arr;
        double ans = 0;

        SumArray(double[] arr, int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
            this.arr = arr;
        }

        protected void compute() {
            if (hi - lo <= SEQUENTIAL_THRESHOLD) {
                for (int i = lo; i < hi; i++)
                    ans += 1 / arr[i];
            } else {
                SumArray left = new SumArray(arr, lo, (hi + lo) / 2);
                SumArray right = new SumArray(arr, (hi + lo) / 2, hi);
                //invokeAll(left, right);
                //or
                left.fork();
                right.compute();
                left.join();
                ans = left.ans + right.ans;
            }
        }

    }

    private static class SumArrayTask extends RecursiveTask<Double> {
        // static int SEQUENTIAL_THRESHOLD = 5; degree performance
    	
    	private static final long serialVersionUID = 1L;
    	
        static int SEQUENTIAL_THRESHOLD = 1000;
        int lo;
        int hi;
        double[] arr;
        //double ans = 0;

        SumArrayTask(double[] arr, int lo, int hi) {
            this.lo = lo;
            this.hi = hi;
            this.arr = arr;
        }

        protected Double compute() {
            if (hi - lo <= SEQUENTIAL_THRESHOLD) {
                double ans = 0;
            	for (int i = lo; i < hi; i++)
                    ans += 1 / arr[i];
                return ans;
            } else {
                SumArrayTask left = new SumArrayTask(arr, lo, (hi + lo) / 2);
                SumArrayTask right = new SumArrayTask(arr, (hi + lo) / 2, hi);
                right.fork();
                //double ans = left.compute() + right.join(); // The wrong way
                double ansL = left.compute();
                double ansR = right.join();
                return ansL + ansR;
            }
        }

    }

}
