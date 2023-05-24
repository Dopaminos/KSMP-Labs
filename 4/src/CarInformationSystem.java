import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarInformationSystem {
    private List<Car> cars;
    private Scanner scanner;

    public CarInformationSystem() {
        cars = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addCar() {
        System.out.println("Enter car brand: ");
        String brand = scanner.nextLine();
        System.out.println("Enter car model: ");
        String model = scanner.nextLine();
        System.out.println("Enter car year: ");
        int year = scanner.nextInt();
        System.out.println("Enter car price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer after inputting a number

        Car car = new Car(brand, model, year, price);
        cars.add(car);

        System.out.println("Car successfully added.");
    }

    public void showAllCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            System.out.println("Information about cars:");
            for (Car car : cars) {
                System.out.println(car);
                System.out.println("--------------------");
            }
        }
    }
}