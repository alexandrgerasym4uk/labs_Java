package main;
import models.Book;
import models.Person;
import models.Product;
import serializers.Serializer.BookXMLGenerator;
import serializers.Serializer.PersonJsonGenerator;
import serializers.Serializer.ProductXMLGenerator;

public class Main {
    public static void main(String[] args) {
        try {
            // Create sample objects
            Book book = new Book("1984", "George Orwell", 15.99);
            Person person = new Person("John", "Doe", 30);
            Product product = new Product("Laptop", "Electronics", 899.99);

            // Serialize using specific generators
            String bookXml = BookXMLGenerator.generate(book);
            String personJson = PersonJsonGenerator.generate(person);
            String productXml = ProductXMLGenerator.generate(product);

            // Print results
            System.out.println("Serialized Book to XML:");
            System.out.println(bookXml);

            System.out.println("\nSerialized Person to JSON:");
            System.out.println(personJson);

            System.out.println("\nSerialized Product to XML:");
            System.out.println(productXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
