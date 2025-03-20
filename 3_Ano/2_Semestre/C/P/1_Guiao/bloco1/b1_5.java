import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class b1_5 {
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
            Integer result = 0;
            Integer aux = 0;

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.contains("-")) {
                    String[] parts = word.split("-");
                    if (parts.length == 2 && map.containsKey(parts[0]) && map.containsKey(parts[1])) {
                        result += (map.get(parts[0]) + map.get(parts[1]));
                    } else {
                        System.out.print(word);
                    }
                }

                
            }
        }
    }
}
