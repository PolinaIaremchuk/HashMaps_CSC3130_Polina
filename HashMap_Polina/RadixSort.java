import java.util.Arrays;
import java.util.HashMap;

public class RadixSort {

    public static void radixSort(String[] arr) {
        if (arr.length == 0) return;

        // Find max length of the longest string
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > maxLen) {
                maxLen = arr[i].length();
            }
        }

        // Sort from last character to first character
        for (int pos = maxLen - 1; pos >= 0; pos--) {
            countingSort(arr, pos, maxLen);
        }
    }

    private static void countingSort(String[] arr, int charIndex, int maxLen) {
        int n = arr.length;
        String[] output = new String[n];
        HashMap<Character, Integer> countMap = new HashMap<>();

        //EC
        for (char c = 'A'; c <= 'Z'; c++) countMap.put(c, 0);
        for (char c = 'a'; c <= 'z'; c++) countMap.put(c, 0);
        countMap.put(' ', 0); // Space

        // Count occurrences
        for (int i = 0; i < n; i++) {
            char c;
            if (charIndex < arr[i].length()) {
                c = arr[i].charAt(charIndex);
            } else {
                c = ' '; // missing characters as spaces
            }
            countMap.put(c, countMap.get(c) + 1);
        }

        // Convert countMap to cumulative sum
        char prevKey = ' ';
        for (char key = 'A'; key <= 'Z'; key++) {
            if (countMap.containsKey(key)) {
                countMap.put(key, countMap.get(prevKey) + countMap.get(key));
                prevKey = key;
            }
        }
        for (char key = 'a'; key <= 'z'; key++) {
            if (countMap.containsKey(key)) {
                countMap.put(key, countMap.get(prevKey) + countMap.get(key));
                prevKey = key;
            }
        }

        // Place elements in correct order
        for (int i = n - 1; i >= 0; i--) {
            char c;
            if (charIndex < arr[i].length()) {
                c = arr[i].charAt(charIndex);
            } else {
                c = ' ';
            }
            int pos = countMap.get(c) - 1;
            output[pos] = arr[i];
            countMap.put(c, pos);
        }

        //  output[] back to arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        String[] words = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo",
                "pupperino", "amaterasu", "amazon", "puppy", "hydra", "amazonia", "vueltiao"};

        System.out.println("Original Array: " + Arrays.toString(words));

        radixSort(words);

        System.out.println("Sorted Array: " + Arrays.toString(words));
    }
}
