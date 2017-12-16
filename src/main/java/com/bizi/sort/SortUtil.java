package com.bizi.sort;

public abstract class SortUtil {
    public final static boolean noNeedToSort(int[] arr){
        if(arr == null || arr.length<2){
            return true;
        }
        return false;
    }
    public final static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
