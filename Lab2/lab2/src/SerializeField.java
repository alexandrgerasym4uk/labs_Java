import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The {@code SerializeField} annotation is used to mark fields that should
 * be serialized. The annotation allows specifying a custom name for the
 * field during serialization.
 *
 * <p>This annotation can be applied to fields, and it retains information
 * at runtime so that it can be accessed through reflection.</p>
 *
 * <p>The {@code name} element specifies the custom name to use when serializing
 * the field.</p>
 *
 * @see java.lang.annotation.ElementType#FIELD
 * @see java.lang.annotation.RetentionPolicy#RUNTIME
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SerializeField {
    /**
     * Specifies the custom name for the field when serialized.
     *
     * @return the custom name for the serialized field
     */
    String name();
}
