package learning.micronaut.annotation;

import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;
import learning.micronaut.interceptor.LoggingInterceptor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Around
@Type(LoggingInterceptor.class)
public @interface Logged {
    
}
