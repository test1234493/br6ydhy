package mathematician.runner;

import dtos.Mathematician;
import exceptions.EquationIncorrectException;

import java.util.Scanner;

public class MathematicianRunner {
    public static void main(String[] args) throws EquationIncorrectException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj działanie");
        String operation = scanner.nextLine();

        Integer result = CalculateResult.getResult(operation);

        System.out.println("Wynik: " + result);
    }


}
