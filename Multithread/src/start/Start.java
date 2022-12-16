package start;

import constant.Euler;
import constant.Pi;
import thread.CalculationThread;

public class Start {
    public static void singleThread(int numberOfTerms, Euler euler, Pi pi){
        euler.calculate(numberOfTerms);
        pi.calculate(numberOfTerms);
    }

    public static void dualThread(int numberOfTerms, Euler euler, Pi pi) {
        CalculationThread c1 = new CalculationThread(numberOfTerms, euler );
        c1.run();
        CalculationThread c2 = new CalculationThread(numberOfTerms, pi);
        c2.run();
        try {
            c1.join();
            c2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
