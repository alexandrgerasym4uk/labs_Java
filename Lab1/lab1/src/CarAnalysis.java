import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Analyzes a list of Car objects by filtering and grouping them.
 */
public class CarAnalysis {

    /**
     * Filters cars based on the manufacture date and groups them by car class.
     *
     * @param cars       the list of Car objects to analyze
     * @param monthsLimit the maximum number of months since manufacture for filtering
     */
    public static void filterAndGroupCars(List<Car> cars, int monthsLimit) {
        Map<String, List<Car>> groupedCars = cars.stream()
                .filter(car -> car.getMonthsSinceManufacture() <= monthsLimit) // Filter cars by age
                .collect(Collectors.groupingBy(Car::getCarClass)); // Group cars by class

        // Print the count of cars in each class
        groupedCars.forEach((carClass, carList) -> {
            System.out.println("Class: " + carClass + ", Count: " + carList.size());
        });
    }
}
