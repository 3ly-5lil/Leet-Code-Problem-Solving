package ArraysAndHashing;

import java.util.Arrays;

public class AbsoluteDifferenceBetweenMaximumAndMinimumKElements {
    public static void main(String[] args) {
        System.out.println(absDifference(new int[]{100}, 1));
    }

    static public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int max = 0, min = 0;

        for (int i = 0; i < k; i++) {
            min += nums[i];
            max += nums[nums.length - i - 1];
        }

        return Math.abs(max - min);
    }
}
