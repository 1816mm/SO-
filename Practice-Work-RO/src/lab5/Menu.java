package lab5;

import java.util.Scanner;
public class Menu {
    private static MinHeap minHeap = new MinHeap();
    private static Scanner scanner = new Scanner(System.in);

    public Menu() {
        while (true) {
            System.out.println("------ Heap Menu ------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Heap");
            System.out.println("5. Find min cost");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to push: ");
                    int valueToPush = scanner.nextInt();
                    minHeap.push(valueToPush);
                    System.out.println(valueToPush + " pushed into the heap.");
                    break;

                case 2:
                    Integer poppedValue = minHeap.pop();
                    if (poppedValue != null) {
                        System.out.println("Popped value: " + poppedValue);
                    } else {
                        System.out.println("Heap is empty. Cannot pop.");
                    }
                    break;

                case 3:
                    Integer peekedValue = minHeap.peek();
                    if (peekedValue != null) {
                        System.out.println("Peeked value: " + peekedValue);
                    } else {
                        System.out.println("Heap is empty. Cannot peek.");
                    }
                    break;

                case 4:
                    Integer[] heapArray = minHeap.getHeap().toArray(new Integer[0]);

                    System.out.print("Current Heap: ");
                    for (Integer value : heapArray) {
                        System.out.print(value + " ");
                    }
                    System.out.print("\n");
                    break;

                case 5:
                    int minCost = minHeap.findMinCost();
                    System.out.println("Min cost: " + minCost);
                    break;

                case 6:
                    System.out.println("Exiting the program. Bye!");
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
