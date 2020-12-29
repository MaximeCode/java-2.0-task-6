import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 28.12.2020
 *
 * @author me
 * <p>
 * Есть входной файл с набором слов, написанных через пробел. Необходимо:
 * 1) прочитать слова из файла;
 * 2) отсортировать в алфавитном порядке;
 * 3) посчитать, сколько раз каждое слово встречается в файле, вывести статистику на консоль;
 * 4) найти слово с максимальным количеством повторений, вывести на консоль это слово и сколько раз оно встречается в файле.
 */
public class Task6 {
    public static void main(String[] args) throws IOException {
        // пп. 1, 2
        Map<String, Integer> words = new TreeMap<>();
        Arrays.stream(new BufferedReader(new FileReader("src/main/resources/words.txt")).readLine().split(" "))
                .forEach(word -> words.put(word, words.getOrDefault(word, 0) + 1));
        // п. 3
        words.forEach((k, v) -> System.out.printf("Слово \"%s\" встречается %d раз.\n", k, v));
        // п. 4
        words.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .ifPresent(entry -> System.out.printf("\nСлово с максимальным количеством повторений - \"%s\", оно встречается %d раз.",
                        entry.getKey(), entry.getValue()));
    }
}
