package stack;

import java.util.Stack;

public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] ans = new int[temperatures.length];
            Stack<Integer> stack = new Stack<>();

            stack.add(0);

            for (int i = 1; i < temperatures.length; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int top = stack.pop();
                    ans[top] = i - top;
                }

                stack.push(i);
            }

            return ans;
        }

        // BruteForce n^2 (Time Limit Exeeded)
        public int[] dailyTemperaturesBruteForce(int[] temperatures) {
            int[] ans = new int[temperatures.length];

            // brute force
            for (int i = 0; i < temperatures.length; i++) {
                for (int j = i + 1; j < temperatures.length; j++) {
                    if (temperatures[j] > temperatures[i]) {
                        ans[i] = j - i;
                        break;
                    }
                }
            }

            return ans;
        }
    }
}
