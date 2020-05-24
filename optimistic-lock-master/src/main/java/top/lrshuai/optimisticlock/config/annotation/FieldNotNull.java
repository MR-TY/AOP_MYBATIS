package top.lrshuai.optimisticlock.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author tangyu
 * @date 2020/5/24
 */
@Documented
@Retention(RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD,ElementType.LOCAL_VARIABLE})
public @interface FieldNotNull {
    String message() default "";
}
