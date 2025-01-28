package com.day1;
class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head;
    private Process tail;
    private int totalProcesses;
    private int totalWaitTime;
    private int totalTurnaroundTime;

    public RoundRobinScheduler() {
        head = null;
        tail = null;
        totalProcesses = 0;
        totalWaitTime = 0;
        totalTurnaroundTime = 0;
    }

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;  // Point to itself to form a circular linked list
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;  // Point to head to form a circular linked list
        }
        totalProcesses++;
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("Process list is empty.");
            return;
        }

        Process temp = head;
        Process prev = null;

        // Check if head is the process to be removed
        if (head.processId == processId) {
            if (head == tail) { // Only one process in the list
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // Update the tail to point to the new head
            }
            totalProcesses--;
            return;
        }

        // Search for the process in the list
        do {
            prev = temp;
            temp = temp.next;
            if (temp.processId == processId) {
                prev.next = temp.next;
                if (temp == tail) {
                    tail = prev;
                }
                totalProcesses--;
                return;
            }
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    // Simulate round-robin scheduling
    public void simulateRoundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;

        // Keep running until all processes are finished
        while (totalProcesses > 0) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= executionTime;
                time += executionTime;

                System.out.println("Executing Process ID: " + current.processId + " for " + executionTime + "ms");

                // Calculate waiting time and turnaround time
                if (current.remainingTime == 0) {
                    int turnaroundTime = time;
                    int waitTime = turnaroundTime - current.burstTime;
                    totalWaitTime += waitTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process ID: " + current.processId + " finished. Wait Time: " + waitTime + "ms, Turnaround Time: " + turnaroundTime + "ms");
                    removeProcess(current.processId); // Process finished, remove it
                }
            }

            // Move to the next process in the circular queue
            current = current.next;
            displayProcesses();
        }
    }

    // Display all processes in the circular queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.print("Processes in the queue: ");
        do {
            System.out.print("[Process ID: " + temp.processId + ", Remaining Time: " + temp.remainingTime + "ms] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Calculate and display the average waiting time and turnaround time
    public void displayAverageTimes() {
        if (totalProcesses == 0) {
            System.out.println("No processes to calculate times.");
            return;
        }
        double avgWaitTime = (double) totalWaitTime / totalProcesses;
        double avgTurnaroundTime = (double) totalTurnaroundTime / totalProcesses;
        System.out.println("Average Waiting Time: " + avgWaitTime + "ms");
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime + "ms");
    }
}

public class Main {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 3);

        // Display processes before scheduling
        scheduler.displayProcesses();

        // Simulate round-robin scheduling with a time quantum of 4ms
        scheduler.simulateRoundRobin(4);

        // Display average waiting time and turnaround time
        scheduler.displayAverageTimes();
    }
}

