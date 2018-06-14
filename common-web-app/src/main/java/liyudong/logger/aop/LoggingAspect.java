package liyudong.logger.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 *
 * @author liyudong
 */
@Aspect
@Component
public class LoggingAspect {

  public static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

  /**
   * 方法执行前
   */
  @Before("execution(* liyudong.logger.aoptest.*.*(..))")
  public void beforeMethod(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    logger.info("方法名: {} , 参数: {}", methodName, joinPoint.getArgs());
  }

}
