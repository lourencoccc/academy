package edu.coursera.parallel;

import static edu.rice.pcdp.PCDP.forall;
import static edu.rice.pcdp.PCDP.forallChunked;

public class Quiz3 {

    public static void main(String... args){
        //question1();
        question9();
        question9A();
        question9B();
        question9C();
        question9D();
    }

    static void question1(){
        int [] x =  new int[5];
        int [] y =  new int[5];
        int [] z =  new int[5];
        int [] w =  new int[5];

        init(x, y, z, w);
        int N = 3;
        for (int i=0; i <= N; i = i + 1) {
            x[i] = x[i] + y[i];
            y[i+1] = w[i] + z[i];
        }
        printArr("x", x);
        printArr("y", y);

        init(x, y, z, w);
        forall(0, N - 1,  i-> {
            x[i] = x[i] + y[i];
            y[i+1] = w[i] + z[i];
        });
        printArr("x", x);
        printArr("y", y);

        init(x, y, z, w);
        forall(0, N - 1,  i-> {
            x[i] = x[i] + y[i];
        });
        forall(0, N - 1,  i-> {
            y[i+1] = w[i] + z[i];
        });
        printArr("x", x);
        printArr("y", y);

        init(x, y, z, w);
        x[0] = x[0] + y[0];
        forall(0, N - 1,  i-> {
            y[i+1] = w[i] + z[i];
            x[i+1] = x[i+1] + y[i+1];
        });
        y[N+1] = w[N] + z[N];
        printArr("x", x);
        printArr("y", y);
//        x:
//        20,30,30,30,10,
//                y:
//        10,20,20,20,20,

    }

    static void printArr(String label, int [] arr){
        System.out.println(label + ": ");
        for (int x : arr) {
            System.out.printf("%d,",x);
        }
        System.out.println();

    }

    static void init(int [] x, int [] y, int [] z, int [] w){
        for (int i = 0; i < 5;  i++) {
            x[i] = 10;
            y[i] = 10;
            z[i] = 10;
            w[i] = 10;
        }
    }

    static void question9(){
        int [] a =  new int[101];
        int [] b =  new int[101];
        int [] c =  new int[200];
        initBc(b, c);
        for (int i = 1; i <= 100; i++) {
            a[i] = b[i] + c[i + 10];
        }
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }

    static void question9A(){
        int [] a =  new int[101];
        int [] b =  new int[101];
        int [] c =  new int[200];
        initBc(b, c);
        for (int i = 1; i <= 100; i++) {
            a[i] = b[i] + c[i + 10];
        }
        forall (1, 100, (i) -> {
            a[i] = b[i] + c[i + 10];
        });
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += a[i];
        }
        System.out.println("A:" + sum);
    }

    static void question9B(){
        int [] a =  new int[101];
        int [] b =  new int[101];
        int [] c =  new int[200];
        initBc(b, c);
        forallChunked (1, 100, (i) -> {
            a[i] = b[i] + c[i + 10];
        });
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += a[i];
        }
        System.out.println("B:" + sum);
    }

    static void question9C(){
        int [] a =  new int[101];
        int [] b =  new int[101];
        int [] c =  new int[200];
        initBc(b, c);
        int chunkSizeDivides100 = 10;
        // Chunk size is provided in the third parameter below
        forallChunked (1, 100, chunkSizeDivides100, (i) -> {
            a[i] = b[i] + c[i + 10];
        });
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += a[i];
        }
        System.out.println("C:" + sum);
    }

    static void question9D(){
        int [] a =  new int[101];
        int [] b =  new int[101];
        int [] c =  new int[200];
        initBc(b, c);
        int chunkSizeDoesNotDivide100 = 23;
        // Chunk size is provided in the third parameter below
        forallChunked (1, 100, chunkSizeDoesNotDivide100, (i) -> {
            a[i] = b[i] + c[i + 10];
        });
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += a[i];
        }
        System.out.println("D:" + sum);
    }



    static void initBc(int [] b, int [] c){
        for (int i = 0; i < 101;  i++) {
            //a[i] = 10;
            b[i] = 1;
        }
        for (int i = 0; i < 200;  i++) {
            //a[i] = 10;
            c[i] = 2;
        }
    }

}
