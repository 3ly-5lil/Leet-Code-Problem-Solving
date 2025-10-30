public class Problem4 {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // it will be the middle element if the length of the merged array is odd,
        // if it's even then it will be the average of the two elements at the mid

        double indexOfTheMiddle = (double) (nums1.length + nums2.length) / 2;

        int i = 0, i1 = 0, i2 = 0, middle = 0, preMiddle = 0;

        while (i <= indexOfTheMiddle) {
            preMiddle = middle;

            int curr1, curr2;

            if (i1 < nums1.length) curr1 = nums1[i1];
            else curr1 = Integer.MAX_VALUE;

            if (i2 < nums2.length) curr2 = nums2[i2];
            else curr2 = Integer.MAX_VALUE;

            if (curr1 < curr2) {
                middle = curr1;
                i1++;
            }
            else {
                middle = curr2;
                i2++;
            }

            i++;
        }

        return indexOfTheMiddle % 1 == 0 ?
                (double) (middle + preMiddle) / 2
                : middle;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3}, nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
