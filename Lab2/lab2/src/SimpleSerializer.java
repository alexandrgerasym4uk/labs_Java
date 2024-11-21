/**
 * The {@code SimpleSerializer} class provides methods to serialize a {@link Product} object
 * into different formats, such as JSON and XML.
 */
public class SimpleSerializer {

    /**
     * Serializes a {@link Product} object into a JSON string.
     * <p>
     * This method converts the {@code productName} and {@code price} properties of the
     * {@code Product} object into a JSON representation. The fields are represented as key-value
     * pairs in the resulting JSON string.
     * </p>
     *
     * @param product the {@code Product} object to serialize
     * @return a JSON representation of the {@code Product} object as a {@code String}
     */
    public static String productToJson(Product product) {
        return "{" +
                "\"product_name\":\"" + product.getProductName() + "\"," +
                "\"price\":\"" + product.getPrice() + "\"" +
                "}";
    }

    /**
     * Serializes a {@link Product} object into an XML string.
     * <p>
     * This method converts the {@code productName} and {@code price} properties of the
     * {@code Product} object into an XML representation. The fields are enclosed in XML tags
     * corresponding to their names.
     * </p>
     *
     * @param product the {@code Product} object to serialize
     * @return an XML representation of the {@code Product} object as a {@code String}
     */
    public static String productToXml(Product product) {
        return "<object>" +
                "<product_name>" + product.getProductName() + "</product_name>" +
                "<price>" + product.getPrice() + "</price>" +
                "</object>";
    }
}
