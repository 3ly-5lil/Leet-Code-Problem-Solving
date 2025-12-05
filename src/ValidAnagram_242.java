import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    // Size O(n)
    // Speed O(n)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            Map<Character, Integer> characterCount = new HashMap<>(s.length());

            for (int i = 0; i < s.length(); i++) {
                char sc = s.charAt(i);
                char tc = t.charAt(i);

                characterCount.put(sc, characterCount.getOrDefault(sc, 0) + 1);
                characterCount.put(tc, characterCount.getOrDefault(tc, 0) - 1);
            }

            for (int x : characterCount.values()) {
                if (x != 0) return false;
            }
            return true;
        }
    }
}
