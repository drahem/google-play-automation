import Business.Calculator;
import Contracts.ICalculator;

import java.util.Scanner;

public class Main
{
    public static void main(String args[]){
        System.out.println("Write an expression to solve (ex: \"(2+3)*3\"). Supports + - * / ^ % as its operators.");
        Scanner scanner = new Scanner(System.in);
        String input;
        ICalculator calculator = new Calculator();

        input = scanner.nextLine();

        if(!calculator.pClose(input))
        {
            System.out.println("Error: There's a problem with your parenthesis.");
        }
        System.out.println(input + " is " + calculator.compute(input));
    }
}
