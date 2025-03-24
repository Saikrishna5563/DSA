import java.util.Scanner;

public class MyQueue {
    static int size = 5;       // Maximum size of the queue
    static int queue[] = new int[size]; // Array to store queue elements
    static int rear = 0;      // Index of the next available position at the rear of the queue
    static int front = 0;     // Index of the front element in the queue (not strictly used for deletion in this implementation)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner object to get user input

        while (true) { // Infinite loop to display the menu and perform operations
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Traverse");
            System.out.println("4.End");

            System.out.println("Enter your choice :");
            int ch = sc.nextInt(); // Read the user's choice

            if (ch == 1) { // Insertion operation
                if (rear == size) { // Check if the queue is full
                    System.out.println("Queue is Full...");
                } else {
                    System.out.print("Enter the Element: ");
                    int ele = sc.nextInt(); // Read the element to be inserted
                    queue[rear] = ele;    // Insert the element at the rear
                    rear++;             // Increment the rear index
                    System.out.println("Element is inserted succesfully....");
                }

            } else if (ch == 2) { // Deletion operation
                if (rear == 0) { // Check if the queue is empty
                    System.out.println("queue is Empty...");
                } else {
                    System.out.println("Deleted Element :" + queue[front]); // Print the element being deleted (at the front)
                    // Shift elements to the left to simulate deletion
                    for (int i = 0; i < rear - 1; i++) {
                        queue[i] = queue[i + 1];
                    }
                    rear--;             // Decrement the rear index
                }

            } else if (ch == 3) { // Traversal operation
                if (rear == 0) { // Check if the queue is empty
                    System.out.println("queue is Empty");
                } else {
                    System.out.println("Elements are :");
                    for (int i = 0; i < rear; i++) { // Iterate through the queue and print elements
                        System.out.println(queue[i]);
                    }
                }
            } else if (ch == 4) { // End operation
                System.out.println("End of operations");
                break;             // Exit the loop
            } else { // Invalid choice
                System.out.println("Invalid choice");
            }
        }
        sc.close(); // Close the scanner to prevent resource leaks.
    }
}
/*
Explanation:

This Java program implements a basic queue data structure using an array.
A queue is a FIFO (First-In, First-Out) data structure, where the element
inserted first is the first one to be removed.

Key Components:
1.  Class:
    * MyQueue: The main class that contains the queue implementation.

2.  Static Variables:
    * size:  The maximum size of the queue (fixed at 5).
    * queue: An integer array to store the queue elements.
    * rear:   An integer that points to the index where the next element will be inserted.
    * front:  An integer that points to the index of the front element.
               (In this implementation, 'front' is not strictly used for deletion.
               The element at index 0 is always considered the front.)

3.  main Method:
    * The entry point of the program.
    * Creates a Scanner object to read user input.
    * Enters an infinite loop to provide a menu-driven interface.

4.  Menu:
    * The program displays a menu with the following options:
        * 1. Insert:  Insert an element into the queue.
        * 2. Delete:  Remove an element from the queue.
        * 3. Traverse: Display the elements in the queue.
        * 4. End:     Exit the program.

5.  Insert Operation (Case 1):
    * Checks if the queue is full (rear == size).
    * If the queue is not full, it prompts the user to enter an element,
        inserts the element at the 'rear' position in the array,
        and increments 'rear'.

6.  Delete Operation (Case 2):
    * Checks if the queue is empty (rear == 0).
    * If the queue is not empty, it prints the element at the 'front'
        (which is always at index 0 in this implementation).
    * It then shifts all the remaining elements one position to the left
        in the array to simulate deletion.
    * Finally, it decrements 'rear'.

7.  Traverse Operation (Case 3):
    * Checks if the queue is empty (rear == 0).
    * If the queue is not empty, it iterates through the array from
        index 0 to 'rear - 1' and prints each element.

8.  End Operation (Case 4):
    * Prints "End of operations" and breaks the loop, terminating
        the program.

9.  Invalid Choice:
    * If the user enters an invalid choice, it prints "Invalid choice".

Important Points:
* This implementation uses an array to store the queue elements, which
    has a fixed size.
* The 'front' variable is not used to track the front of the queue
    efficiently.  The element at index 0 is always considered the front.
* Deletion is implemented by shifting the remaining elements to the left,
    which is not the most efficient approach (O(n) time complexity).
    A circular array or linked list would provide better performance.
* The Scanner is closed after use to prevent resource leaks.
*/
