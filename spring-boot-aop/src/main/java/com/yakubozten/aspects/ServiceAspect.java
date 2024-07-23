package com.yakubozten.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {
    //@Before("execution(* com.yakubozten.service.MessageService.mesajVer(..))")
    @Before("execution(* com.yakubozten.service.*.*(..))")
   public void mesajVerMotudundanOnce(JoinPoint joinPoint){
        System.out.println("Mesaj Ver Metodundan önce parametre yakalandı.param:"+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.yakubozten.service.*.*(..))")
    public  void mesajVerMotudundanSonra(JoinPoint joinPoint){
        System.out.println("Mesaj Ver Metodundan sonra parametre yakalandı.param:"+joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

}
