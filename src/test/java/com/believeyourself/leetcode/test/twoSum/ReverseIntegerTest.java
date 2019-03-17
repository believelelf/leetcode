package com.believeyourself.leetcode.test.twoSum;

import com.believeyourself.leetcode.reverseInteger.ReverseInteger;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ReverseIntegerTest {

    @Test
    public void TestReverseInteger() {
        ReverseInteger ri = new ReverseInteger();
        assertEquals(123, ri.reverse(321));
        assertEquals(-123, ri.reverse(-321));
        assertEquals(21, ri.reverse(120));

    }

}
