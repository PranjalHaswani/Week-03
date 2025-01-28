package com.day1;
import java.util.*;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }

    // Getter methods
    public String getItemName() {
        return itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class InventoryManagement {
    private Item head;

    public InventoryManagement() {
        head = null;
    }

    // Add an item at the beginning
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add an item at a specific position
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            newItem.next = temp.next;
            temp.next = newItem;
        } else {
            System.out.println("Position out of bounds.");
        }
    }

    // Remove an item by Item ID
    public void removeItemById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    // Update the quantity of an item by Item ID
    public void updateItemQuantityById(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity of item with ID " + itemId + " updated to " + newQuantity);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item ID
    public void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item by Item Name
    public void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with name " + itemName + " not found.");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalInventoryValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Merge Sort to sort items based on a comparison criteria
    private Item mergeSort(Item head, Comparator<Item> comparator) {
        if (head == null || head.next == null) {
            return head;
        }

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;

        middle.next = null;

        Item left = mergeSort(head, comparator);
        Item right = mergeSort(nextOfMiddle, comparator);

        return merge(left, right, comparator);
    }

    // Get the middle element of the linked list
    private Item getMiddle(Item head) {
        if (head == null) {
            return null;
        }
        Item slow = head;
        Item fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    // Merge two sorted linked lists
    private Item merge(Item left, Item right, Comparator<Item> comparator) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (comparator.compare(left, right) <= 0) {
            left.next = merge(left.next, right, comparator);
            left.next.next = null;
            return left;
        } else {
            right.next = merge(left, right.next, comparator);
            return right;
        }
    }

    // Sort the inventory based on Item Name or Price
    public void sortInventory(String criterion, boolean ascending) {
        Comparator<Item> comparator;
        if (criterion.equalsIgnoreCase("name")) {
            comparator = Comparator.comparing(Item::getItemName);
        } else if (criterion.equalsIgnoreCase("price")) {
            comparator = Comparator.comparingDouble(Item::getPrice);
        } else {
            System.out.println("Invalid sorting criterion.");
            return;
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        head = mergeSort(head, comparator);
    }

    // Display all items in the inventory
    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Item: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Add some items to the inventory
        inventory.addItemAtEnd("Laptop", 101, 10, 500.00);
        inventory.addItemAtEnd("Phone", 102, 15, 300.00);
        inventory.addItemAtEnd("Headphones", 103, 25, 50.00);
        inventory.addItemAtBeginning("Keyboard", 104, 5, 80.00);

        // Display all items
        System.out.println("All Inventory Items:");
        inventory.displayAllItems();

        // Update item quantity
        inventory.updateItemQuantityById(102, 20);

        // Search items
        inventory.searchItemById(103);
        inventory.searchItemByName("Phone");

        // Calculate total value of the inventory
        inventory.calculateTotalInventoryValue();

        // Sort items by name in ascending order
        inventory.sortInventory("name", true);
        System.out.println("\nSorted Inventory by Name (Ascending):");
        inventory.displayAllItems();

        // Remove item by ID
        inventory.removeItemById(101);
        System.out.println("\nInventory After Removal:");
        inventory.displayAllItems();

        // Sort items by price in descending order
        inventory.sortInventory("price", false);
        System.out.println("\nSorted Inventory by Price (Descending):");
        inventory.displayAllItems();
    }
}
