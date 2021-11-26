package mathematician.runner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import static java.nio.file.Files.readAllLines;
import static mathematician.runner.FilesOperationsCalculator.calculateOperationsFromFile;

public class MathematicianFileStructureRunner {

    public static final Path calculatorFilesPath = Path.of("src", "main", "resources", "calculator");
    public static final String OUTPUT_FILE_PREFIX = "out_";

    public static void main(String[] args) throws IOException {
        File filePath = new File(String.valueOf(calculatorFilesPath));
        calculateOperationsForAllFilesInDirectory(filePath);
    }

    private static void calculateOperationsForAllFilesInDirectory(File filePath) {
        File[] filesInDirectory = filePath.listFiles();

        for (File file : filesInDirectory) {
            if (!file.getName().contains(OUTPUT_FILE_PREFIX) && !file.isDirectory()) {
                calculateOperationsForFile(file);
            }
            if (file.isDirectory()) {
                calculateOperationsForAllFilesInDirectory(file);
            }
        }
    }

    private static void calculateOperationsForFile(File file) {
        try {
            List<String> operations = readAllLines(file.toPath());
            List<String> results = calculateOperationsFromFile(operations);
            File parentDir = file.getParentFile();
            String fileName = OUTPUT_FILE_PREFIX + file.getName();
            String outputFileName = parentDir.toPath().resolve(fileName).toString();
            FileWriter fileWriter = new FileWriter(outputFileName);

            for (String result : results) {
                fileWriter.write(result + "\r\n");
            }
            fileWriter.close();
        } catch (NoSuchFileException e) {
            System.out.println("File or directory doesn't exist.");
        } catch (IOException e) {
            System.out.println("File operation failed");
        }

    }


}
