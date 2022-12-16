package init;

import math.Euler;
import math.Pi;
import thread.CalculationThread;

public class Init {
    public static void singleThread(int numberOfTerms, Euler euler, Pi pi){
        euler.calculate(numberOfTerms);
        pi.calculate(numberOfTerms);
    }

    public static void dualThread(int numberOfTerms, Euler euler, Pi pi) {
        CalculationThread c1 = new CalculationThread(numberOfTerms, euler );
        CalculationThread c2 = new CalculationThread(numberOfTerms, pi);
        c1.start();
        c2.start();
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
