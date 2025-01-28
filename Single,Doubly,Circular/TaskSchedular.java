package com.day1;
import java.util.Date;

class Task {
    int taskId;
    String taskName;
    int priority;
    Date dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, Date dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    Task head;

    public CircularTaskList() {
        head = null;
    }

    // Add a task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;  // Points to itself to create a circular structure
        } else {
            Task temp = head;
            while (temp.next != head) {  // Traverse to the last node
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;  // New task points to head to maintain circular structure
            head = newTask;  // Update head to new task
        }
    }

    // Add a task at the end
    public void addAtEnd(int taskId, String taskName, int priority, Date dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;  // Points to itself to create a circular structure
        } else {
            Task temp = head;
            while (temp.next != head) {  // Traverse to the last node
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;  // New task points to head to maintain circular structure
        }
    }

    // Add a task at a specific position
    public void addAtPosition(int taskId, String taskName, int priority, Date dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task temp = head;
        for (int i = 0; i < position - 1 && temp != null && temp.next != head; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Task temp = head;
        Task prev = null;

        // If the task to be removed is the head
        if (temp.taskId == taskId) {
            if (temp.next == head) {  // Only one task in the list
                head = null;
            } else {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                head = temp.next;
                prev.next = head;  // Maintain circular structure
            }
            return;
        }

        // Search for the task to be removed
        while (temp.next != head && temp.taskId != taskId) {
            prev = temp;
            temp = temp.next;
        }

        if (temp.taskId == taskId) {
            prev.next = temp.next;
            System.out.println("Task with ID " + taskId + " removed.");
        } else {
            System.out.println("Task not found.");
        }
    }

    // View the current task and move to the next task in the circular list
    public void viewCurrentAndNextTask() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Current Task: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Display all tasks in the list starting from the head node
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskName + ", Task ID: " + temp.taskId + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with Priority " + priority);
        }
    }
}

public class TaskSchedular {
    public static void main(String[] args) {
        CircularTaskList taskList = new CircularTaskList();

        // Add tasks to the list
        taskList.addAtEnd(1, "Complete Java Assignment", 2, new Date());
        taskList.addAtEnd(2, "Prepare for meeting", 1, new Date());
        taskList.addAtEnd(3, "Write report", 3, new Date());
        taskList.addAtBeginning(4, "Review code", 2, new Date());
        taskList.addAtPosition(5, "Fix bugs", 1, new Date(), 2);

        // Display all tasks
        System.out.println("All Tasks:");
        taskList.displayAllTasks();

        // View current task and move to next task
        System.out.println("\nViewing current task and next task:");
        taskList.viewCurrentAndNextTask();

        // Search tasks by priority
        System.out.println("\nSearch tasks with priority 1:");
        taskList.searchByPriority(1);

        // Remove a task by task ID
        taskList.removeByTaskId(2);

        // Display all tasks after removal
        System.out.println("\nAll Tasks after removal:");
        taskList.displayAllTasks();
    }
}
