package edu.coursera.parallel;

import static edu.rice.pcdp.PCDP.*;

public class MatrixMultiply {

	public static void main(String... args) {

		double[][] A = new double[][] { { 2, 3 }, { 1, 0 } };
		double[][] B = new double[][] { { 3, 1 }, { 2, 4 } };
		double[][] C = new double[3][2];

		mySimpleMatrixMultiply(A, B, C, A.length);
		seqMatrixMultiply(A, B, C, A.length);
		parMatrixMultiply(A, B, C, A.length);

	}

	public static void mySimpleMatrixMultiply(double A[][], double B[][], double C[][], int n) {
		long startTime = System.nanoTime();

//		for(int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				C[i][j] = 0;
//				for(int k = 0; k < n; k++) {
//					System.out.printf("%.2f * %.2f\n", A[i][k], B[k][j]);
//					C[i][j] += A[i][k] * B[k][j];
//				}
//				System.out.printf("%.2f\n", C[i][j]);
//			}
//		}

		for (int i = 0, j = 0; i < n && j < n; i++, j++) {
			for (int k = 0; k < n; k++) {
				C[i][j] += A[i][k] * B[k][j];
			}
		}

		long timeInNanos = System.nanoTime() - startTime;
		printResults("mySimpleMatrixMultiply", timeInNanos, C[n - 1][n - 1]);

	}

	public static void seqMatrixMultiply(double A[][], double B[][], double C[][], int n) {
		long startTime = System.nanoTime();
		forseq2d(0, n - 1, 0, n - 1, (i, j) -> {
			C[i][j] = 0;
			for (int k = 0; k < n; k++) {
				C[i][j] += A[i][k] * B[k][j];
			}
		});

		long timeInNanos = System.nanoTime() - startTime;
		printResults("seqMatrixMultiply", timeInNanos, C[n - 1][n - 1]);

	}

	public static void parMatrixMultiply(double A[][], double B[][], double C[][], int n) {
		long startTime = System.nanoTime();
		forall2dChunked(0, n - 1, 0, n - 1, (i, j) -> {
			C[i][j] = 0;
			for (int k = 0; k < n; k++) {
				C[i][j] += A[i][k] * B[k][j];
			}
		});
		long timeInNanos = System.nanoTime() - startTime;
		printResults("parMatrixMultiply", timeInNanos, C[n - 1][n - 1]);

	}

	private static void printResults(String name, long timeInNanos, double sum) {
		System.out.printf(" %s completed in %8.3f milliseconds, with sum = %8.3f \n", name, timeInNanos / 1e6, sum);
	}

}
