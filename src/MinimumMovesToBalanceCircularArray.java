import java.util.ArrayList;
import java.util.List;

public class MinimumMovesToBalanceCircularArray {

    static public long minMoves(int[] balance) {
        List<Integer> negIndex = new ArrayList<>();
        long sum = 0;

        // get the indecies of the negatives & calc sum
        for (int i = 0; i < balance.length; i++) {
            if (balance[i] < 0)
                negIndex.add(i);
            sum += balance[i];
        }

        if (negIndex.isEmpty())
            return 0;
        if (sum < 0)
            return -1;

        long moves = 0;
        int index = negIndex.getFirst();
        int step = 1, left = index - 1, right = index + 1;

        while (negIndex.size() > 0) {
            if (left == -1) left = balance.length - 1;
            if (right == balance.length) right = 0;

            if (left >= 0) {
                if (balance[left] > 0 && balance[index] < 0) {
                    int n;
                    int bi = Math.abs(balance[index]);
                    if (balance[left] < bi) {
                        n = balance[left];
                        balance[left] = 0;
                        balance[index] += n;
                    } else {
                        n = bi;
                        balance[index] = 0;
                        balance[left] -= n;
                    }
                    moves += (long) step * n;
                }
                left--;
            }
            if (right < balance.length) {
                if (balance[right] > 0 && balance[index] < 0) {
                    int n;
                    int bi = Math.abs(balance[index]);
                    if (balance[right] < bi) {
                        n = balance[right];
                        balance[right] = 0;
                        balance[index] += n;
                    } else {
                        n = bi;
                        balance[index] = 0;
                        balance[right] -= n;
                    }
                    moves += (long) step * n;
                }
                right++;
            }
            step++;
            if (balance[index] == 0) {
                negIndex.removeFirst();
                if (negIndex.size() > 0) {
                    index = negIndex.getFirst();
                    left = index - 1;
                    right = index + 1;
                    step = 1;
                }
            }
        }
        return moves;
    }
}
