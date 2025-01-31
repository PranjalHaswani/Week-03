package com.day2;

import java.util.Stack;

public class SortStackUsingRecursion {
//Function to sort stack
    public static void sortStack(Stack<Integer>stack){
        //if the stack is empty
        if(stack.isEmpty()){
            return;
        }
        //Pop the top element from the stack
        int temp= stack.pop();
        //Recursively sort the remaining stack
        sortStack(stack);
        //insert the popped element back in the position
        insertSorted(stack, temp);
    }
//Function to insert an element in the sorted
    public static void insertSorted(Stack<Integer>stack, int element){
        //If the stack is empty or the element is greater than the top, insert it
        if(stack.isEmpty() || element>=stack.peek()){
         stack.push(element);
         return;
    }
      //Pop the top element
      int top= stack.pop();
        //Recursively insert the element
        insertSorted(stack, element);
        //Push the popped element back to stack
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer>stack= new Stack<>();
        //Push elements to the stack
        stack.push(25);
        stack.push(84);
        stack.push(2);
        stack.push(31);
        stack.push(14);
        stack.push(4);
        stack.push(10);
        System.out.println("Original stack:" + stack);
        sortStack(stack);
        System.out.println("Sorted stack:" + stack);
    }
}
