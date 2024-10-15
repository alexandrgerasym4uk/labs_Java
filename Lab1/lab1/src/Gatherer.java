import java.util.List;
import java.util.stream.Collectors;

/**
 * Gathers Car objects generated by the CarGenerator.
 */
public class Gatherer {
    /**
     * Gathers a list of Car objects, skipping a specified number of cars from a certain brand.
     *
     * @param generator   the CarGenerator to use for generating cars
     * @param brandToSkip the brand of cars to skip
     * @param skipCount   the number of cars to skip from the stream
     * @param limit       the total number of cars to gather
     * @return a list of gathered Car objects
     */
    public static List<Car> gatherCars(CarGenerator generator, String brandToSkip, int skipCount, int limit) {
        return generator.infiniteCarStream()
                .filter(car -> !car.getBrand().equals(brandToSkip))  // Skip cars from the specified brand
                .skip(skipCount)  // Skip the first N cars
                .limit(limit)     // Limit the total number of gathered cars
                .collect(Collectors.toList()); // Collect the results into a list
    }
}
