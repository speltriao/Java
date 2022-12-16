package math;

public class Euler extends MathematicalConstant {

    private double fatorial(int x) {
        double fat = 1.0;
        for (int i = 1; i <=x ; i++) {
            fat *= i;
        }
        return fat;
    }
    @Override
    public void calculate(int numberOfTerms) {
        for (int i = 0; i < numberOfTerms; i++) {
            value += (1.0 / (fatorial(i)));
        }
    }
}
