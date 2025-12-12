package TwoPointers;

public class ContainerWithMostWater_11 {
    class Solution {
        public int maxArea(int[] height) {
            int max = 0, left = 0, right = height.length - 1;

            while (left < right) {
                int leftHeight = height[left], rightHeight = height[right],
                        w = right - left, h = Math.min(leftHeight, rightHeight);

                max = Math.max(max, h * w);

                if (leftHeight > rightHeight) right--;
                else left++;
            }

            return max;
        }
    }
}
