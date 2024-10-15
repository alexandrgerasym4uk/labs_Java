import java.util.List;
import java.util.Map;

/**
 * Main class to demonstrate the functionality of car generation, analysis, and statistics.
 */
public class Main {
    /**
     * The entry point of the application.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a CarGenerator instance to generate car objects
        CarGenerator generator = new CarGenerator();

        // Gather cars, skipping certain brands and limiting the total number of cars collected
        List<Car> carList = Gatherer.gatherCars(generator, "Toyota", 10, 500);

        // Filter and group cars based on their manufacture date
        CarAnalysis.filterAndGroupCars(carList, 12); // Filter for cars manufactured in the last 12 months

        // Print statistical analysis of the car prices using a custom collector
        StatisticsCollector.printStatistics(carList);

        // Analyze outliers in car prices
        Map<String, Integer> outlierResult = OutlierAnalysis.analyzeOutliers(carList);
        System.out.println("Result: " + outlierResult);
    }
}
