package com.believeyourself.leetcode.test.twoSum;

import com.believeyourself.leetcode.twoSum.TowSum;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TowSumTest {

    private int[] nums = {2, 7, 9, 11};
    private int target = 9;
    private int[] results = {0, 1};
    private TowSum towSum;

    @BeforeMethod
    public void setUp(){
        towSum = new TowSum();
    }

    @Test
    public void testTowSum() {
        assertEquals(results, towSum.twoSum(nums, target));
    }

    @Test
    public void testTowSumByTowPassHashTable(){
        assertEquals(results, towSum.towSumByTowPassHashTable(nums, target));
    }

    @Test
    public void testTowSumByOnePassHashTable(){
        assertEquals(results, towSum.towSumByOnePassHashMap(nums, target));
    }

}
