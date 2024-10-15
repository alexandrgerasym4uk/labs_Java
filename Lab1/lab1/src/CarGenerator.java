import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Generates random Car objects with realistic parameters.
 */
public class CarGenerator {
    private String[] brands = {"Toyota", "BMW", "Ford", "Honda", "Chevrolet", "Ferrari"}; // Available car brands
    private String[] models = {"Model X", "Model Y", "Model Z", "Superfast"}; // Available car models
    private String[] classes = {"SUV", "Sedan", "Hatchback"}; // Available car classes
    private Random random = new Random(); // Random number generator

    /**
     * Generates a random Car object with realistic parameters.
     *
     * @return a randomly generated Car object
     */
    public Car generateCar() {
        String brand = brands[random.nextInt(brands.length)];
        String model = models[random.nextInt(models.length)];
        LocalDate manufactureDate = LocalDate.now().minusMonths(random.nextInt(120)); // Random manufacture date within the last 10 years

        String carClass = classes[random.nextInt(classes.length)];

        // Generate price with potential outliers
        double price;
        if (random.nextInt(100) < 5) { // 5% probability for low-priced cars
            price = 50000 + (random.nextDouble() * 200000); // Price range from 50000 to 250000
        } else if (random.nextInt(50) < 1) { // 2% probability for premium cars
            price = 3000000 + (random.nextDouble() * 5000000); // Price range from 3000000 to 8000000
        } else {
            price = 300000 + (random.nextDouble() * 1200000); // Price range from 300000 to 1500000
        }

        return new Car(brand, model, manufactureDate, carClass, price);
    }

    /**
     * Creates an infinite stream of Car objects.
     *
     * @return a Stream of randomly generated Car objects
     */
    public Stream<Car> infiniteCarStream() {
        return Stream.generate(this::generateCar);
    }
}
