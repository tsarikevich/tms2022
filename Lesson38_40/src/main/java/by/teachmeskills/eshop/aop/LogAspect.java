package by.teachmeskills.eshop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* by.teachmeskills.eshop.services.impl.UserServiceImpl.*(..))")
    private void userMethodExecuting() {
    }

    @Pointcut("execution(* by.teachmeskills.eshop.services.impl.ProductServiceImpl.*(..))")
    private void productMethodExecuting() {
    }

    @Before("userMethodExecuting()")
    public void getUserInfo(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("before " + joinPoint + ", args=[" + args + "]");
    }

    @Before("productMethodExecuting()")
    public void getProductInfo(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("before " + joinPoint + ", args=[" + args + "]");
    }

    @After("userMethodExecuting()")
    public void afterCallUserService(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }

    @After("productMethodExecuting()")
    public void afterCallProductService(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }
}
