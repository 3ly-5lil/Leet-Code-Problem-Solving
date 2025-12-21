package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDeletionsToMakeAlternatingSubstring {
    public static void main(String[] args) {
        int[] minDel = minDeletions("ABB", new int[][]{
                {2, 0, 2},
                {1, 2},
                {2, 0, 2}
        });

        System.out.println(Arrays.toString(minDel));
    }

    static public int[] minDeletions(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();

        for (int[] query : queries) {
            if (query[0] == 1) {
                int index = query[1];
                if (chars[index] == 'A') chars[index] = 'B';
                else chars[index] = 'A';
            } else {
                int del = 0, startIndex = query[1], endIndex = query[2];
                char current = chars[startIndex];

                for (int j = startIndex + 1; j <= endIndex; j++) {
                    if (chars[j] == current) del++;
                    else current = chars[j];
                }

                list.add(del);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

}
