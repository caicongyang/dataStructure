package com.caicongyang.sort;

/**
 * 
 *
 * 简单排序  时间复杂度 O(n^2) 空间复杂度 O(1)
 * @author caicongyang1
 * @version $Id: SimpleSort.java, v 0.1 2016年5月31日 下午4:15:07 caicongyang1 Exp $
 */
public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = { 10, 4, 5, 7, 2, 3, 8 };
        //System.out.println(arr[arr.length - 1]);
        //bubbleSort(arr);
        //selectionSort(arr);
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }
    /**
     *插入排序
     *将数组分成有序部分和无序部分，将无序的依次插入有序部分中
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {//外层总1开始，
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {//内层从外层开始，依次递减，直到temp > arr[j]之前的数组（排到到应有的位置）
                arr[j] = arr[j - 1]; //向右移动
                --j;

            }
            arr[j] = temp; //插入对应的位置
        }
    }


    /**
     * 选择排序
     * 
     * 将最小的放在未排序的最前面，依次交换
     * 
     * 
     */
    public static void selectionSort(int[] arr) {
        int min; //定义最小的变量
        for (int i = 0; i < arr.length - 1; i++) { //外层从数组最小的位置0开始，到数组的倒数第二个位置
            min = i; //默认最小为数组第一个
            for (int j = i + 1; j < arr.length; j++) { //内层从i+1开始，到数组的最后一个位置，依次比较，如果当前数比min更小，则将内层的数换到min位置
                if (arr[j] < arr[min]) {
                    min = j;
                }
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }

        }
    }

    /**
     * 冒泡排序
     * 
     * 逐个交换，将最大的放到最后一个，依次类推
     *
     */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 1; i--) { //外层从数组的最后一个位置开始，依次递减，后面的位置是排序好的
            for (int j = 0; j < i; j++) {//内层从0开始，逐个比较，直到内层等于外层的时候结束，将最大的一个换到最后的位置
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j]; //交换对换位置
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
