package com.day2;

import java.util.Stack;

public class StockSpanProblem {
    //Function to calculate stock span for each day
    public static int[] calculateSpan(int[] prices){
        int n= prices.length;
        int[] span= new int[n];
        //Stack to store indices of prices in descending order
        Stack<Integer> stack= new Stack<>();

        //Traverse through all days
        for(int i=0; i<n;i++){
            //Pop elements from stack while the price at top of the stack is less than or equal to the current price
            while(!stack.isEmpty() && prices[stack.peek()]<=prices[i]){
                stack.pop();
            }
            //If the stack is empty, then the current price is greater than all price before it
            span[i]= (stack.isEmpty()) ? i+1:i- stack.peek();
            //Push the index of the current day's price to the stack
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        //Example stock prices
        int[] prices={100, 80, 60, 70, 60, 75, 85};
        //Calculate the span for each day
        int[] result= calculateSpan(prices);
        //Print the result
        for(int i=0; i< result.length; i++){
            System.out.println("Day "+ (i+1)+" span: "+ result[i]);
        }
    }
}
