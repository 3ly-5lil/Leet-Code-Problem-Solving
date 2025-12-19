package matrix;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] customer : accounts) {
            int budget = 0;

            for (int bankBudget : customer)
                budget += bankBudget;

            max = Math.max(max, budget);
        }
        return max;
    }
}
