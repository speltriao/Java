package math;

public abstract class MathematicalConstant {
    protected double value = 0.0;
    public double getValue(){return value;}
    public abstract void calculate(int numberOfTerms);

}
