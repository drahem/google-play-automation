package Business.Operations;

import Contracts.IArithmetic;

public class Addition implements IArithmetic {
    private final double x;
    private final double y;

    public Addition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double compute() {
        return x + y;
    }
}
