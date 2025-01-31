package com.day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraysWithZeroSum {
    //Method to find all subarrays whose sum is zero
    public static List<int[]> findZeroSumSuarrays(int[] arr){
        List<int[]> result= new ArrayList<>();
        HashMap<Integer, Integer> cumulativeSumMap= new HashMap<>();
        int cumulativeSum= 0;

        //Loop through the array
        for(int i=0; i<arr.length; i++){
            cumulativeSum += arr[i];
            //If cumulative sum is zero, we have a subarray from index 0 to i
            if(cumulativeSum==0){
                result.add(subArray(arr,0,i));
            }
            //If cumulative sum has been seen before, we found a subarray with sum zero
            if(cumulativeSumMap.containsKey(cumulativeSum)) {
                //Get the previous index where the cumulative sum was found
                int previousIndex = cumulativeSumMap.get(cumulativeSum);
                result.add(subArray(arr,previousIndex+1, i));
            }
            //Store the cumulative sum with its index
            cumulativeSumMap.put(cumulativeSum,i);
        }
        return result;
    }
    //Helper function to extract the subarray from start and end index
    private static int[] subArray(int[] arr, int start, int end){
        int[] subArray= new int[end - start+1];
        System.arraycopy(arr, start, subArray,0,end-start+1);
        return subArray;
    }
    //Main method to test the solution
    public static void main(String[] args) {
        int[] arr= {2,5,-4,5,-6,7,-1,-3,-4,4,5};
        //Find and print all subarrays with sum zero
        List<int[]> zeroSumSubarrays= findZeroSumSuarrays(arr);
        System.out.println("Zero sum subarrays:");
        for (int[] subArray : zeroSumSubarrays){
            for(int num: subArray){
                System.out.println(num+ " ");
            }
            System.out.println();
        }
    }
}
