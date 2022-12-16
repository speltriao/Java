package thread;

import math.MathematicalConstant;

public class CalculationThread extends Thread{

    private int numberOfTerms;
    private MathematicalConstant mathematicalConstant;
    public CalculationThread(int numberOfTerms, MathematicalConstant mathematicalConstant) {
        this.numberOfTerms = numberOfTerms;
        this.mathematicalConstant = mathematicalConstant;
    }

    @Override
    public void run () {
        mathematicalConstant.calculate(numberOfTerms);
    }
}
