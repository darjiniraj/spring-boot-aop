package in.niraj.spring.springbootaop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * created by niraj on Oct, 2018
 */

@Aspect
@Component
public class LogExecutorAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    @Around("@annotation(in.niraj.spring.springbootaop.aop.annotation.LogExecutor) && execution(public * *(..))")
    public Object logMethodExecutionTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();

        Object value;
        try {
            value = proceedingJoinPoint.proceed();
        } finally {
            long duration = System.currentTimeMillis() - start;

            LOGGER.info(
                    "{} | {} | {} | {}  ms",
                    proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName(),
                    proceedingJoinPoint.getSignature().getName(),
                    request.getRemoteAddr(),
                    duration);
        }

        return value;
    }
}
