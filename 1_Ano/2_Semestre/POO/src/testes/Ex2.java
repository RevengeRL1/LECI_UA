package testes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Ex2 {
    public static void main(String[] args) {
        // Mapa para agrupar palavras pela inicial e contar ocorrências
        Map<Character, Map<String, Integer>> groupedWords = new TreeMap<>();

        try (Scanner input = new Scanner(new File("Text File.txt"))) {
            input.nextLine(); // Ignorar a primeira linha, se necessário
            while (input.hasNextLine()) {
                String[] palavras = (input.nextLine().toLowerCase().split("\\W+"));
                for (String p : palavras) {
                    if (p.length() >= 3) {
                        char initial = p.charAt(0);
                        groupedWords.putIfAbsent(initial, new HashMap<>());
                        Map<String, Integer> wordsMap = groupedWords.get(initial);
                        wordsMap.put(p, wordsMap.getOrDefault(p, 0) + 1);
                    }
                }
            }

            // Escrever a estrutura de dados no arquivo de saída
            try (FileWriter writer = new FileWriter("output.txt")) {
                for (char initial : groupedWords.keySet()) {
                    writer.write(initial + ": ");
                    String words = groupedWords.get(initial).entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .map(entry -> entry.getKey() + ", " + entry.getValue())
                            .collect(Collectors.joining("; "));
                    writer.write(words);
                    writer.write("\n");
                }
            } catch (IOException e) {
                System.out.println("Erro ao escrever no ficheiro de saída");
            }

        } catch (IOException e) {
            System.out.println("Erro ao abrir o ficheiro");
        }
    }
}
