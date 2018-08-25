import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class GuavaBiMapExample {
    public static void main(String[] args) {
        String[] englishWords = {"cat", "dog", "elephant", "bird"};
        String[] russianWords = {"кот", "собака", "слон", "птица"};

        BiMap<String, String> englishRussianDict = HashBiMap.create(englishWords.length);

        int i = 0;
        for (String englishWord : englishWords) {
            englishRussianDict.put(englishWord, russianWords[i]);
            i++;
        }

        System.out.println("Printing dictionary:\n" + englishRussianDict);

        System.out.println("Printing keys:\n" + englishRussianDict.keySet());

        System.out.println("Printing values:\n" + englishRussianDict.values());

        System.out.println("Printing inversed keys:\n" + englishRussianDict.inverse().keySet());

        System.out.println("Printing inversed values:\n" + englishRussianDict.inverse().values());

        System.out.println("Dog in Russian is \"" + englishRussianDict.get("dog") + "\"");

    }
}