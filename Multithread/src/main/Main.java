package main;

import math.Euler;
import math.Pi;
import init.Init;

public class Main {
    private static final int numberOfTerms = 200000;

    private static void singleThread(){
        Pi pi = new Pi();
        Euler e = new Euler();
        long startTime = System.nanoTime();
        Init.singleThread(numberOfTerms,e,pi);
        long stopTime = System.nanoTime();
        print("\nSingle thread!",e,pi,startTime,stopTime);
    }

    private static void dualThread(){
        Pi pi = new Pi();
        Euler e = new Euler();
        long startTime = System.nanoTime();
        Init.dualThread(numberOfTerms,e,pi);
        long stopTime = System.nanoTime();
        print("\nDual thread!",e,pi,startTime,stopTime);
    }

    private static void print(String singleDual, Euler e, Pi pi, long startTime, long stopTime){
        System.out.println(singleDual);
        System.out.println("Euler : " + e.getValue() + "   Pi : " + pi.getValue());
        System.out.println("Execution time: " + (stopTime - startTime)/Math.pow(10,6) + " miliseconds.");
    }

    public static void main(String[] args) {
        dualThread();
        //singleThread();
    }
}