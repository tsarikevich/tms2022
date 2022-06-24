package by.teachmeskills.eshop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* by.teachmeskills.eshop.services.impl.UserServiceImpl.*(..))")
    private void userMethodExecuting() {
    }

    @Pointcut("execution(* by.teachmeskills.eshop.services.impl.ProductServiceImpl.*(..))")
    private void productMethodExecuting() {
    }

    @Before("userMethodExecuting()&&productMethodExecuting()")
    public void getInfo(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " method is calling");
        System.out.println(joinPoint.getSignature() + " method is calling");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("******************************************");
        System.out.println("******************************************");
    }
}
