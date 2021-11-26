package mathematician.runner;

import exceptions.EquationIncorrectException;

import java.util.Scanner;

public class MathematicianRunner2 {
    public static void main(String[] args) throws EquationIncorrectException {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while(true) {
            System.out.println("Podaj działanie");
            operation = scanner.nextLine();

            if (operation.equals("exit")){
                break;
            }
            Integer result = CalculateResult.getResult(operation);
            System.out.println("Wynik: " + result);
        }

    }
}
