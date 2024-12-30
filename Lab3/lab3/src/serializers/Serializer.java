package serializers;

import annotations.FieldMapping;
import annotations.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class for serializing objects to JSON and XML formats.
 * <p>
 * This class provides methods to serialize objects annotated with {@link Serializable}
 * into JSON or XML. Fields to be serialized must be annotated with {@link FieldMapping}.
 * </p>
 */
public class Serializer {

    /**
     * Serializes an object to JSON format.
     *
     * @param obj the object to serialize
     * @return the JSON representation of the object as a {@code String}
     * @throws Exception if the class is not annotated with {@link Serializable} or if
     *                   an error occurs during reflection.
     */
    public static String toJSON(Object obj) throws Exception {
        validateSerializable(obj);
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(FieldMapping.class)) {
                field.setAccessible(true);
                String mappedName = field.getAnnotation(FieldMapping.class).value();
                Object value = field.get(obj);
                jsonBuilder.append("\"").append(mappedName).append("\": \"").append(value).append("\"");
                if (i < fields.length - 1) {
                    jsonBuilder.append(", ");
                }
            }
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    /**
     * Serializes an object to XML format.
     *
     * @param obj the object to serialize
     * @return the XML representation of the object as a {@code String}
     * @throws Exception if the class is not annotated with {@link Serializable} or if
     *                   an error occurs during reflection.
     */
    public static String toXML(Object obj) throws Exception {
        validateSerializable(obj);
        StringBuilder xmlBuilder = new StringBuilder();
        String rootElement = obj.getClass().getSimpleName();
        xmlBuilder.append("<").append(rootElement).append(">");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldMapping.class)) {
                field.setAccessible(true);
                String mappedName = field.getAnnotation(FieldMapping.class).value();
                Object value = field.get(obj);
                xmlBuilder.append("<").append(mappedName).append(">")
                        .append(value)
                        .append("</").append(mappedName).append(">");
            }
        }

        xmlBuilder.append("</").append(rootElement).append(">");
        return xmlBuilder.toString();
    }

    /**
     * Validates that the given object's class is annotated with {@link Serializable}.
     *
     * @param obj the object to validate
     * @throws Exception if the class is not annotated with {@link Serializable}
     */
    private static void validateSerializable(Object obj) throws Exception {
        if (!obj.getClass().isAnnotationPresent(Serializable.class)) {
            throw new Exception("Class " + obj.getClass().getSimpleName() + " is not annotated as Serializable.");
        }
    }

    /**
     * Specific generator for converting books to XML format.
     */
    public static class BookXMLGenerator {
        /**
         * Serializes a book object to XML format.
         *
         * @param book the book object to serialize
         * @return the XML representation of the book as a {@code String}
         * @throws Exception if serialization fails
         */
        public static String generate(Object book) throws Exception {
            return toXML(book);
        }
    }

    /**
     * Specific generator for converting persons to JSON format.
     */
    public static class PersonJsonGenerator {
        /**
         * Serializes a person object to JSON format.
         *
         * @param person the person object to serialize
         * @return the JSON representation of the person as a {@code String}
         * @throws Exception if serialization fails
         */
        public static String generate(Object person) throws Exception {
            return toJSON(person);
        }
    }

    /**
     * Specific generator for converting products to XML format.
     */
    public static class ProductXMLGenerator {
        /**
         * Serializes a product object to XML format.
         *
         * @param product the product object to serialize
         * @return the XML representation of the product as a {@code String}
         * @throws Exception if serialization fails
         */
        public static String generate(Object product) throws Exception {
            return toXML(product);
        }
    }
}
