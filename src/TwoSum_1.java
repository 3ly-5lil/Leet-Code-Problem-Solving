import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    // O(n) time complexity
    // O(n) space complexity
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> complements = new HashMap<>(nums.length);

            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];

                if (complements.get(n) != null) return new int[]{i, complements.get(n)};

                complements.put(target - n, i);
            }

            return new int[]{};
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.twoSum(new int[]{2,7,11,15}, 9);
    }
}
