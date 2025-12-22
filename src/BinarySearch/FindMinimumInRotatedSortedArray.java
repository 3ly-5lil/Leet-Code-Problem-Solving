package BinarySearch;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            min = Math.min(min, nums[mid]);
        }

        return min;
    }
}
