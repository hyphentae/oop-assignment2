import java.time.Year;

public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) throw new IllegalArgumentException("capacity");
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        int age = getAge(Year.now().getValue());
        return getBasePrice() * 0.08 + age * 200 + passengerCapacity * 2;
    }

    @Override
    public void performService() {
        System.out.println("Bus service performed");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + ", capacity=" + passengerCapacity + "}";
    }
}
