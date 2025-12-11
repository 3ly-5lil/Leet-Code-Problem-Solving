package TwoPointers;

public class ValidPalindrome_125 {
    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    static class Solution {
        static public boolean isPalindrome(String s) {
            // remove any space and special characters
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            // check if the same index character from front and the back are equal
            int start = 0, end = s.length() - 1;

            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--))
                    return false;
            }

            return true;
        }
    }
}
