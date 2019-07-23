package com.believeyourself.leetcode.pascalsTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {

    /**
     * 解题思路：
     * 1. 使用迭代法，外层循环控制层数，内层循环控制横向数字。
     * 2. 对每层第一个值和最后一个值进行判断
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> values = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> cells = new ArrayList<>();
            values.add(cells);
            if (row == 0) {
                cells.add(1);
                continue;
            } else if (row == 1) {
                cells.add(1);
                cells.add(1);
                continue;
            }
            List<Integer> lastCells = values.get(row - 1);
            for (int cell = 0; cell <= row; cell++) {
                if (cell == 0 || cell == lastCells.size()) {
                    cells.add(1);
                } else {
                    cells.add(lastCells.get(cell - 1) + lastCells.get(cell));
                }
            }
        }
        return values;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5));
    }
}
