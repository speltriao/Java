package main;

import constant.Euler;
import constant.Pi;
import start.Start;

import java.lang.reflect.Method;

public class Main {
    private static final int numberOfTerms = 60000;

    private static void singleThread(){
        Pi pi = new Pi();
        Euler e = new Euler();
        long startTime = System.nanoTime();
        Start.singleThread(numberOfTerms,e,pi);
        long stopTime = System.nanoTime();
        print("\nSingle thread!",e,pi,startTime,stopTime);
    }

    private static void dualThread(){
        Pi pi = new Pi();
        Euler e = new Euler();
        long startTime = System.nanoTime();
        Start.dualThread(numberOfTerms,e,pi);
        long stopTime = System.nanoTime();
        print("\nDual thread!",e,pi,startTime,stopTime);
    }

    private static void print(String singleDual, Euler e, Pi pi, long startTime, long stopTime){
        System.out.println(singleDual);
        System.out.println("Euler : " + e.getResult() + "   Pi : " + pi.getResult());
        System.out.println("Execution time: " + (stopTime - startTime)/Math.pow(10,6) + " miliseconds.");
    }

    public static void main(String[] args) {
        dualThread();
        singleThread();
    }
}