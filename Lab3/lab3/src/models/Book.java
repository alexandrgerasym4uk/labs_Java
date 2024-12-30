package models;

import annotations.FieldMapping;
import annotations.Serializable;

/**
 * Represents a book model with serializable properties.
 * <p>
 * This class is annotated with {@link Serializable}, indicating it can be processed
 * for serialization. Each field is mapped using the {@link FieldMapping} annotation
 * to define custom serialization keys.
 * </p>
 *
 * <p><b>Example:</b></p>
 * <pre>
 * {@code
 * Book book = new Book("1984", "George Orwell", 9.99);
 * }
 * </pre>
 */
@Serializable
public class Book {

    /** The title of the book. Mapped to "title". */
    @FieldMapping("title")
    private String title;

    /** The author of the book. Mapped to "author". */
    @FieldMapping("author")
    private String author;

    /** The price of the book. Mapped to "price". */
    @FieldMapping("price")
    private double price;

    /**
     * Constructs a new {@code Book} instance with the given details.
     *
     * @param title  the title of the book
     * @param author the author of the book
     * @param price  the price of the book
     */
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}