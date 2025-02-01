package com.day3;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n= arr.length;
        boolean swapped;
        for(int i=0; i<n-1;i++){
            swapped= false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    //Swap arr[j] and arr[j+1]
                    int temp= arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]= temp;
                    swapped= true;
                }
            }
            //Stop if no swaps occurred
            if(!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr={95,52,13,46,62,10,22};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
