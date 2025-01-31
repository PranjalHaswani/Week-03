package com.day2;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    //Function to find the max in each sliding window of size k
    public static int[] slidingWindowMax(int[] nums, int k){
        if(nums == null || nums.length==0 || k==0){
            return new int[0];
        }

        int n= nums.length;
        int[] result= new int[n-k+1];
        //Deque to store indices of useful elements
        Deque<Integer> deque= new LinkedList<>();

        for(int i=0; i<n; i++){
            //Remove indices that are out of the current window
            while(!deque.isEmpty() && deque.peek()<=i-k){
                deque.poll();
            }
            // Remove indices whose corresponding values are less than the current element
            // because they will not be the maximum in future windows
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.offer(i);

            // If the window has at least k elements, add the max element (front of deque) to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example input array and window size k
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Get the maximum elements in each sliding window
        int[] result = slidingWindowMax(nums,k);

        // Print the result
        System.out.println("Maximums in each sliding window:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
