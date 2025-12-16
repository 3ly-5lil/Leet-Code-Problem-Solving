package SlidingWindow;

public class LongestRepeatingCharacterReplacement_424 {
    class Solution {

        public int characterReplacement(String s, int k) {
            char[] chars = s.toCharArray();

            // the frequency of the letter is saved in the ascii index of the letter
            int[] freqs = new int[26];

            int left = 0;
            int right = 0;
            int longest = 0;

            // ascii representation to the char
            int mostFrequent = 0;

            while (right < chars.length) {
                // the most frquent char in the substring
                mostFrequent = Math.max(mostFrequent, ++freqs[chars[right] - 'A']);

                // the numbers of the letter to change
                int lettersToChange = (right - left + 1) - mostFrequent;

                if (lettersToChange > k) {
                    // reduce the frequency of the left char
                    freqs[chars[left] - 'A']--;
                    left++;
                }

                longest = Math.max(longest, (right - left + 1));
                right++;
            }
            return longest;
        }
    }
}
