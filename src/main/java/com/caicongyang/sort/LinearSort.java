package com.caicongyang.sort;

/**
 * 线性排序，包含：桶排序、计数排序、基数排序
 *
 * 非基于比较的排序算法，都不涉及元素之间的比较操作
 *
 * 时间复杂度 O(n)
 *
 */
public class LinearSort {
    //todo 1 桶排序
    /**
     * bucket sort
     * 1. 讲待排序的元素放入固定数量的有序桶内
     *    取出后就是完整的有序的元素
     *
     *
     *
     *
     */



    // todo 计数排序
    /**
     * counting sort
     * 计数排序的基本思想为一组数在排序之前先统计这组数中其他数小于这个数的个数，则可以确定这个数的位置。
     * 例如要排序的数为 7 4 2 1 5 3 1 5；则比7小的有7个数，所有7应该在排序好的数列的第八位，同理3在第四位，对于重复的数字，1在1位和2位（暂且认为第一个1比第二个1小），5和1一样位于6位和7位。
     *
     *
     *
     */





    // todo 基数排序
    /**
     * radix sort
     * 基数排序(Radix Sort)是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
     * 具体做法是：将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     *
     *
     */

}
