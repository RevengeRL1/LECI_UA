package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Teste {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("Prego");
        words.add("no");
        words.add("Prato");

        words = words.stream()
             .filter(word -> word.length() >= 4)
             .collect(Collectors.toList());
        System.out.println();

        System.out.println(words);
    }
}
