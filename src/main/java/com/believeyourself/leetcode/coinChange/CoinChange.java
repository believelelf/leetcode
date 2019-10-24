package com.believeyourself.leetcode.coinChange;

/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * ##### 分析
 * 1. 使用动态规划解决问题，运用状态转移表法，代码实现使用迭代递推。
 * 2. 使用二维数组构建状态表，纵向为int[] coins硬币的决策轮次n;横向为金额值,其范围为[0, amount];数组中的值为到达此节点的最少硬币数，每个节点的初始值为-1；状态表为int [n][amount+1], 经过n轮决策后
 * 节点的(n, amount)的值为找零硬币数最小值。
 * 3. 由于只有最后一轮决策数据有用，可以使用一维状态表替换二维状态表，减少空间复杂度。
 */
public class CoinChange {

    /**
     * 使用动态规划解决问题，运用状态转移表法，代码实现使用迭代递推。
     *
     * @param coins  硬币组合
     * @param amount 找零金额
     * @return 最少硬币数
     */
    public int coinChange(int[] coins, int amount) {
        // 初始化状态表
        int[] states = new int[amount + 1];
        for (int j = 0; j <= amount; j++) {
            states[j] = -1;
        }
        // 第1轮决策
        int count = 0;
        for (int j = 0; j <= amount; j += coins[0]) {
            states[j] = count++;
        }
        // 后续n-1轮决策
        int n = coins.length;
        for(int i = 1; i < n; i++){
            int value = coins[i];
            for(int j = amount - value; j >= 0; j--){
                //1. 从states[]的末尾开始计算，防止重复状态。
                if(states[j] > -1){
                    count = 1;
                    //2. 要考虑一个面值可以加多次，且不超过amount.
                    for (int k = j + value; k <= amount; k += value) {
                        //3. 如原节点存在值，即将填入的值与旧值要取小者。
                        if(states[k] == -1){
                            states[k] = states[j] + count;
                        }else{
                            states[k] = Math.min(states[k], states[j] + count);
                        }
                        count++;
                    }
                }
            }
        }

        // 输出结构
        return states[amount];
    }


    public static void main(String[] args) {
        int[] cions = new int[]{1, 2, 5};
        System.out.println(new CoinChange().coinChange(cions, 11));
        cions = new int[]{2};
        System.out.println(new CoinChange().coinChange(cions, 3));
    }
}
