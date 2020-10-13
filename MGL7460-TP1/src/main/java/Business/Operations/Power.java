package Business.Operations;

import Contracts.IArithmetic;

public class Power implements IArithmetic {
    private final double x;
    private final double y;

    public Power(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double compute() {
        return Math.pow(x, y);
    }
}
