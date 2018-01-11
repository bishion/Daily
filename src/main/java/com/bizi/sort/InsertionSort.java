package com.bizi.sort;

import com.alibaba.fastjson.JSON;
/**
 * 对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，找到相应位置并插入。

 　　插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

 　　具体算法描述如下：

 从第一个元素开始，该元素可以认为已经被排序
 取出下一个元素，在已经排序的元素序列中从后向前扫描
 如果该元素（已排序）大于新元素，将该元素移到下一位置
 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 将新元素插入到该位置后
 重复步骤2~5
 */
import static com.bizi.sort.SortUtil.noNeedToSort;

// 分类 ------------- 内部比较排序
// 数据结构 ---------- 数组
// 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
// 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
// 平均时间复杂度 ---- O(n^2)
// 所需辅助空间 ------ O(1)
// 稳定性 ------------ 稳定
public class InsertionSort {
    public static void sort(int[] arr) {
        if (noNeedToSort(arr)) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void dichotomySort(int[] arr) {
        if (noNeedToSort(arr)) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int left = 0;
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            arr[left] = temp;
        }


    }

    public static void shellSort(int[] arr) {
        int h = 0;
        while (h <= arr.length) {
            h = 3*h+1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                int j = i - h;
                int get = arr[i];
                while (j >= 0 && arr[j] > get) {
                    arr[j + h] = arr[j];
                    j = j - h;
                }
                arr[j + h] = get;
            }
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 6, 1, 3, 45, 0};
        sort(arr);
        System.out.println(JSON.toJSONString(arr));
        arr = new int[]{9, 8, 7, 6, 1, 3, 45, 0};
        dichotomySort(arr);
        System.out.println(JSON.toJSONString(arr));
        arr = new int[]{9, 8, 7, 6, 1, 3, 45, 0};
        shellSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
