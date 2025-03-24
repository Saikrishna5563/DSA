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

