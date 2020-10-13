package Business.Operations;

import Contracts.IArithmetic;

public class Percentage implements IArithmetic {
    private final double x;
    private final double y;

    public Percentage(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double compute() {
        return x % y;
    }
}
