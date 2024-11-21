/**
 * The {@code Product} class represents a product with a name and a price.
 * <p>
 * This class is used for testing serialization functionality with the {@link SerializeField}
 * annotation. The annotation is used to specify custom field names during serialization.
 * </p>
 */
public class Product {

    @SerializeField(name = "product_name")
    private String productName;

    @SerializeField(name = "price")
    private double price;

    /**
     * Constructs a new {@code Product} object with the specified product name and price.
     *
     * @param productName the name of the product
     * @param price the price of the product
     */
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    /**
     * Returns the name of the product.
     *
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Returns the price of the product.
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }
}
