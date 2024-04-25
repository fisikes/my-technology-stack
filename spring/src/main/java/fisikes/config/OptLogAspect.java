package fisikes.config;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 *
 */
@Aspect
@Component
@Slf4j
public class OptLogAspect {

  private static final Logger logger = LoggerFactory.getLogger(OptLogAspect.class);
  private static final ExpressionParser expressionParser = new SpelExpressionParser();

  @Around("@annotation(opt)")
  public Object around(ProceedingJoinPoint joinPoint, Opt opt) throws Throwable {
    try {

      // 入参处理
      final Object[] args = joinPoint.getArgs();

      // 获取被切方法的参数名称
      final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
      final String[] parameterNames = signature.getParameterNames();

      // 构造入参名与入参值map
      final Map<String, Object> paramMap = new HashMap<>();
      for (int i = 0; i < args.length; i++) {
        final Object arg = args[i];
        paramMap.put(parameterNames[i], arg);
      }
      //log.info("paramMap:{}", paramMap);

      final String expressionString = opt.expression();
      final EvaluationContext context = new StandardEvaluationContext();
      context.setVariable("req", paramMap);

      final Expression expression = expressionParser.parseExpression(expressionString, new TemplateParserContext());
      final String renderResult = (String) expression.getValue(context);

      System.out.println("renderResult:" + renderResult);


    } catch (Exception e) {
      logger.error("fillTenantIdAndUserIdError", e);
    }
    return joinPoint.proceed();

  }
}
