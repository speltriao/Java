package thread;

import constant.Constant;

public class CalculationThread extends Thread{

    private int numberOfTerms;
    private Constant constant;
    public CalculationThread(int numberOfTerms, Constant constant) {
        this.numberOfTerms = numberOfTerms;
        this.constant = constant;
    }

    @Override
    public void run () {
        constant.calculate(numberOfTerms);
    }
}
