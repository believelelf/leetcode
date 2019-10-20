package com.believeyourself.leetcode.guessNumberHigherorLower;

public class GuessGame {

    int guess(int num){
        if(num > 6){
            return -1;
        }else if(num < 6){
            return 1;
        }else{
            return 0;
        }
    }
}
