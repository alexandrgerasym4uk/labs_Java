package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to map a field to a specific value.
 * <p>
 * This annotation can be applied to fields to specify a mapping value
 * that can be used during runtime processing.
 * </p>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 * {@code
 * public class Example {
 *     @FieldMapping("mapped_value")
 *     private String field;
 * }
 * }</pre>
 *
 * @Target(ElementType.FIELD) Indicates that this annotation can only be applied to fields.
 * @Retention(RetentionPolicy.RUNTIME) Indicates that this annotation is available at runtime.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMapping {

    /**
     * Specifies the mapping value for the annotated field.
     *
     * @return the mapping value as a {@code String}.
     */
    String value();
}