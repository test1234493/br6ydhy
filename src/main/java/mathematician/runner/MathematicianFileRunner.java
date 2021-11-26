package mathematician.runner;

import exceptions.EquationIncorrectException;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class MathematicianFileRunner {

    public static final Path calculatorFilesPath = Path.of("src","main", "resources", "calculator");
    public static final Path operationFilePath = calculatorFilesPath.resolve("in.txt");

    public static void main(String[] args) throws IOException {
        try {
            List<String> operations = readAllLines(operationFilePath);
            calculateOperationsFromFile(operations);
        } catch (NoSuchFileException e) {
            System.out.println("File or directory doesn't exist.");
        }
    }

    private static void calculateOperationsFromFile(List<String> operations) {
        if (operations.size() == 0) {
            System.out.println("File is empty.");
        } else {
            for (String operation : operations) {
                try {
                    int result = CalculateResult.getResult(operation);
                    System.out.println(operation + " = " + result);
                } catch (EquationIncorrectException e) {
                    System.out.println("Equation " + operation + " is incorrect");
                } catch (NumberFormatException e) {
                    System.out.println("Equation " + operation + " has incorrect numbers provided");
                }

            }
        }
    }
}
