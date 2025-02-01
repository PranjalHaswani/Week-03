package com.day3;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int score[]= {10,99,52,64,77,12,3};
        //Selection sort
        for(int i=0; i<score.length-1; i++){
            int smallest=i;
            for(int j=i+1; j< score.length;j++){
                if(score[smallest]>score[j]){
                    smallest=j;
                }
            }
            //Finding smallest or minimum element in the array
            int temp=score[smallest];
            score[smallest]= score[i];
            score[i]= temp;
        }
        //Display the sorted array in ascending order
        System.out.println(Arrays.toString(score));
    }
}
