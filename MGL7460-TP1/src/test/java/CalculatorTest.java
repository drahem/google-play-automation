import Business.Calculator;
import Contracts.ICalculator;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest{
    @ParameterizedTest
    @ValueSource (strings = {"(1+2)","(1+2)*(5+3)","((2+5))","(2+4%(4+5))"})
        public void ShouldReturnTrueWhenOpenParenthesesAreClosed(String input) {
        ICalculator calculator = new Calculator();
        assertTrue(calculator.pClose(input));
    }

    @ParameterizedTest
    @ValueSource (strings = {"((1+2)","(1+2))*((5+3)","((2+5)))","(2+4%(4+5())", "(1+2)"})
    public void ShouldReturnFalseWhenOpenParenthesesAreNotClosed(String input) {
        ICalculator calculator = new Calculator();
        assertFalse(calculator.pClose(input));
    }

    @ParameterizedTest
    @CsvSource({"(1+2),3","(1+2)*(5+3),24","(3+5)/2,4","(2-9%(4+5)),2"})
    public void ShouldReturnTheCorrectCalculatedValue(String input, Double output) {
        ICalculator calculator = new Calculator();
        Double result = calculator.compute(input);
        assertEquals(result,output);
    }

    @ParameterizedTest
    @ValueSource (strings = {"1=2","1\\2","5*8"})
    public void ShouldRetunNullWhenNotValidOperator(String input) {
        ICalculator calculator = new Calculator();
        Double result = calculator.compute(input);
        assertTrue(result==null);
    }

    @Test
    public void ShouldRetunNullWhenNotValidOperator() {
        ICalculator calculator = new Calculator();
        assertThrows(ArithmeticException.class,()-> calculator.compute("1/0"));
    }
}
