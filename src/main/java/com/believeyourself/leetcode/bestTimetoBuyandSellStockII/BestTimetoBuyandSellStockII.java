package com.believeyourself.leetcode.bestTimetoBuyandSellStockII;

/**
 * 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStockII {

    /**
     * 解题思路：
     * 1. 对于一段曲线，最大值为顶点-谷点。
     * 2. 对数组进行遍历，求取一段点的最小值，再求取一段点的最大值。将两者相减得到一段点的最大差值。
     * 3. 将多段点的最大差值相加，得到最的和
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int peak = 0;
        int valley = 0;
        int i = 0;
        while (i < prices.length - 1) {
            // 求得谷点
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            peak = prices[i];
            // 求得峰点
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BestTimetoBuyandSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1}));
    }


}
