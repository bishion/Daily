package com.bizi.sort;

import com.alibaba.fastjson.JSON;

import static com.bizi.sort.SortUtil.noNeedToSort;
import static com.bizi.sort.SortUtil.swap;

public class SelectionSort {
    public static void sort(int[] arr){
        if(noNeedToSort(arr)){
            return;
        }

        for (int i =0;i<arr.length -1;i++){
            int min = i;
            for (int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min !=i){
                swap(arr,min,i);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,8,7,6,1,3,45,0};
        sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }

}
