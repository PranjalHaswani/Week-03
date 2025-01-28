package com.day1;

//Single Linked List
class Student{
    int RollNo;
    String name;
    int age;
    char Grade;
    Student next;
    public Student(int RollNo, String name, int age, char Grade){
        this.RollNo= RollNo;
        this.name= name;
        this.age= age;
        this.Grade= Grade;
        this.next= null;
    }
}
class StudentList {
    public Student head;

    //Constructor initializes the linked list to be empty
    public StudentList() {
        head = null;
    }

    //Add a student record at the beginning
    public void addStudentAtBeginning(int RollNo, String name, int age, char Grade) {
        Student newStudent = new Student(RollNo, name, age, Grade);
        newStudent.next = head;
        head = newStudent;
    }

    //Add a student record at the end
    public void addStudentAtEnd(int RollNo, String name, int age, char Grade) {
        Student newStudent = new Student(RollNo, name, age, Grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        //Traverse to the last node and update next pointer
        Student current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newStudent;
    }

    //Add a student at a specific position
    public void addStudentAtPosition(int position, int RollNo, String name, int age, char Grade) {
        if (position < 1) {
            System.out.println("Invalid position");
            return;
        }
        Student newStudent = new Student(RollNo, name, age, Grade);
        if (position == 1) {
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
        } else {
            newStudent.next = current.next;
            current.next = newStudent;
        }
    }

    // Delete a student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.RollNo == rollNumber) {
            head = head.next;
            return;
        }
        Student current = head;
        while (current.next != null && current.next.RollNo != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Search for a student by roll number
    public Student searchByRollNumber(int rollNumber) {
        Student current = head;
        while (current != null) {
            if (current.RollNo == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.println("Roll Number: " + current.RollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.Grade);
            current = current.next;
        }
    }

    // Update a student's grade
    public void updateGrade(int RollNo, char newGrade) {
        Student student = searchByRollNumber(RollNo);
        if (student != null) {
            student.Grade = newGrade;
            System.out.println("Grade updated for Roll Number " + RollNo);
        } else {
            System.out.println("Student with Roll Number " + RollNo + " not found.");
        }
    }
}
    public class StudentManagementSystem{
        public static void main(String[] args) {
            StudentList studentList = new StudentList();

            // Add student records
            studentList.addStudentAtBeginning(1, "John Doe", 20, 'A');
            studentList.addStudentAtEnd(2, "Jane Smith", 22, 'B');
            studentList.addStudentAtEnd(3, "Alice Johnson", 21, 'C');
            studentList.addStudentAtPosition(4, 4, "Pranjal", 18, 'D');

            System.out.println("All student records:");
            studentList.displayAllRecords();

            // Search for a student by roll number
            Student student = studentList.searchByRollNumber(2);
            if (student != null) {
                System.out.println("\nFound student with Roll Number 2: " + student.name);
            } else {
                System.out.println("Student with Roll Number 2 not found.");
            }

            // Update student's grade
            studentList.updateGrade(2, 'A');

            // Display records after grade update
            System.out.println("\nStudent records after grade update:");
            studentList.displayAllRecords();

            // Delete a student record by roll number
            studentList.deleteByRollNumber(3);

            // Display records after deletion
            System.out.println("\nStudent records after deletion:");
            studentList.displayAllRecords();
        }
    }


