package edu.ggg.waarestfullab4.aspect;

import edu.ggg.waarestfullab4.domain.Log;
import edu.ggg.waarestfullab4.services.Impl.LogServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    private LogServiceImpl service;
    public LoggerAspect(LogServiceImpl service){
        this.service = service;
    }

    //@Pointcut("@annotation(edu.ggg.waarestfullab4.aspect.annotation.Logger)")
    @Pointcut("within(edu.ggg.waarestfullab4.controller..*)")
    public void logAround(){}

    @Pointcut("within(edu.ggg.waarestfullab4.controller..*)" +
            " || within(edu.ggg.waarestfullab4.services..*)" +
            " || within(edu.ggg.waarestfullab4.repo..*)")
    public void logException(){}

    @Around(value = "logAround()")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        Log log = new Log(
                LocalDate.now(),
                LocalTime.now(),
                LocalTime.now(),
                "Anonymous",
                joinPoint.getSourceLocation().getWithinType().getName()+"."+joinPoint.getSignature().getName(),
                null
        );
        joinPoint.proceed();
        log.setEndTime(LocalTime.now());
        service.save(log);
    }

    @AfterThrowing(value = "logException()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        Log log = new Log(
                LocalDate.now(),
                null,
                null,
                "Anonymous",
                "Class: "+joinPoint.getSourceLocation().getWithinType().getName()+"|Signature:"+ joinPoint.getSignature().getName(),
                "MESSAGE: "+exception.getMessage()+" STACK TRACE: "+exception.getStackTrace()
        );
        service.save(log);
    }
}
