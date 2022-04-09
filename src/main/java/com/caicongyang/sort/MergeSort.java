package com.caicongyang.sort;

/**
 *  时间复杂度 O(NlogN)  空间复杂度 O(n)
 * 归并排序
 * 分支思想： 讲一个大的待排序的数组分成左右两个待排序的数组，当左右两边的数组都应排序以后，再合并
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 2, 6, 3, 4};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            //进行合并
            mergeArray(arr, low, mid, high);
        }
    }

    //对有序数组的合并
    private static void mergeArray(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        int[] arr2 = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                arr2[k++] = arr[i++];
            } else {
                arr2[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            arr2[k++] = arr[i++];
        }
        while (j <= high) {
            arr2[k++] = arr[j++];
        }

        i = low;
        for (k = 0; k < arr2.length; k++) {
            arr[i] = arr2[k];
            i++;
        }
    }
}


