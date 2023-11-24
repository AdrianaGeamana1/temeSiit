package calculator;

import interfaces.Addition;
import interfaces.Subtraction;

public class Calculator implements Addition, Subtraction {

    public Calculator() {
    }

    @Override
    public double add(double a, double b) {
        return a+b;
    }

    @Override
    public double subtr(double a, double b) {
        return a-b;
    }
    public double compute(String symbol,double x, double y){

        switch (symbol){
            case "+":return add(x,y);

            case "-":return subtr(x,y);
        }
        return 0;
    }
}
