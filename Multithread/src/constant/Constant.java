package constant;

public abstract class Constant {
    protected int numberOfTerms;
    protected double result = 0.0;
    public double getResult(){return result;}

    public abstract void calculate(int numberOfTerms);

}
