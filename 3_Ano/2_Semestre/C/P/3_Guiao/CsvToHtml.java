import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.stringtemplate.v4.*;

public class CsvToHtml {
    public static void main(String[] args) {
        String csvFile = "file.csv";
        List<List<String>> data = readCsv(csvFile);
    }

    private static List<List<String>> readCsv(String csvFile) {
        List<List<String>> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                data.add(getDataFromLine(scanner.nextLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static List<String> getDataFromLine(String line) {
        return Arrays.asList(line.split(","));
    }
}