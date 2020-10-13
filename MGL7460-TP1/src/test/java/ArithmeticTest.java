import Business.Operations.*;
import Contracts.IArithmetic;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticTest
{
    @Test
    public void testAddition() {
        Addition calculator = new Addition(2,2);
        assertEquals(4, calculator.compute());
    }

    @Test
    public void testDivide() throws ClassNotFoundException {
        IArithmetic calculator = new Division(2,2);
        assertEquals(1, calculator.compute());
    }

    @Test
    public void testDivideWillThrowExceptionWhenDivideOnZero() {
        IArithmetic calculator = new Division(2,0);
        assertThrows(ArithmeticException.class,()-> calculator.compute());
    }

    @Test
    public void testMultiplication() throws ClassNotFoundException {
        IArithmetic calculator = new Multiplication(2,2);
        assertEquals(4, calculator.compute());
    }

    @Test
    public void testPower() throws ClassNotFoundException {
        IArithmetic calculator = new Power(2,2);
        assertEquals(4, calculator.compute());
    }

    @Test
    public void testPercentage() throws ClassNotFoundException {
        IArithmetic calculator = new Percentage(2,2);
        assertEquals(0, calculator.compute());
    }

    @Test
    public void testSubtraction() throws ClassNotFoundException {
        IArithmetic calculator = new Subtraction(2,2);
        assertEquals(0, calculator.compute());
    }
}
