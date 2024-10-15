/**
 * Represents statistical data for Car objects.
 */
class CarStatistics {
    private double sum = 0;
    private double sumOfSquares = 0;
    private double minPrice = Double.MAX_VALUE;
    private double maxPrice = Double.MIN_VALUE;
    private long count = 0;

    /**
     * Accepts a Car object and updates the statistics accordingly.
     *
     * @param car the Car object to process
     */
    public void accept(Car car) {
        double price = car.getPrice();
        sum += price;
        sumOfSquares += price * price;
        minPrice = Math.min(minPrice, price);
        maxPrice = Math.max(maxPrice, price);
        count++;
    }

    /**
     * Combines this CarStatistics with another CarStatistics.
     *
     * @param other the other CarStatistics to combine with
     * @return the combined CarStatistics
     */
    public CarStatistics combine(CarStatistics other) {
        sum += other.sum;
        sumOfSquares += other.sumOfSquares;
        minPrice = Math.min(minPrice, other.minPrice);
        maxPrice = Math.max(maxPrice, other.maxPrice);
        count += other.count;
        return this;
    }

    /**
     * Gets the average price of the cars.
     *
     * @return the average price
     */
    public double getAveragePrice() {
        return sum / count;
    }

    /**
     * Gets the standard deviation of the prices.
     *
     * @return the standard deviation
     */
    public double getStandardDeviation() {
        double mean = getAveragePrice();
        return Math.sqrt((sumOfSquares / count) - (mean * mean));
    }

    /**
     * Gets the minimum price of the cars.
     *
     * @return the minimum price
     */
    public double getMinPrice() {
        return minPrice;
    }

    /**
     * Gets the maximum price of the cars.
     *
     * @return the maximum price
     */
    public double getMaxPrice() {
        return maxPrice;
    }
}
