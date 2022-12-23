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
    public void calculate (int numberOfTerms) {
        int den = 1, mult = 1;
        for (int i = 0; i < numberOfTerms ; i++) {
            value += (mult * (4.0/(den)));
            den +=2;
            mult *= -1;
        }
    }
}

