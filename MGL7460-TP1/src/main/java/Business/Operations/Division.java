package Business.Operations;

import Contracts.IArithmetic;

public class Division implements IArithmetic {
    private final double x;
    private final double y;

    public Division(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double compute()
    {
        double result= x/y;
        if(result== Double.POSITIVE_INFINITY || result== Double.NEGATIVE_INFINITY)
        {
            throw new ArithmeticException();
        }
        return result;
    }
}
