package com.bizi.sort;

import com.alibaba.fastjson.JSON;

import static com.bizi.sort.SortUtil.noNeedToSort;
import static com.bizi.sort.SortUtil.swap;

public class BubbleSort {
    public static void sort(int[] arr){
        if(noNeedToSort(arr)){
            return ;
        }

        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }


    public static void cocktailSort(int[] arr){
        if(noNeedToSort(arr)){
            return;
        }

        int left = 0;
        int right = arr.length -1;

        while (left<right){
            for (int i=left;i<right;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
            right--;
            for (int i=right;i>left;i--){
                if(arr[i]<arr[i-1]){
                    swap(arr,i,i-1);
                }
            }
            left++;
        }


    }
    public static void main(String[] args) {
        int arr[] = {9,8,7,6,1,3,45,0};
        BubbleSort.sort(arr);
        System.out.println(JSON.toJSONString(arr));
        arr = new int[]{9, 8, 7, 6, 1, 3, 45, 0};
        BubbleSort.cocktailSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
