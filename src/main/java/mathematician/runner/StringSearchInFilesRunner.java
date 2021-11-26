package mathematician.runner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.nio.file.Files.readAllLines;

public class StringSearchInFilesRunner {

    public static final Path poemsFilesPath = Path.of("src", "main", "resources", "poems");

    public static void main(String[] args) {
        File filePath = new File(String.valueOf(poemsFilesPath));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj szukane słowo:");
        String stringToFindInFiles = scanner.nextLine();

        searchProvidedStringInFiles(stringToFindInFiles, filePath);
    }

    private static void searchProvidedStringInFiles(String stringToFindInFiles, File filePath) {
        File[] filesInDirectory = filePath.listFiles();

        for (File file : filesInDirectory) {
            if (!file.isDirectory()) {
                searchStringInFile(stringToFindInFiles, file);
            } else if (file.isDirectory()) {
                searchProvidedStringInFiles(stringToFindInFiles, file);
            }
        }
    }

    private static void searchStringInFile(String stringToFindInFile, File file) {
        try {
            List<String> fileContent = readAllLines(file.toPath());
            List<String> strings = new ArrayList<>();
            for (String sentence : fileContent) {
                strings.addAll(Arrays.asList(sentence.split(" ")));
            }

            boolean stringFound = false;
            for (String s : strings) {
                if (s.equals(stringToFindInFile)) {
                    stringFound = true;
                }
            }
            if (stringFound) {
                System.out.println(file.getName());
            }
        } catch (IOException e) {
            System.out.println("File operation failed");
        }
    }
}
