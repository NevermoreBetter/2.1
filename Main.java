package Stage2;

public class Main {

    private static double function(double x) {
        return x * Math.pow(Math.E, 2 * x) - 4;
    }
    public static void main(String[] args) {
        System.out.println(EquationSolver.chordMethod(-2, 5));
        System.out.println(EquationSolver.divisionMethod(-2, 5));
        System.out.println(EquationSolver.tangentMethod(-2, 5));
    }
}
