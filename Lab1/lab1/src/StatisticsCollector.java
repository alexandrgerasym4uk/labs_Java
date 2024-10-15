import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Collects and prints statistics about a list of Car objects.
 */
public class StatisticsCollector {

    /**
     * Creates a custom collector for Car objects to compute statistics.
     *
     * @return a Collector that produces CarStatistics
     */
    public static Collector<Car, ?, CarStatistics> carStatisticsCollector() {
        return Collector.of(
                CarStatistics::new,          // Supplier: creates a new CarStatistics instance
                CarStatistics::accept,       // Accumulator: adds a Car's price to the statistics
                CarStatistics::combine       // Combiner: merges two CarStatistics instances
        );
    }

    /**
     * Prints statistics such as minimum, maximum, average price, and standard deviation for a list of cars.
     *
     * @param cars the list of Car objects to analyze
     */
    public static void printStatistics(List<Car> cars) {
        CarStatistics stats = cars.stream().collect(carStatisticsCollector());

        System.out.println("Min price: " + stats.getMinPrice());
        System.out.println("Max price: " + stats.getMaxPrice());
        System.out.println("Average price: " + stats.getAveragePrice());
        System.out.println("Standard deviation: " + stats.getStandardDeviation());
    }
}
