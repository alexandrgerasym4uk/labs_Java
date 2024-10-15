import java.util.*;
import java.util.stream.Collectors;
/**
 * Analyzes outliers in a list of Car objects based on their prices.
 */
public class OutlierAnalysis {

    /**
     * Analyzes the list of cars and identifies outliers in their prices.
     *
     * @param cars the list of Car objects to analyze
     * @return a map containing the count of data points and outliers
     */
    public static Map<String, Integer> analyzeOutliers(List<Car> cars) {
        // Extract prices from cars and sort them
        List<Double> prices = cars.stream().map(Car::getPrice).collect(Collectors.toList());
        Collections.sort(prices);

        // Calculate the first (Q1) and third (Q3) quartiles
        double q1 = prices.get(prices.size() / 4);
        double q3 = prices.get(prices.size() * 3 / 4);
        double iqr = q3 - q1; // Interquartile range

        // Determine the lower and upper bounds for outliers
        double lowerBound = q1 - 1.5 * iqr;
        double upperBound = q3 + 1.5 * iqr;

        // Count the number of outliers
        long outlierCount = prices.stream()
                .filter(price -> price < lowerBound || price > upperBound)
                .count();

        // Return the results as a map
        return Map.of("data", prices.size() - (int) outlierCount, "outliers", (int) outlierCount);
    }
}
