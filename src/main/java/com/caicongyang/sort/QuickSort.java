package com.caicongyang.sort;

/**
 * 时间复杂度 O(NlogN) 空间负责度O（N）
 * 快速排序
 * 分治思想，递归实现方式
 *
 * 如果要排序数组中下标从 0 到 n 之间的一组数据，我们选择其中的任意数值为中间点p，讲大于p的移动到右边，小于p的移动到左边；不断的缩小左右两边的范围，直到所有的元素都已经有序
 *
 * 非原地算法，非稳定的算法
 * 原地算法：空间复杂度 =  O(1)
 * 稳定的算法：当两个相同的元素排序时，不导致该两个元素顺序的错乱
 *
 *
 * 快速排序与归并排序算法的区别：  快速排序属于从上到下；归并排序属于从下到上，先拆分再合并成一个有序队列
 *
 *
 *
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 12, 3, 12,};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    public static void quickSort2(int[] A, int first, int last) {
        if (first < last) {
            int x = A[last];
            int k = first;
            for (int i = first; i < last; i++) {
                if (A[i] < x) {
                    int tmp = A[k];
                    A[k] = A[i];
                    A[i] = tmp;
                    k++;
                }
            }
            int tmp = A[k];
            A[k] = A[last];
            A[last] = tmp;

            quickSort2(A, first, k - 1);
            quickSort2(A, k + 1, last);
        }
    }



    private static void quickSort(int[] arr, int first, int last) {
        if (first < last) {
            int x = arr[first];
            int i = first, j = last;
            //若大于基准元，则元素不动，j--
            while (i < j) {
                while (i < j && arr[j] > x) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }

                while (i < j && arr[i] < x) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quickSort(arr, first, i - 1);
            quickSort(arr, i + 1, last);

        }
    }
}


