package fisikes;

import static org.junit.jupiter.api.Assertions.*;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.lang.Nullable;

public class SpringEL {

  private static final ExpressionParser expressionParser = new SpelExpressionParser();

  @Data
  public static class Req {

    private String username;
  }

  @Test
  public void test() {
    final Req optLogContext = new Req();
    optLogContext.setUsername("123");
    final EvaluationContext context = new StandardEvaluationContext();
    context.setVariable("req", optLogContext);



    assertEquals(getValue("xxx:#{#req.username}", context, String.class), "xxx:123");
    //assertEquals(getValue("'xxx:' + #req.username", context, String.class), "xxx:123");

  }

  public <T> T getValue(String expressionString, EvaluationContext context,
      @Nullable Class<T> desiredResultType) {
    final Expression expression = expressionParser.parseExpression(expressionString, new TemplateParserContext());
    return expression.getValue(context, desiredResultType);
  }

}
