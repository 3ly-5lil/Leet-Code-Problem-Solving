public class TwoSumII_167 {
    public static void main(String[] args) {

    }

    static class Solution {
        static public int[] twoSum(int[] numbers, int target) {
            int start = 0,
                    end = numbers.length - 1;

            while (start < end) {
                int sum = numbers[start] + numbers[end];
                if (target == sum)
                    return new int[]{++start, ++end};
                else if (target > sum)
                    start++;
                else
                    end--;
            }

            return new int[]{};
        }
    }
}

