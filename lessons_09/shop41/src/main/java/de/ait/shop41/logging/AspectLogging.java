package de.ait.shop41.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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

    @After("execution(* de.ait.shop41.product.service.ProductServiceImpl.*(..))")
    public void helloAOP1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        logger.info("*********** ProductService {} finish ", name);
    }

}
