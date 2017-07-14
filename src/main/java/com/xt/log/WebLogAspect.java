package com.xt.log;/**
 * Created by Administrator on 2017/7/14.
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;


/**
 * 07-14 17:39
 * web层日志切面
 * @author xt
 **/
@Aspect
@Component
@Order(-5)
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * Web log.
     * 定义一个切入点
     */
    @Pointcut("execution(public * com.xt.web.*.*(..))")
    public void webLog(){}


    /**
     * Do before.
     * 切入点之前执行
     * @param joinPoint the join point
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL: "+request.getRequestURL().toString());
        logger.info("METHOD: "+request.getMethod());
        logger.info("IP: "+request.getRemoteAddr());
        logger.info("TARGET: "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("ARGS: "+ Arrays.toString(joinPoint.getArgs()));

        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()){
            String paraName = enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }

    }


    /**
     * Do after returning.
     * 切入点之后执行
     * @param joinPoint the join point
     */
    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint){
        logger.info("WebLogAspect.doAfterReturning()");
    }
}
