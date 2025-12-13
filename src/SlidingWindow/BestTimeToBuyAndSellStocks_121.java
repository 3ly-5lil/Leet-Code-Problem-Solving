package SlidingWindow;

public class BestTimeToBuyAndSellStocks_121 {
    class Solution {
        public int maxProfit(int[] prices) {
            int buyingPrice = prices[0]; // buying price
            int max = 0;

            for (int i = 1; i < prices.length; i++) {
                int sellingPrice = prices[i];

                // the buying price should be the minimum price
                if (buyingPrice > sellingPrice) buyingPrice = sellingPrice;

                max = Math.max(max, sellingPrice - buyingPrice);
            }
            return max;
        }

        public int maxProfit2(int[] prices) {
            int left = 0, // buying price
                    right = 1; // selling price

            int best = 0;
            while (right < prices.length) {

                int current = prices[right] - prices[left];

                if (best < current)
                    best = current;
                else if (current < 0)
                    left = right;

                right++;
            }
            return best;
        }
    }
}
