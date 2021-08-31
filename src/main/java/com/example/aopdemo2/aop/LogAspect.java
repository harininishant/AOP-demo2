package com.example.aopdemo2.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
     private Logger logger = LoggerFactory.getLogger(this.getClass());// it can be written like this also
   // private Logger logger = LoggerFactory.getLogger(LogAspect.class);// logger is from Slf4J


    /*
    execution method return anything * from package com.example.aopdemo2.service
     . any service name*.any method inside it*() not return arguments or can also mention
      (..) means it may receive more than one arg.

      the first * is a return type we can change it to specify void/int etc.... also
     */
     @Pointcut(("execution(* com.example.aopdemo2.domain.*.*(..))"))
    public  void logPc(){

    }   // this is predigate class placeholders returns true or false
    @Pointcut(("execution(* com.example.aopdemo2.service.StudentService.*(..))"))
    public  void logPc2(){

    }

    //@Before("execution(* com.example.aopdemo2.service.*.*(..))")
    //@After(("execution(* com.example.aopdemo2.service.*.*(..))"))
//    public void logSomething(){
//        logger.info("logging for the method");
//    }

    @After("logPc()")// predigate match advice for pointcut
    public void logSomething(JoinPoint jointPont){
        logger.info("logging for the method");
        //logger.info("{}",jointPont);
        /*
        gave output execution(Map com.example.aopdemo2.service.DummyService.getName(String))
         */
       // logger.info("{}", Arrays.toString(jointPont.getArgs())); //output [data]
        //logger.info("{}",jointPont.getSignature().getDeclaringTypeName());
        /*
        output  com.example.aopdemo2.service.DummyService
         */
        logger.info("{}",jointPont.getSignature().getName());
        /*
        output getName
         */
    }
    @Around(("logPc() && logPc2()"))
    public  void justSayHello(){
        System.out.println("************** HELLO ******************");

    }

/*
Notes:advices
@AfterReturning("logPc()")- this will only be called when method returns sucessfully
@AfterThrowing("logPc()") - will be called when  method throws exceptions
 */

}
