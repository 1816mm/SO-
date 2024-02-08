package lab2;

import java.util.Scanner;

public class Menu {
    CustomStack stack;
    HardPoint hardPoint;

    public Menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many elements: ");
        int capacity = scanner.nextInt();
        stack = new CustomStack(capacity);

        // Initialize knows data
        boolean[][] knowsData = new boolean[capacity][capacity];
        // Populate knowsData with appropriate values here

        // Initialize HardPoint with knowsData
        hardPoint = new HardPoint(capacity, knowsData);

        openMenu();
    }

    public void openMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n-- Menu --");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Peek");
        System.out.println("4. Is empty");
        System.out.println("5. Is full");
        System.out.println("6. View stack");
        System.out.println("7. Find Celebrity"); // Add the option to find the celebrity
        System.out.println("--> Choose option: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1 -> this.choose1Option();
            case 2 -> this.choose2Option();
            case 3 -> this.choose3Option();
            case 4 -> this.choose4Option();
            case 5 -> this.choose5Option();
            case 6 -> this.choose6Option();
            case 7 -> this.findCelebrityOption(); // Handle the option to find the celebrity
            default -> {
                System.out.println("Ueee, choose a real option!");
                openMenu();
            }
        }

        openMenu();
    }

    public void choose1Option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Push element: ");
        int element = scanner.nextInt();
        stack.push(element);
    }

    public void choose2Option() {
        stack.pop();
    }

    public void choose3Option() {
        stack.peek();
    }

    public void choose4Option() {
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is empty: " + isEmpty);
    }

    public void choose5Option() {
        boolean isFull = stack.isFull();
        System.out.println("Is full: " + isFull);
    }

    public void choose6Option() {
        stack.view();
    }

    public void findCelebrityOption() {
        if (hardPoint.solution != -1) {
            System.out.println("The celebrity is person " + hardPoint.solution);
        } else {
            System.out.println("No celebrity found.");
        }
    }
}
