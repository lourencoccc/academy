package edu.coursera.parallel;

import static edu.rice.pcdp.PCDP.forall;
import static edu.rice.pcdp.PCDP.forallChunked;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class OneDimAveragingBarrier {

	int n = 9;
	double[] oldX = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1 };
	double[] newX = new double[10];

	public static void main(String... args) {

        long startTime = System.nanoTime();
		OneDimAveragingBarrier seq = new OneDimAveragingBarrier();
		seq.runSeq(10);
        long timeInNanos = System.nanoTime() - startTime;
        printResults("Seq", timeInNanos);

        startTime = System.nanoTime();
		OneDimAveragingBarrier par = new OneDimAveragingBarrier();
		par.runPar(10);
        timeInNanos = System.nanoTime() - startTime;
        printResults("Par", timeInNanos);

        startTime = System.nanoTime();
		OneDimAveragingBarrier parGroup = new OneDimAveragingBarrier();
		parGroup.runParGroup(10, 2);
        timeInNanos = System.nanoTime() - startTime;
        printResults("ParGroup", timeInNanos);

        startTime = System.nanoTime();
		OneDimAveragingBarrier parBarr = new OneDimAveragingBarrier();
		parBarr.runParBarr(10, 2);
        timeInNanos = System.nanoTime() - startTime;
        printResults("ParBarr", timeInNanos);
//
		/*
		 * Origin: Seq 
			0.1
			0.124609375
			0.27851562500000004
			0.365625
			0.390625
			0.5890625
			0.35624999999999996
			0.7978515625
			0.14609375
			1.0
		 * */

	}

	
	public void debug(final String msg, final double [] values) {
		System.out.printf("Msg: %s \n", msg);
		for (int i = 0; i < values.length; i++) {
			if(i > 0)
				System.out.printf(", %.5f", values[i]);
			else
				System.out.printf("%.5f", values[i]);
		}
		System.out.println("");
	}


	public void mySeqAvg(int nsteps) {
		for (int n = 0; n < nsteps; n++) {
			for (int i = 1; i < oldX.length - 1; i++) {
				newX[i] = (oldX[i - 1] + oldX[i + 1]) / 2.0;
			}
			double[] temp = newX;
			newX = oldX;
			oldX = temp;
		}
	}

	public void runSeq(int iterations) {
		//debug("newX "+ 0, newX);
		//debug("oldX "+ 0, oldX);
		for (int iter = 0; iter < iterations; iter++) {

			for (int i = 1; i < n; i++) {
				newX[i] = (oldX[i - 1] + oldX[i + 1]) / 2.0;
			}
			double[] temp = newX;
			newX = oldX;
			oldX = temp;
			//debug("newX "+ iter, newX);
			//debug("oldX "+ iter, oldX);
		}
		debug("newX seq ", newX);
		debug("oldX seq ", oldX);
	}

	public void runPar(int iterations) {
		for (int iter = 0; iter < iterations; iter++) {
			forall(1, n - 1, (i) -> {
				newX[i] = (oldX[i - 1] + oldX[i + 1]) / 2.0;
			});
			double[] temp = newX;
			;
			newX = oldX;
			oldX = temp;
		}
		debug("newX par ", newX);
		debug("oldX par ", oldX);
	}
	
	public void runParGroup(int iterations, int tasks) {
		for (int iter = 0; iter < iterations; iter++) {
			forall(0, tasks - 1, (i) -> {
				for (int j = i * ((n - 1) / tasks) + 1; j <= (i + 1) * ((n - 1) / tasks); j++)
					newX[j] = (oldX[j - 1] + oldX[j + 1]) / 2.0;
			});
			double[] temp = newX;
			newX = oldX;
			oldX = temp;
		}
		debug("newX par group", newX);
		debug("oldX par group", oldX);
	}

    /**
     * @param iterations
     * @param tasks
     */
    public void runParBarr(int iterations, int tasks) {
        Phaser ph = new Phaser(tasks);

        IntStream.range(0, tasks).parallel().forEach((i) -> {
            double[] myOld = this.oldX;
            double[] myNew = this.newX;

            for (int iter = 0; iter < iterations; iter++) {
                for (int j = i * ((n - 1) / tasks) + 1; j <= (i + 1) * ((n - 1) / tasks); j++)
                    myNew[j] = (myOld[j - 1] + myOld[j + 1]) / 2.0;

                ph.awaitAdvance(ph.arrive());

                double[] temp = myNew;
                myNew = myOld;
                myOld = temp;
            }
            newX = myNew;
            oldX = myOld;
        });
        debug("newX par barri", newX);
        debug("oldX par barri", oldX);
    }

    private static void printResults(String name, long timeInannos) {
        System.out.printf(" %s completed in %8.3f milliseconds \n", name, timeInannos / 1e6);
    }

}
