public abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    protected Vehicle(String model, int year, double basePrice) {
        id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) throw new IllegalArgumentException("model");
        this.model = model.trim();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1886 || year > 2100) throw new IllegalArgumentException("year");
        this.year = year;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice <= 0) throw new IllegalArgumentException("basePrice");
        this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return Math.max(0, currentYear - year);
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return "id=" + id + ", model=" + model + ", year=" + year + ", basePrice=" + basePrice;
    }
}
