package codegym.aspect;

import codegym.exception.BadWordFilterException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CommentLogAspect {
    private Logger logger = Logger.getLogger(CommentLogAspect.class.getName());

    @Pointcut("execution(* codegym.service.PictureService.save(..))")
    public void commentServiceSave() {
    }

    @AfterThrowing(value = "commentServiceSave()", throwing = "e")
    public void writeLogSave(JoinPoint joinPoint, BadWordFilterException e) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After throwing exception: " + methodName);
        logger.warning("Comment is: " + e.getMessage());
    }
}
