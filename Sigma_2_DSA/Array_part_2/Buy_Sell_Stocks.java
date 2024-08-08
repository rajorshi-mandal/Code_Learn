package Array_part_2;

public class Buy_Sell_Stocks {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit : " + maxStockprofit(prices));
    }

    public static int maxStockprofit(int[]  prices) { //TC - O(n)
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(buyPrice < prices[i]) {
                profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else{
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
