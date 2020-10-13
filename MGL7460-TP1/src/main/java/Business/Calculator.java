package Business;

import Common.Globals;
import Contracts.IArithmetic;
import Contracts.ICalculator;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator implements ICalculator
{
    @Override
    public boolean pClose(String input)
    {
        int brackets = 0;
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) == '(') brackets++;
            else if (input.charAt(i) == ')') brackets--;
            if(brackets < 0) return false;
        }
        return brackets == 0;
    }

    @Override
    public Double compute(String input) {
        return Calculate(input,0);
    }
    private Double Calculate(String input, int num)
    {
        Double result = null;
        String next;
        Pattern filter = Pattern.compile(Globals.Pemdas.get(num));
        Matcher calcMatch = filter.matcher(input);
        if(!calcMatch.find())
        {
            if(num < 3)
            {
                return Calculate(input, num+1);
            }
            return null;
        }
        if(num == 0)
        {
            Double pSol = Calculate(calcMatch.group(2), 1);
            if(pSol !=null)
            {
                result = pSol;
                next = input.substring(0, calcMatch.start()) + result.toString() + input.substring(calcMatch.end());
            }
            else
            {
                next = input.substring(0, calcMatch.start()) + input.substring(calcMatch.end());
            }
        }
        else
        {
            result = ExecuteOperation(calcMatch.group(2),calcMatch.group(1),calcMatch.group(3));
            next = input.substring(0, calcMatch.start()) + result.toString() + input.substring(calcMatch.end());
        }
        if(filter.matcher(next).find())
        {
            return Calculate(next, num);
        }

        if(num < 3)
        {
            Double nextResult = Calculate(next, num+1);
            if(nextResult !=null) return nextResult;
        }
        return result;
    }

    private Double ExecuteOperation(String operator, String x, String y)
    {
        if(!Globals.ArithmeticMap.containsKey(operator))
        {
            return null;
        }
        String operationName = Globals.ArithmeticMap.get(operator);
        try
        {
            Class [] paramTypes = {double.class, double.class};
            Object [] paramValues = {Double.parseDouble(x), Double.parseDouble(y)};
                    IArithmetic arithmetic= (IArithmetic) Class.forName(operationName).getConstructor(paramTypes).newInstance(paramValues);
            return arithmetic.compute();
        }
         catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
