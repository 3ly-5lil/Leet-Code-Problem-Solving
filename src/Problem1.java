import java.util.HashMap;
import java.util.Map;

public class Problem1 {
//  O(n^2)
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            if (nums[i] >= target) continue;

            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }

//  O(n)
    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int y = target - nums[i];

            if (seen.containsKey(y)) return new int[] {seen.get(y), i};

            seen.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {


    }
}