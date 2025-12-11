package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

// leet code problem 217
public class ContainsDuplicate_217 {
    class Solution {
        // Speed O(n)
        // Space O(n)
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> uniquesSet = new HashSet<>(nums.length);

            for (int x : nums) {
                if (uniquesSet.contains(x)) return true;
                uniquesSet.add(x);
            }

            return false;
        }
    }
}
