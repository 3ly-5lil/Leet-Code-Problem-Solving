package HashTable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        canConstructWithMap("aa", "ab");
    }

    public static boolean canConstructWithMap(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }

        for (char c : ransomNote.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;

            if (count < 0) return false;

            map.put(c, count);
        }

        return true;
    }

    public static boolean canConstructWithIntArray(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;

        int[] arr = new int[26];

        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (--arr[c - 'a'] < 0) return false;
        }

        return true;
    }
}
