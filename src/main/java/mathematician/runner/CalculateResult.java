package mathematician.runner;

import dtos.Mathematician;
import exceptions.EquationIncorrectException;

public class CalculateResult {
    public static Integer getResult(String equation) throws NumberFormatException, EquationIncorrectException {
        Integer result;
        Mathematician mathematician = Mathematician.getInstance();
        String[] splittedOperation = equation.split(" ");

        if (splittedOperation.length != 3) {
            throw new EquationIncorrectException("Equation has not enough inputs");
        }

        int a = Integer.valueOf(splittedOperation[0]);
        int b = Integer.valueOf(splittedOperation[2]);

        switch(splittedOperation[1]) {
            case "+":
                result = mathematician.add(a, b);
                break;
            case "-":
                result = mathematician.subtract(a, b);
                break;
            case "*":
                result = mathematician.multiply(a, b);
                break;
            case "/":
                result = mathematician.divide(a, b);
                break;
            default:
                throw new EquationIncorrectException("Provided operation is not supported");
        }
        return result;
    }




}
