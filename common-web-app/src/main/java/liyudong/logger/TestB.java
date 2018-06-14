package liyudong.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  * Indicates how long annotations with the annotated type are to
 *  * be retained.  If no Retention annotation is present on
 *  * an annotation type declaration, the retention policy defaults to
 *  * {@code RetentionPolicy.CLASS}.
 */
@Target(ElementType.METHOD)//目标
@Retention(RetentionPolicy.RUNTIME)//在何时可用
public @interface TestB {
  int id();
  String description() default "no description";
}
