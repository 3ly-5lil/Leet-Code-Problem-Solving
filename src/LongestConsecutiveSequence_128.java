import java.util.Arrays;

class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {

        System.out.println(
                longestConsecutive(
                        new int[]{9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7}
                )
        );
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int localLength = 1, longestLength = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;

            if (nums[i] == nums[i - 1] + 1) {
                localLength++;
                continue;
            }

            if (localLength > longestLength) {
                longestLength = localLength;
            }
            localLength = 1;

        }
        if (localLength > longestLength)
            longestLength = localLength;

        return longestLength;
    }

}