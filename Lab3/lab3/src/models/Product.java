package models;

import annotations.FieldMapping;
import annotations.Serializable;

/**
 * Represents a product model with serializable properties.
 * <p>
 * This class is annotated with {@link Serializable}, indicating it can be processed
 * for serialization. Each field is mapped using the {@link FieldMapping} annotation
 * to define custom serialization keys.
 * </p>
 *
 * <p><b>Example:</b></p>
 * <pre>
 * {@code
 * Product product = new Product("Laptop", "Electronics", 999.99);
 * }
 * </pre>
 */
@Serializable
public class Product {

    /** The name of the product. Mapped to "name". */
    @FieldMapping("name")
    private String name;

    /** The category of the product. Mapped to "category". */
    @FieldMapping("category")
    private String category;

    /** The price of the product. Mapped to "price". */
    @FieldMapping("price")
    private double price;

    /**
     * Constructs a new {@code Product} instance with the given details.
     *
     * @param name     the name of the product
     * @param category the category of the product
     * @param price    the price of the product
     */
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
