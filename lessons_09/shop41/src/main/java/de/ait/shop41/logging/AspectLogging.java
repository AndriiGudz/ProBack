package de.ait.shop41.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectLogging {
    private final Logger logger = LogManager.getLogger(AspectLogging.class);

    @Before("execution(* de.ait.shop41.product.service.ProductServiceImpl.*(..))")
    public void helloAOP(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*********** ProductService {} start ", name);
    }

    @After("execution(* de.ait.shop41.*.service.*.*(..))") // будет смотреть на все сервисы во всех папках Service
    public void helloAOP1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*********** Service {} finish ", name);
    }

    @Around("@annotation(de.ait.shop41.logging.Profiler)") // внедряем в тот метод, где стоит анотация Profiler
    public Object profilerMethod(ProceedingJoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();
        logger.info("*********** Profiler {} finish ", name);
        long start = System.currentTimeMillis();
        Object result;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long time = System.currentTimeMillis() - start;
        logger.info("*********** Profiler {} finish, time: {}, result: {} ", name, time, result);
        return result;

    }

    @Pointcut("execution(* de.ait.shop41.*.controller.*.*(..))")
    public void allControllers() {}

    @Pointcut("execution(* de.ait.shop41.*.controller.*.find*(..))")
    public void allFindMethod() {}

    // объединение Pointcut
    @AfterReturning("allControllers()||allFindMethod()")
    public void helloAOP3(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*********** Service {} finish ", name);
    }

}
