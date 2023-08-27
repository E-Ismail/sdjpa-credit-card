package guru.springframework.creditcard.interceptors;

import java.lang.annotation.*;

/**
 * @author E.I.
 * <p>
 * {@code @Date}  5/14/2023
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EncryptedString {
}
