/*
 Stack is a linear Data Structure.
 it is follows LIFO(Last In First Out).
 Initialy stack is having fixed size .
 its having Top value is -1.
 */


import java.util.Scanner;

public class MyStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 5;
        int[] stack = new int[size];
        int top = -1;
        while (true) {
            System.out.println("1.push");
            System.out.println("2.pop");
            System.out.println("3.peek");
            System.out.println("4.Traverse");
            System.out.println("5.exit");

            System.out.println("Enter your Choice :");
            int ch = sc.nextInt();

            if (ch == 1) {
                if (top == size - 1) {
                    System.out.println("Stack is Full");
                } else {
                    System.out.println("Enter the Element to push : ");
                    int ele = sc.nextInt();
                    ++top;
                    stack[top] = ele;
                    System.out.println("Element pushed Successfully");
                }
            } else if (ch == 2) {
                if (top == -1) {
                    System.out.println("Stack is Empty");
                } else {
                    System.out.println("Deleted Element : " + stack[top]);
                    top--;
                }
            } else if (ch == 3) {
                if (top == -1) {
                    System.out.println("Stack is Empty");
                } else {
                    System.out.println("Peek Element : " + stack[top]);
                }
            } else if (ch == 4) {
                if (top == -1) {
                    System.out.println("Stack is Empty...");
                } else {
                    System.out.println("Stack Elements are ");
                    for (int i = top; i >= 0; i--) {
                        System.out.println(stack[i]);
                    }
                }
            } else if (ch == 5) {
                System.out.println("End of the Stack operations");
                break;
            } else {
                System.out.println("Invalid Choice");
            }

        }

        sc.close();
    }
}