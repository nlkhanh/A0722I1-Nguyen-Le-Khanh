package codegym.bookborrow.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogAspect {
    private static Long numberAccess = 0L;

    private Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Pointcut("execution(* codegym.bookborrow.service.BookService.save(..))")
    public void bookServiceSave(){}

    @Pointcut("execution(* codegym.bookborrow.service.BookService.*(..))")
    public void bookService(){}

    @Pointcut("execution(* codegym.bookborrow.service.BookBorrowService.*(..))")
    public void bookBorrowService(){}

    @AfterReturning(value = "bookServiceSave()")
    public void logChangeStatus(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After succeed: " + methodName);
    }

    @After(value = "bookService() || bookBorrowService()")
    public void logNumberAccess() {
        numberAccess++;
        logger.info("Number access: " + numberAccess);
    }
}
