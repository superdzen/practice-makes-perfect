package com.superdzen.best_time_to_buy_and_sell_stock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class Solution {
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int valley = 0;
        int peak = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println("The answer is: " + maxProfit(arr)); // 4
    }
}
