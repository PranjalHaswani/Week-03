package com.day1;
class TextState {
    String text;
    TextState next;
    TextState prev;

    public TextState(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState currentState;
    private int maxHistorySize;
    private int historySize;
    private TextState head;
    private TextState tail;

    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.historySize = 0;
        this.head = null;
        this.tail = null;
        this.currentState = null;
    }

    // Add a new text state after an action (like typing a word)
    public void addState(String text) {
        TextState newState = new TextState(text);

        // If the history is full, remove the oldest state
        if (historySize == maxHistorySize) {
            head = head.next;
            head.prev = null;
            historySize--;
        }

        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
        }
        currentState = newState;

        // If this is the first state
        if (head == null) {
            head = newState;
        }

        if (tail == null) {
            tail = newState;
        }

        historySize++;
    }

    // Undo: Revert to the previous state
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.text);
        } else {
            System.out.println("No previous state to undo.");
        }
    }

    // Redo: Revert back to the next state after undo
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.text);
        } else {
            System.out.println("No next state to redo.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.text);
        } else {
            System.out.println("No text available.");
        }
    }

    // Display the entire history of text states
    public void displayHistory() {
        TextState temp = head;
        while (temp != null) {
            System.out.println(temp.text);
            temp = temp.next;
        }
    }
}

public class UndoRedo{
    public static void main(String[] args) {
        // Create a text editor with a history size of 5
        TextEditor editor = new TextEditor(5);

        // Add some text states
        editor.addState("Hello");
        editor.addState("Hello, world");
        editor.addState("Hello, world!");
        editor.addState("Hello, world! How are you?");
        editor.addState("Hello, world! How are you doing today?");
        editor.displayCurrentState();

        // Undo and Redo operations
        editor.undo();
        editor.undo();
        editor.redo();
        editor.redo();

        // Add more states
        editor.addState("Hello, world! How are you doing today? It's a great day!");

        // Display the history
        editor.displayHistory();
    }
}

