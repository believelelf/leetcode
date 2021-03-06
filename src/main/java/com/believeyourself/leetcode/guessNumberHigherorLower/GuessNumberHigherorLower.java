package com.believeyourself.leetcode.guessNumberHigherorLower;

/**
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * Example :
 *
 * Input: n = 10, pick = 6
 * Output: 6
 */
public class GuessNumberHigherorLower extends GuessGame {
    /**
     * 利用二分查找，缩小数值的范围。
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int lo = 0;
        int hi = n;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int guessNum = guess(mid);
            if(guessNum == 0){
                return mid;
            }else if(guessNum > 0){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(new GuessNumberHigherorLower().guessNumber(10));
    }


}