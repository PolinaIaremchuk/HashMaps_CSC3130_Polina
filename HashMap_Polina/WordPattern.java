import java.util.HashMap;
public class WordPattern {
    public static boolean wordPattern(String pattern, char delimiter, String s) {
        String[] words = s.split("\\Q" + delimiter + "\\E");

        if (words.length != pattern.length()) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            // Check if the mapping already exists
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false; // Conflict in mapping
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false; // Conflict in mapping
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", '?', "dog?cat?cat?dog")); // true
        System.out.println(wordPattern("abba", '|', "apple|banana|grape|apple")); // false
        System.out.println(wordPattern("aaaa", ',', "dog,cat,cat,dog")); // false
        System.out.println(wordPattern("aaaa", ' ', "ice cream taco day")); // false
        System.out.println(wordPattern("adxp", ' ', "ice cream taco day")); // true
    }
}
