package Stage2;

public class EquationSolver {
    private static final double e = 0.0001;

    private static double function(double x) {
        return x * Math.pow(Math.E, 2 * x) - 4;
    }

    private static boolean isValidValues(double a, double b) {
        if (function(a) >= 0 || function(b) <= 0) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    // метод хорд
    public static double chordMethod(double a, double b) {
        if (!isValidValues(a, b))
            return -256;

        double x = (a + b) / 2;
        double c = function(b) * function2(b) > 0? b : a;

        x = x - (c - x) * function(x) / (function(c) - function(x));

        while (Math.abs(function(x)) > e) {
            x = x - (c - x) * function(x) / (function(c) - function(x));
        }

        return x;
    }

    

    public static double divisionMethod(double a, double b) {
        if (!isValidValues(a, b))
            return -256;

        double x = (a + b) / 2;

        while (function(x) != 0 && Math.abs(function(x)) > e) {
            if (isSameSign(a, x))
                a = x;
            else
                b = x;

            x = (a + b) / 2;
        }

        return x;
    }

    private static boolean isSameSign(double a, double b) {
        return function(a) * function(b) > 0;
    }

    // метод дотичних

    private static double function1(double x) { // похідна першого порядку
        return 2 * x * Math.pow(Math.E, 2 * x) + Math.pow(Math.E, 2 * x);
    }

    private static double function2(double x) { // похідна другого порядку
        return 4 * x * Math.pow(Math.E, 2 * x) + Math.pow(Math.E, 2 * x);
    }

    public static double tangentMethod(double a, double b) {
        if (!isValidValues(a, b))
            return -256;

        double x;
        boolean isA = false;

        if (function(a) * function2(a) > 0) {
            x = a;
            isA = true;
        } else
            x = b;

        while (true) {
            if (function1(x) == 0)
                if (isA)
                    x = b;
                else {
                    System.out.println("Error! :(");
                    return -1;
                }

            if (function(x) == 0 || Math.abs(function(x)) < e)
                return x;

            x = x - function(x) / function1(x);
        }
    }
}
