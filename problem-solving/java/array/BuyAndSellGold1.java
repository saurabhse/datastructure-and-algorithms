package array;

public class BuyAndSellGold1 {
    private int bestBuyDay = 0;
    private int bestSellDay = 1;
    private BuyAndSellGoldAPI API;
    public BuyAndSellGold1(BuyAndSellGoldAPI API) {
        this.API = API;
        // You can initiate and calculate things here
        getOptimalBuyAndSellDay();
    }

    private void getOptimalBuyAndSellDay(){
        int numberOfDays = API.getNumDays();
        System.out.println(numberOfDays);
        int maxDifference = Integer.MIN_VALUE;

        for (int i=0; i<numberOfDays; i++){
            int currentDayPrice = API.getPriceOnDay(i);

            for(int j=i+1; j<numberOfDays; j++){
                int currentDifference = API.getPriceOnDay(j) - currentDayPrice;

                if(currentDifference > maxDifference){
                    maxDifference = currentDifference;
                    bestBuyDay = i;
                    bestSellDay = j;
                }
            }
        }
        System.out.println(bestBuyDay);
        System.out.println(bestSellDay);
    }
    /**x
     * Return the day which you buy gold. The first day has number zero. This method is
     * called first, and only once.
     */
    public int getBuyDay() {
        return bestBuyDay;
    }

    /**
     * Return the day to sell gold on. This day has to be after (greater than) the buy
     * day. The first day has number zero (although this is not a valid sell day). This
     * method is called second, and only once.
     */
    public int getSellDay() {
        return bestSellDay;
    }

    public static void main(String[] args) {
        //7, 12, 5, 3, 11, 6, 10, 2, 9
        //7, 1, 5, 9, 2, 5, 4, 8, 5, 6, 9
        //7, 3, 8, 5, 10, 10, 3, 8, 1, 3, 9, 3, 7, 12, 10, 7, 8, 10, 1, 7, 5, 8
        //10, 3, 7, 9, 2, 12, 6, 2, 6, 7, 9, 10, 12, 8, 4, 10, 1, 11, 8, 7, 3, 6
        //11, 2, 11, 9, 9, 12, 5, 6, 3, 11, 12, 4, 3, 10, 3, 4, 8, 4, 8, 9, 5, 6, 12, 4
        //11, 1, 10, 6, 5, 12, 11, 2, 12, 11, 6, 10, 1, 12, 7, 10, 11, 9, 12, 11, 1, 10, 3, 1
        //12, 10, 9, 7, 4, 1
        //5, 6, 7, 4, 3, 10, 100, 20, 5
        //10, 9, 8, 9, 9, 8, 7, 9, 10
        //5, 5
        //8, 12, 7, 11, 6, 10, 5, 10, 4, 8, 3, 7, 2, 6, 1, 5
        //12, 11, 11, 10, 9, 6, 2

        int[] prices  = {7, 12, 5, 3, 11, 6, 10, 2, 9};

        BuyAndSellGoldAPI API = new BuyAndSellGoldAPI(prices);
        BuyAndSellGold1 bns = new BuyAndSellGold1(API);
        int buyDay = bns.getBuyDay();
        int sellDay = bns.getSellDay();
        int buyPrice = bns.getPriceOnDay(buyDay);
        int sellPrice = bns.getPriceOnDay(sellDay);
        int profit = sellPrice - buyPrice;

        System.out.println("BUY DAY: " + buyDay + " @ PRICE: " + buyPrice);
        System.out.println("SELL DAY: " + sellDay + " @ PRICE: " + sellPrice);
        System.out.println("MAX PROFIT: " + profit);


        int minPrice = prices[0];
        int maxProfit = prices[1] - prices[0];

        // start at the second (index 1) time
        // we can't sell at the first time, since we must buy first,
        // and we can't buy and sell at the same time!
        // if we started at index 0, we'd try to buy *and* sell at time 0.
        // this would give a profit of 0, which is a problem if our
        // maxProfit is supposed to be *negative*--we'd return 0.
        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - minPrice;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            minPrice = Math.min(minPrice, currentPrice);
        }
        System.out.println("Max profit"+ maxProfit);
    }

    private int getPriceOnDay(int day) {

        return API.getPriceOnDay(day);
    }
}

class BuyAndSellGoldAPI {

    private int[] prices;

    public BuyAndSellGoldAPI (int[] prices) {
        this.prices = prices;
    }

    public int getNumDays() {
        return prices.length;
    }

    public int getPriceOnDay(int day) {

        return prices[day];
    }

}
