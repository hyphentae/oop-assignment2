import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("""
Fleet Management System
1. Print all vehicles
2. Add new car
3. Add new bus
4. Show total yearly insurance fees
5. Show vehicles older than N years
6. Perform service for all vehicles
7. Quit
""");
            int choice = readInt("Choose: ");
            switch (choice) {
                case 1 -> printAll();
                case 2 -> addCar();
                case 3 -> addBus();
                case 4 -> totalInsurance();
                case 5 -> olderThan();
                case 6 -> serviceAll();
                case 7 -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void printAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        for (Vehicle v : vehicles) System.out.println(v);
    }

    private void addCar() {
        String model = readString("Model: ");
        int year = readInt("Year: ");
        double price = readDouble("Base price: ");
        int doors = readInt("Doors: ");
        try {
            vehicles.add(new Car(model, year, price, doors));
            System.out.println("Car added");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid data");
        }
    }

    private void addBus() {
        String model = readString("Model: ");
        int year = readInt("Year: ");
        double price = readDouble("Base price: ");
        int cap = readInt("Capacity: ");
        try {
            vehicles.add(new Bus(model, year, price, cap));
            System.out.println("Bus added");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid data");
        }
    }

    private void totalInsurance() {
        double sum = 0;
        for (Vehicle v : vehicles) sum += v.calculateInsuranceFee();
        System.out.println("Total insurance: " + sum);
    }

    private void olderThan() {
        int currentYear = readInt("Current year: ");
        int n = readInt("N: ");
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) System.out.println("No vehicles found");
    }

    private void serviceAll() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
            return;
        }
        for (Vehicle v : vehicles) {
            Servicable s = v;
            s.performService();
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (Exception e) {
                System.out.println("Enter an integer");
            }
        }
    }

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            try {
                return Double.parseDouble(line.trim());
            } catch (Exception e) {
                System.out.println("Enter a number");
            }
        }
    }

    private String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine();
            if (!line.trim().isEmpty()) return line.trim();
            System.out.println("Enter text");
        }
    }

    public static void main(String[] args) {
        new FleetApp().run();
    }
}
