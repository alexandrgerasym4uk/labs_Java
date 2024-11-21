/**
 * The {@code Person} class represents a person with a first name, last name, and age.
 * <p>
 * This class is used for testing serialization functionality with the {@link SerializeField}
 * annotation. The annotation is used to specify custom field names during serialization.
 * </p>
 */
public class Person {

    @SerializeField(name = "first_name")
    private String firstName;

    @SerializeField(name = "last_name")
    private String lastName;

    @SerializeField(name = "age")
    private int age;

    /**
     * Constructs a new {@code Person} object with the specified first name, last name, and age.
     *
     * @param firstName the first name of the person
     * @param lastName the last name of the person
     * @param age the age of the person
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
