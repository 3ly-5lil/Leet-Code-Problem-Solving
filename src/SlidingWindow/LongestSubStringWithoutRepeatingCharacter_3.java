package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacter_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);

        System.out.println(length);
    }

    static public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;

        int l = 0, r = 0;
        int longest = 1;

        Set<Character> charSet = new HashSet<>();

        while (r < s.length()) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l++));
            }
            charSet.add(s.charAt(r++));
            longest = Math.max(longest, charSet.size());
        }

        return longest;
    }

    static public int lengthOfLongestSubstring_1(String s) {
        if (s.isEmpty()) return 0;

        int l = 0, r = 1;
        int longest = 1;

        while (r < s.length()) {
            String sub = s.substring(l, r);
            while (sub.contains("" + s.charAt(r))) {
                sub = s.substring(++l, r);
            }

            longest = Math.max(longest, sub.length() + 1);

            r++;
        }

        return longest;
    }
}
