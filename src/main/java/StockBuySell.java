/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
*/
public class StockBuySell {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < min)
                min = price;
            if (price - min > max)
                max = price - min;
        }
        return max;
    }
}