import java.lang.reflect.Field;

/**
 * The {@code Serializer} class provides methods to serialize an object into
 * different formats, such as JSON and XML. It uses reflection to access
 * fields in the given object and applies the {@code SerializeField} annotation
 * to determine which fields to serialize and how to name them.
 */
public class Serializer {

    /**
     * Serializes the given object to a JSON string.
     * <p>
     * This method iterates over the fields of the object's class, checking for
     * the presence of the {@link SerializeField} annotation. If the field is
     * annotated, it is included in the resulting JSON string. The field's name
     * is determined by the annotation's {@code name} element.
     * </p>
     *
     * @param object the object to serialize
     * @return a JSON representation of the object as a {@code String}
     * @throws IllegalAccessException if the field cannot be accessed
     */
    public static String toJson(Object object) throws IllegalAccessException {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = object.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SerializeField.class)) {
                SerializeField annotation = field.getAnnotation(SerializeField.class);
                String name = annotation.name();
                Object value = field.get(object);

                if (value != null) {
                    if (!first) {
                        json.append(",");
                    }
                    json.append("\"").append(name).append("\":\"").append(value).append("\"");
                    first = false;
                }
            }
        }
        json.append("}");
        return json.toString();
    }

    /**
     * Serializes the given object to an XML string.
     * <p>
     * This method iterates over the fields of the object's class, checking for
     * the presence of the {@link SerializeField} annotation. If the field is
     * annotated, it is included in the resulting XML string. The field's name
     * is determined by the annotation's {@code name} element.
     * </p>
     *
     * @param object the object to serialize
     * @return an XML representation of the object as a {@code String}
     * @throws IllegalAccessException if the field cannot be accessed
     */
    public static String toXml(Object object) throws IllegalAccessException {
        StringBuilder xml = new StringBuilder();
        xml.append("<object>");

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SerializeField.class)) {
                SerializeField annotation = field.getAnnotation(SerializeField.class);
                String name = annotation.name();
                Object value = field.get(object);

                if (value != null) {
                    xml.append("<").append(name).append(">")
                            .append(value).append("</").append(name).append(">");
                }
            }
        }
        xml.append("</object>");
        return xml.toString();
    }
}
