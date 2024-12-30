package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to indicate that a class is serializable.
 * <p>
 * This annotation can be applied to classes to mark them as eligible for
 * serialization processes during runtime.
 * </p>
 *
 * <p><b>Usage:</b></p>
 * <pre>
 * {@code
 * @Serializable
 * public class Example {
 *     private String field;
 * }
 * }</pre>
 *
 * @Target(ElementType.TYPE) Indicates that this annotation can only be applied to classes or interfaces.
 * @Retention(RetentionPolicy.RUNTIME) Indicates that this annotation is available at runtime.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Serializable {
}
