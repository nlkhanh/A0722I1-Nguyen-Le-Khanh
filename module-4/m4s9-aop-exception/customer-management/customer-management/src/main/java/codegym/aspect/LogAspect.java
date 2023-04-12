package codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private final Logger LOGGER =Logger.getLogger(LogAspect.class.getName());
    @AfterThrowing(pointcut = "execution(public * codegym.service.CustomerService.*(..))", throwing = "ex")
    public void log(JoinPoint point, Exception ex) {
        String methodName = point.getSignature().getName();
        String className = point.getTarget().getClass().getSimpleName();
        String args = Arrays.toString(point.getArgs());
        LOGGER.info(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, methodName, args, ex.getMessage()));
    }
}
