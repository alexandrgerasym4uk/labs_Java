package models;

import annotations.FieldMapping;
import annotations.Serializable;

/**
 * Represents a person model with serializable properties.
 * <p>
 * This class is annotated with {@link Serializable}, indicating it can be processed
 * for serialization. Each field is mapped using the {@link FieldMapping} annotation
 * to define custom serialization keys.
 * </p>
 *
 * <p><b>Example:</b></p>
 * <pre>
 * {@code
 * Person person = new Person("John", "Doe", 30);
 * }
 * </pre>
 */
@Serializable
public class Person {

    /** The first name of the person. Mapped to "firstName". */
    @FieldMapping("firstName")
    private String firstName;

    /** The last name of the person. Mapped to "lastName". */
    @FieldMapping("lastName")
    private String lastName;

    /** The age of the person. Mapped to "age". */
    @FieldMapping("age")
    private int age;

    /**
     * Constructs a new {@code Person} instance with the given details.
     *
     * @param firstName the first name of the person
     * @param lastName  the last name of the person
     * @param age       the age of the person
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
