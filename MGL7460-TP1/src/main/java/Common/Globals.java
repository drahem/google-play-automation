package Common;

import Business.Operations.Subtraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Globals {
    public static String Addition = "+";
    public static String Division="/";
    public static String Multiplication="*";
    public static String Percentage="%";
    public static String Power="^";
    public static String Substraction="-";

    public static ArrayList<String> Pemdas = new ArrayList<String>() {{
        add("(\\()([^\\(\\)]*)(\\))"); //detects anything in parenthesis
        add("(-?\\d+\\.?\\d*)\\D*?(\\^)\\D*?(-?\\d+\\.?\\d*)"); //exponents
        add("(-?\\d+\\.?\\d*)\\D*?(\\*|\\/|%)\\D*?(-?\\d+\\.?\\d*)"); //multiplication, division, modulo
        add("(-?\\d+\\.?\\d*)\\D*?(\\+|-)\\D*?(-?\\d+\\.?\\d*)");  // addition, subtraction
    }};

    public static Map<String, String> ArithmeticMap = new HashMap<String, String>(){
        {
            put(Globals.Addition, Business.Operations.Addition.class.getName());
            put(Globals.Division, Business.Operations.Division.class.getName());
            put(Globals.Multiplication, Business.Operations.Multiplication.class.getName());
            put(Globals.Percentage, Business.Operations.Percentage.class.getName());
            put(Globals.Power, Business.Operations.Power.class.getName());
            put(Globals.Substraction, Subtraction.class.getName());

        }};
}
