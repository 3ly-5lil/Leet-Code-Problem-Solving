package string;

public class DeleteColumnsToMakeSortedII {
    public static void main(String[] args) {
        int dels = minDeletionSize(new String[]
                {"vdy", "vei", "zvc", "zld"}
        );
        System.out.println(dels);
    }

    static public int minDeletionSize1(String[] strs) {
        int dels = 0;
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String s1 = strs[i];
                String s2 = strs[j];

                if (s1.compareTo(s2) <= 0) continue;

                for (int k = 0; k < s1.length(); k++) {
                    char c1 = s1.charAt(k), c2 = s2.charAt(k);

                    if (c1 < c2) break;
                    if (c1 == c2) continue;


                    for (int l = 0; l < strs.length; l++) {
                        strs[l] = strs[l].substring(0, k) + strs[l].substring(k + 1);
                    }

                    k--;
                    dels++;
                    s1 = strs[i];
                    s2 = strs[j];
                }
                i = 0;
                j = i;
            }
        }
        return dels;
    }

    static public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        boolean[] sorted = new boolean[n - 1];
        int dels = 0;

        for (int col = 0; col < m; col++) {
            boolean bad = false;
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(col) > strs[i + 1].charAt(col)) {
                    bad = true;
                    break;
                }
            }

            if (bad) {
                dels++;
            } else {
                for (int i = 0; i < n - 1; i++) {
                    if (strs[i].charAt(col) < strs[i + 1].charAt(col))
                        sorted[i] = true;
                }
            }
        }

        return dels;
    }
}
