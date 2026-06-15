package br.com.dio.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import static br.com.dio.annotation.FieldFormatEnum.CAMEL_CASE;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface SerializerType {
    FieldFormatEnum fieldFormat() default CAMEL_CASE;

    boolean prettify() default true;
}
