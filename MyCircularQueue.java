
import java.util.Scanner;

public class MyCircularQueue {
    static int cq[];
    static int rear = -1, front = -1, size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int n = sc.nextInt();
        create(n);
        System.out.println("Queue is Ready...");
        while (true) {
            System.out.println("1.Insert");
            System.out.println("2.Delete");
            System.out.println("3.Traverse");
            System.out.println("4.Exit");

            System.out.println("Enter the Choice");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.println("Enter the element To Insert: ");
                int ele = sc.nextInt();
                insert(ele);
            } else if (ch == 2) {
                delete();
            } else if (ch == 3) {
                traverse();
            } else if (ch == 4) {
                System.out.println("End of Operations");
                break;
            } else {
                System.out.println("Ivalid Choice");
            }

        }

    }

    public static void create(int n) {
        System.out.println("Step 1: Creating a circular queue of size " + n);
        cq = new int[n];
        size = n;
        System.out.println("Step 2: Queue created.");
    }

    public static void insert(int ele) {
        System.out.println("Step 1: Attempting to insert element " + ele);
        if (isFull()) {
            System.out.println("Step 2: Queue is Full...");
        } else {
            if (rear == -1) {
                System.out.println("Step 2: Queue is empty, initializing front and rear to 0.");
                front = rear = 0;
            } else if (rear == size - 1) {
                System.out.println("Step 2: Rear reached end, wrapping around to 0.");
                rear = 0;
            } else {
                System.out.println("Step 2: Incrementing rear.");
                rear++;
            }
            System.out.println("Step 3: Inserting element " + ele + " at index " + rear);
            cq[rear] = ele;
            System.out.println("Step 4: Element is inserted..");
        }
    }

    public static void delete() {
        System.out.println("Step 1: Attempting to delete an element.");
        if (isEmpty()) {
            System.out.println("Step 2: Queue is Empty...");
        } else {
            System.out.println("Step 2: Deleted Element is : " + cq[front]);
            if (front == rear) {
                System.out.println("Step 3: Queue had only one element, resetting front and rear to -1.");
                front = rear = -1;
            } else if (front == size - 1) {
                System.out.println("Step 3: Front reached end, wrapping around to 0.");
                front = 0;
            } else {
                System.out.println("Step 3: Incrementing front.");
                front++;
            }
        }
    }

    public static void traverse() {
        System.out.println("Step 1: Attempting to traverse the queue.");
        if (isEmpty()) {
            System.out.println("Step 2: Queue is Empty..");
        } else {
            System.out.print("Step 2: Queue elements: ");

            if (front <= rear) {
                System.out.println("Step 3: Traversing from front to rear (no wrap-around).");
                for (int i = front; i <= rear; i++) {
                    System.out.print(cq[i] + " ");
                }
            } else {
                System.out.println("Step 3: Traversing with wrap-around.");
                for (int i = front; i < size; i++) {
                    System.out.print(cq[i] + " ");
                }
                for (int i = 0; i <= rear; i++) {
                    System.out.print(cq[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isFull() {
        System.out.println("Step 1: Checking if queue is full.");
        if ((front == 0 && rear == size - 1) || (front == rear + 1 % size)) {
            System.out.println("Step 2: Queue is full.");
            return true;
        } else {
            System.out.println("Step 2: Queue is not full.");
            return false;
        }
    }

    public static boolean isEmpty() {
        System.out.println("Step 1: Checking if queue is empty.");
        if (rear == -1) {
            System.out.println("Step 2: Queue is empty.");
            return true;
        } else {
            System.out.println("Step 2: Queue is not empty.");
            return false;
        }
    }
}