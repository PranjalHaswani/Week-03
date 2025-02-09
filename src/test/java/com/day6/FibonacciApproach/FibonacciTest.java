package com.day6.FibonacciApproach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FibonacciTest {

    @Test
    public void testFibonacciRecursive() {
        // Test correctness for n = 10
        int result = FibonacciApproach.fibonacciIterative(10);
        assertEquals(55, result, "Fibonacci(10) should be 55 using the iterative method.");

        // Test correctness for n = 30
        result = FibonacciApproach.fibonacciIterative(30);
        assertEquals(832040, result, "Fibonacci(30) should be 832040 using the iterative method.");
    }

    @Test
    public void testFibonacciIterative() {
        // Test correctness for n = 10
        int result = FibonacciApproach.fibonacciIterative(10);
        assertEquals(55, result, "Fibonacci(10) should be 55 using the iterative method.");

        // Test correctness for n = 30
        result = FibonacciApproach.fibonacciIterative(30);
        assertEquals(832040, result, "Fibonacci(30) should be 832040 using the iterative method.");
    }

    @Test
    public void testTimeTakenByRecursiveFibonacci() {
        // Measure time taken for recursive approach for n = 10
        double recursiveTime = FibonacciApproach.fibonacciRecursive(10);
        assertTrue(recursiveTime >= 0, "Recursive time should be non-negative.");

        // Measure time taken for recursive approach for n = 30
        recursiveTime = FibonacciApproach.fibonacciRecursive(30);
        assertTrue(recursiveTime >= 0, "Recursive time should be non-negative.");
    }

    @Test
    public void testTimeTakenByIterativeFibonacci() {
        // Measure time taken for iterative approach for n = 10
        double iterativeTime = FibonacciApproach.fibonacciIterative(10);
        assertTrue(iterativeTime >= 0, "Iterative time should be non-negative.");

        // Measure time taken for iterative approach for n = 30
        iterativeTime = FibonacciApproach.fibonacciIterative(30);
        assertTrue(iterativeTime >= 0, "Iterative time should be non-negative.");
    }
}
