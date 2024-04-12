import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String fileName = "input.txt";
        int wordCount = 0;
        String longestWord = "";
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    String[] words = line.split("\\s+");
                    for (String word : words) {

                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                        }

                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                        wordCount++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        System.out.println("Количество слов в файле: " + wordCount);
        System.out.println("Самое длинное слово в файле: " + longestWord);

        System.out.println("Частота слов в файле:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
