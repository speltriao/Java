package math;

public class Pi extends MathematicalConstant {

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
