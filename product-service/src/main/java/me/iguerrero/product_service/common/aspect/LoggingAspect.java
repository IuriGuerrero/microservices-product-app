package me.iguerrero.product_service.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import me.iguerrero.product_service.entities.Product;


@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // Intercepta todos los métodos del paquete services
    @Pointcut("execution(* me.zwoosks.product_service.services.ProductServiceImpl.save(..))")
    public void serviceSaveMethod() {}

    @AfterReturning(pointcut = "serviceSaveMethod()", returning = "result")
    public void afterLogger(JoinPoint joinPoint, Product result) {
        logger.info("Producto guardado: {}",
                            result);
    }

}
