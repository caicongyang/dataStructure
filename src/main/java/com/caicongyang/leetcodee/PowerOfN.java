package com.caicongyang.leetcodee;

import junit.framework.Assert;
import org.junit.Test;

/**
 * 判断一个数是不是2的N次方
 */
public class PowerOfN {


    public static boolean isPowerOf2(int n) {
        if (n < 2) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }


    @Test
    public void test() {

        Assert.assertEquals(isPowerOf2(2), true);

        Assert.assertEquals(isPowerOf2(3), false);


        Assert.assertEquals(isPowerOf2(16), true);

        Assert.assertEquals(isPowerOf2(999), false);


    }

}
