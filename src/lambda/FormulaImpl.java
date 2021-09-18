package lambda;

import java.util.function.BiFunction;

public class FormulaImpl implements Formula {

    @Override
    public double calculate(int a) {
        return sqrt(a * a);
    }

    @Override
    public double sqrt(int a) {
        return Formula.super.sqrt(a);
    }

    public static void main(String[] args) {
        FormulaImpl formula = new FormulaImpl();
        System.out.println(formula.calculate(100));
        System.out.println(formula.sqrt(100));

        BiFunction<Formula, Integer, Double> calculate = Formula::calculate;
        Double apply = calculate.apply(new Formula() {
            @Override
            public double calculate(int a) {
                return a + 10;
            }

        }, 10);
        System.out.println(apply);

        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };
        System.out.println(Formula.positive(-23));
        System.out.println(formula1.calculate(100));
    }

}
