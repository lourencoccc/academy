package edu.coursera.parallel;

import java.util.concurrent.Phaser;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.ComponentInputMap;

public class StreamHello {

	private static final int DEFAULT_N = 10_000_000;

	public static void main(String[] args) {
		// pocParStream(args);
		// pocForAllStream();
		pocForAllWithoutBorrier();
		pocForAllBarrier();
	}

	public static void pocForAllStream() {
		IntStream.range(0, 5).parallel().forEach(i -> {
			System.out.println(i);
			IntStream.range(0, 5).parallel().forEach(j -> {
				System.out.println(" --- " + j);
			});
		});
		int[] indexes = new int[] { 1, 2, 3, 4, 5 };
		// The output is not sequential for strings Hello and Bye

		IntStream.range(0, 5).parallel().forEach(i -> {
			int id = indexes[i]; // lookup
			System.out.println("Hello__" + i);
			// Need to apply Barrier to solve wait all previous instructions
			System.out.println("Bye__" + i);
		});
	}

	public static void pocForAllWithoutBorrier() {
		System.out.println("pocForAllWithoutBorrier");
		int[] indexes = new int[] { 1, 2, 3, 4, 5 };
		// The output is not sequential for strings Hello and Bye

		IntStream.range(0, 5).parallel().forEach(i -> {
			System.out.println("Hello__" + i);
			int id = indexes[i]; // lookup
			// Need to apply Barrier to solve wait all previous instructions
			System.out.println("Bye__" + id);
		});
	}

	public static void pocForAllBarrier() {
		System.out.println("pocForAllBarrier");
		Phaser ph = new Phaser(5);
		int[] indexes = new int[] { 1, 2, 3, 4, 5 };
		IntStream.range(0, 5).parallel().forEach(i -> {
			System.out.println("Hello__" + i);
			// Need to apply Barrier to solve wait all previous instructions
			int phase = ph.arrive();
			int id = indexes[i]; // lookup
			ph.awaitAdvance(phase);
			System.out.println("Bye__" + id);
		});
	}

	public static void pocParStream(String[] args) {
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
		Student[] x = new Student[n];

		for (int i = 0; i < n; i++) {
			x[i] = new Student("s" + i, 1 + i);
			if (i % 2 == 0) {
				x[i].active = true;
			}
		}

		// System.setProperty("java.util.ForkJoinPool.commonPool.parallelism", "2");
		// System.setProperty("java.util.ForkJoinPool.commonPool.parallelism", "4");

		for (int numRun = 0; numRun < 4; numRun++) {
			System.out.printf("Run %d\n", numRun);
			seqInteration(x);
			parStream(x);
		}

	}

	public static Double parStream(Student[] x) {
		long startTime = System.nanoTime();

		double average = Stream.of(x).parallel().filter(s -> s.active).mapToDouble(s -> s.age).average().getAsDouble();

		long timeInNanos = System.nanoTime() - startTime;

		printResults("parStream", timeInNanos, average);

		return average;
	}

	public static Double seqInteration(Student[] students) {
		long startTime = System.nanoTime();

		long ageSum = 0;
		int activeCount = 0;
		for (Student s : students) {
			if (s.active) {
				ageSum += s.age;
				activeCount++;
			}
		}
		double average = (double) ageSum / (double) activeCount;

		long timeInNanos = System.nanoTime() - startTime;

		printResults("seqInteration", timeInNanos, average);

		return average;
	}

	private static void printResults(String name, long timeInannos, double sum) {
		System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.3f \n", name, timeInannos / 1e6, sum);
	}

}

class Student {
	String name;
	Integer age;
	Boolean active = false;

	Student(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

}
