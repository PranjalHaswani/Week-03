package com.day2;
import java.util.Stack;
class QueueUsingTwoStacks {
    //Stack for enqueue operation
    private Stack<Integer> stack1;
    //Stack for dequeue operation
    private Stack<Integer> stack2;

    //Constructor for initialization
    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //Enqueue operation: Push into stack1
    public void enqueue(int val) {

        stack1.push(val);
    }

    //Dequeue operation: Pop from stack2
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        //If stack2 is empty after transfer, the queue is empty
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        //Pop the front elements from stack2
        return stack2.pop();
    }

    //Check if the queue is empty
    public boolean isEmpty()
    {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    //Peek the front element of the queue without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            //Transfer elements if stack2 is empty
            while (!stack1.isEmpty()) {
                stack2.push((stack1.pop()));
            }
        }
        //if stack2 is empty after the transfer, the queue is empty
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack2.peek();
    }

}
public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        QueueUsingTwoStacks queue= new QueueUsingTwoStacks();
    //Enqueue some elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

    //Dequeue and print
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //Peek the front element
        System.out.println(queue.peek());
        //Dequeue the last element
        System.out.println(queue.dequeue());
        //Check if the queue is empty
        System.out.println(queue.isEmpty());
    }
}
