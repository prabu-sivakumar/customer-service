package learning.micronaut.interceptor;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class LoggingInterceptor implements MethodInterceptor<Object, Object> {
    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        Logger log = LoggerFactory.getLogger(context.getDeclaringType());
        try {
            Object result = context.proceed();
            log.trace("Method {} resulted in : {}", context.getExecutableMethod(), result);
            return result;
        } catch (RuntimeException e) {
            log.trace("Method {} caused Exception : {}", context.getExecutableMethod(), e.getMessage());
            throw e;
        }

    }
}
