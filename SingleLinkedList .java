
import java.util.Scanner; // Importing Scanner for user input

/**
 * SingleLinkedList - A Java implementation of a Singly Linked List with basic operations:
 * - Append (Add to the end)
 * - Display (Print all elements)
 * - Length (Count number of nodes)
 * - AddFirst (Insert at the beginning)
 * - AddAfter (Insert after a specific position)
 * - Exit (Terminate program)
 */
public class SingleLinkedList {
    static Node root = null; // Head node (starting point of the list)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu-driven program for linked list operations
        while (true) {
            System.out.println("\n---- Singly Linked List Operations ----");
            System.out.println("1. Append");
            System.out.println("2. Display");
            System.out.println("3. Length");
            System.out.println("4. Add First");
            System.out.println("5. Add After");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int ch = sc.nextInt();

            // Performing operations based on user input
            if (ch == 1) {
                System.out.print("Enter the element to append: ");
                int ele = sc.nextInt();
                append(ele);
            } 
            else if (ch == 2) {
                display();
            } 
            else if (ch == 3) {
                int count = length();
                System.out.println("Total nodes in the list: " + count);
            } 
            else if (ch == 4) {
                System.out.print("Enter element to add at the first position: ");
                int ele = sc.nextInt();
                addFirst(ele);
            } 
            else if (ch == 5) {
                System.out.print("Enter the position after which you want to add: ");
                int loc = sc.nextInt();
                System.out.print("Enter the element to add: ");
                int ele = sc.nextInt();
                addAfter(loc, ele);
            } 
            else if (ch == 6) {
                System.out.println("Exiting... Thank you!");
                break;
            } 
            else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        sc.close(); // Close scanner to prevent memory leaks
    }

    /**
     * Append - Adds a new node to the end of the linked list.
     * @param ele The element to be added.
     */
    static void append(int ele) {
        Node temp = new Node(); // Creating a new node
        temp.data = ele;
        
        if (root == null) {
            root = temp; // If list is empty, make this the first node
        } else {
            Node last = root;
            while (last.link != null) { // Traverse to the last node
                last = last.link;
            }
            last.link = temp; // Append new node at the end
        }
        System.out.println("Element " + ele + " appended to the list.");
    }

    /**
     * Display - Prints all the elements in the linked list.
     */
    static void display() {
        if (root == null) {
            System.out.println("List is empty.");
        } else {
            Node temp = root;
            System.out.print("Linked List: ");
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.link;
            }
            System.out.println("null");
        }
    }

    /**
     * Length - Returns the total number of nodes in the linked list.
     * @return The count of nodes.
     */
    static int length() {
        int count = 0;
        Node temp = root;
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        return count;
    }

    /**
     * AddFirst - Inserts a new node at the beginning of the linked list.
     * @param ele The element to be added.
     */
    static void addFirst(int ele) {
        Node temp = new Node();
        temp.data = ele;
        temp.link = root; // New node points to the previous first node
        root = temp; // New node becomes the head
        System.out.println("Element " + ele + " added at the first position.");
    }

    /**
     * AddAfter - Inserts a new node after a specific position.
     * @param loc The position after which the new node should be inserted.
     * @param ele The element to be inserted.
     */
    static void addAfter(int loc, int ele) {
        int len = length();
        if (loc >= 1 && loc <= len) {
            int i = 1;
            Node target = root;
            while (i < loc) { // Traverse to the target position
                target = target.link;
                i++;
            }
            Node temp = new Node();
            temp.data = ele;
            temp.link = target.link; // Insert new node after target
            target.link = temp;
            System.out.println("Element " + ele + " added after position " + loc);
        } else {
            System.out.println("Invalid position! List has only " + len + " nodes.");
        }
    }
}

/**
 * Node - Represents a node in the singly linked list.
 */
class Node {
    int data;  // Data stored in the node
    Node link; // Reference to the next node
}
