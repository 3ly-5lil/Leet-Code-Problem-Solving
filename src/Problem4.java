public class Problem4 {
    static public double findMedianSortedArray(int[] nums) {
        if (nums.length == 0) return 0;

        // if the array has odd number of elements then the element at the middle is the median
        // else it's the average of the two middle elements
        if (nums.length % 2 == 0) {
            // if it's even find the element at (half) & (half - 1) and get there median
            int half = nums.length / 2;
            return (double) (nums[half] + nums[half - 1]) / 2;
        }

        int half = nums.length / 2;
        return nums[half];

    }
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) return findMedianSortedArray(nums2);
        if (nums2.length == 0) return findMedianSortedArray(nums1);

        return (findMedianSortedArray(nums1) + findMedianSortedArray(nums2)) / 2;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3}, nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
