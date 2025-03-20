import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class b1_4 {
    public static void main(String[] args) {
        File file = new File("numbers.txt");
        HashMap<String, Integer> map = new HashMap<>();
        String line;
        Integer numValue;
        String numName;

        try (Scanner scanner = new Scanner(file)) {
            line = scanner.nextLine();
            while (!line.isEmpty()) {
                Scanner scanner2 = new Scanner(line);
                numValue = scanner2.nextInt();
                scanner2.next();
                numName = scanner2.next();
                scanner2.close();
                map.put(numName, numValue);
                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                } else {
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            
            Scanner scanner2 = new Scanner(line);

            while (scanner2.hasNext()) {
                String word = scanner2.next();
                if (word.contains("-")) {
                    String[] parts = word.split("-");
                    for (int i = 0; i < parts.length; i++) {
                        if (map.containsKey(parts[i].toLowerCase())) {
                            System.out.printf("%d ", map.get(parts[i].toLowerCase()));
                            continue;
                        }
                        System.out.printf("%s ", parts[i]);
                    }
                } else if (map.containsKey(word.toLowerCase())) {
                    System.out.printf("%d ", map.get(word.toLowerCase()));
                    continue;
                } else {
                    System.out.printf("%s ", word);
                }
            }
            scanner2.close();
            System.out.println();
        }
        scanner.close();
    }
}
