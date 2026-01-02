import java.time.Year;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) throw new IllegalArgumentException("doors");
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(Year.now().getValue());
        return getBasePrice() * 0.05 + age * 100 + numberOfDoors * 20;
    }

    @Override
    public void performService() {
        System.out.println("Car service performed");
    }

    @Override
    public int getServiceIntervalKm() {
        return 15000;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() + ", doors=" + numberOfDoors + "}";
    }
}
