package com.caicongyang.sort;

/**
 * 
 * 
 * @author caicongyang1
 * @version $Id: AdvancedSort.java, v 0.1 2016年6月2日 上午10:41:56 caicongyang1 Exp $
 */
public class AdvancedSort {

    public static void main(String[] args) {
        int[] arr = { 10, 4, 5, 7, 2, 3, 8 };
        shellSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    
    
    /**
     * 希尔排序
     * 在插入排序的基础上升级改进而来，通过减少移动位置来提高效率
     * 
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1; //Knuth 序列 即间隔序列
        }
        while (h > 0) {
            for (int i = h; i < arr.length; i++) {//对数据进行间隔为h的增量排序，
                //以10个成语的数组为例，第一次按照间隔为4的排序，0和4和8排序，1、5、9排序，2、6排序，3，7排序，得到4个有序的子数组
                int temp = arr[i];
                int j = i;
                while (j > h - 1 && arr[j - h] >= temp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = temp;
            }
            h = (h - 1) / 3;
            //依次减小序列,10个成员的数组现在按间隔为1，做普通插入排序，（现在如果把第二个while内的h换成1就是一个普通的插入排序）
        }

    }

}
