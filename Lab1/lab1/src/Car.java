import java.time.LocalDate;
/**
 * Represents a car with its attributes such as brand, model, manufacture date, class, and price.
 */
public class Car {
    private String brand;  // The brand of the car
    private String model;  // The model of the car
    private LocalDate manufactureDate;  // The date the car was manufactured
    private String carClass;  // The class of the car (e.g., SUV, Sedan)
    private double price;  // The price of the car in currency

    /**
     * Constructs a new Car instance with the specified parameters.
     *
     * @param brand the brand of the car
     * @param model the model of the car
     * @param manufactureDate the date the car was manufactured
     * @param carClass the class of the car
     * @param price the price of the car
     */
    public Car(String brand, String model, LocalDate manufactureDate, String carClass, double price) {
        this.brand = brand;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.carClass = carClass;
        this.price = price;
    }

    /**
     * Returns the brand of the car.
     *
     * @return the brand of the car
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the manufacture date of the car.
     *
     * @return the manufacture date
     */
    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    /**
     * Returns the class of the car.
     *
     * @return the class of the car
     */
    public String getCarClass() {
        return carClass;
    }

    /**
     * Returns the price of the car.
     *
     * @return the price of the car
     */
    public double getPrice() {
        return price;
    }

    /**
     * Calculates the number of months since the car was manufactured.
     *
     * @return the number of months since manufacture
     */
    public long getMonthsSinceManufacture() {
        return LocalDate.now().until(manufactureDate).toTotalMonths();
    }

    /**
     * Returns a string representation of the car object.
     *
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureDate=" + manufactureDate +
                ", carClass='" + carClass + '\'' +
                ", price=" + price +
                '}';
    }
}
