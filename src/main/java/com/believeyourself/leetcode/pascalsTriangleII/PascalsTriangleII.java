package com.believeyourself.leetcode.pascalsTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Arrays.asList(1);
        }
        if (rowIndex == 1) {
            return Arrays.asList(1,1);
        }
        List<Integer> lastRows = Arrays.asList(1,1);
        List<Integer> currRows = null;
        for (int i = 2; i <= rowIndex; i++) {
            currRows = new ArrayList<>();
            currRows.add(1);
            for (int k = 1; k < i; k++) {
                currRows.add(lastRows.get(k) + lastRows.get(k - 1));
            }
            currRows.add(1);
            lastRows = currRows;
        }
        return currRows;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(3));
    }

}
