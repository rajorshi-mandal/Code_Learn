package Arrays;

public class Buy_Sell_Stocks {

    public static int maxProfit(int[] prices){

        int buyPrice= prices[0], maxProfit = Integer.MIN_VALUE;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] > buyPrice){
                int profit = prices[i] - buyPrice; //measure profit for that day
                maxProfit = Math.max(maxProfit, profit);    //update maxprofit
            } else {
                buyPrice = prices[i]; //if no profit then save it for next day
            }
        }
        
        return maxProfit = maxProfit < 0 ? - 1 : maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(price));
    }
}
