/**
 * The {@code Book} class represents a book with a title, author, and ISBN number.
 * <p>
 * This class is used for testing serialization functionality with the {@link SerializeField}
 * annotation. The annotation is used to specify custom field names during serialization.
 * </p>
 */
public class Book {

    @SerializeField(name = "title")
    private String title;

    @SerializeField(name = "author")
    private String author;

    @SerializeField(name = "isbn")
    private String isbn;

    /**
     * Constructs a new {@code Book} object with the specified title, author, and ISBN.
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param isbn the ISBN number of the book
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
