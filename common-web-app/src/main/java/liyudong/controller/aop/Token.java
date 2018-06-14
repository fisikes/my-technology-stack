package liyudong.controller.aop;

import java.lang.annotation.*;

/**
 * Token注解类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Token {
    boolean save() default false ;

    boolean remove() default false ;
}