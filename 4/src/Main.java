import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarInformationSystem carSystem = new CarInformationSystem();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            System.out.println("Menu:");
            System.out.println("1. Add a car");
            System.out.println("2. Show all cars");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer after inputting a number

            switch (choice) {
                case 1 -> carSystem.addCar();
                case 2 -> carSystem.showAllCars();
                case 3 -> System.out.println("Program terminated.");
                default -> System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}