package mathematician.runner;

import exceptions.EquationIncorrectException;

import java.util.ArrayList;
import java.util.List;

public class FilesOperationsCalculator {
    public static List<String> calculateOperationsFromFile(List<String> operations) {
        List<String> results = new ArrayList<>();

        if (operations.size() == 0) {
            results.add("File is empty.");
        } else {
            for (String operation : operations) {
                try {
                    int result = CalculateResult.getResult(operation);
                    results.add(operation + " = " + result);
                } catch (EquationIncorrectException e) {
                    results.add("Equation " + operation + " is incorrect");
                } catch (NumberFormatException e) {
                    results.add("Equation " + operation + " has incorrect numbers provided");
                }
            }
        }

        results.stream().forEach(System.out::println);

        return results;
    }
}
