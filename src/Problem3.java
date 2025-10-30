import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Problem3 {
    static public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> uniques = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);


            if (uniques.containsKey(c)) {
                max = Math.max(max, uniques.size());
                Set<Character> keySet = new HashSet<>(uniques.keySet());

                keySet.forEach((k) -> {
                    if (uniques.get(k) < uniques.get(c)) uniques.remove(k);
                });
            }

            uniques.put(c, i);
        }

        max = Math.max(max, uniques.size());

        return max;
    }

    public static void main(String[] args) {
        String s = "abba"; // expected 2
        System.out.println(lengthOfLongestSubstring(s));
    }
}