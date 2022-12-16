package constant;

public class Pi extends Constant{

    @Override
    public void calculate (int numberOfTerms) {
        int den = 1, mult = 1;
        for (int i = 0; i < numberOfTerms ; i++) {
            result += (mult * (4.0/(den)));
            den +=2;
            mult *= -1;
        }
    }
}
