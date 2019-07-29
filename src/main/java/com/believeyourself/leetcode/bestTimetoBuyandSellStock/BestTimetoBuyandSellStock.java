package com.believeyourself.leetcode.bestTimetoBuyandSellStock;

/**
 * 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock {

    /**
     * 解题思路：
     * 1. 将两个间隔值的差，表示为多个相邻值的差的和，对于两者的差小于0的取0
     * 2. 对于prices进行迭代，比较各个点的最大值
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxCurrVal = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurrVal = Math.max(0, maxCurrVal + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, maxCurrVal);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimetoBuyandSellStock().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
