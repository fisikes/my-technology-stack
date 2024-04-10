package phys.web.common.api;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import phys.web.common.normal.BizException;
import phys.web.common.normal.R;

@ControllerAdvice
@Slf4j
public class ExceptionHandle {

  /**
   * 普通异常类处理
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public R error(Exception e) {
    log.error("exception", e);
    // todo
    return R.fail("未知错误");
  }

  /**
   * 自定义异常类处理
   */
  @ExceptionHandler(BizException.class)
  @ResponseBody
  public R error(BizException e) {
    String message = e.getMessage();
    return R.fail(message);
  }

  /**
   * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
   */
  @ExceptionHandler(BindException.class)
  @ResponseBody
  public R BindExceptionHandler(BindException e) {
    String message = e.getBindingResult().getAllErrors().stream().map(
        DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
    return R.fail(message);
  }

  /**
   * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
   */
  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseBody
  public R ConstraintViolationExceptionHandler(ConstraintViolationException e) {
    String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
        .collect(Collectors.joining());
    return R.fail(message);
  }

  /**
   * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public R MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    String message = e.getBindingResult().getAllErrors().stream()
        .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
    return R.fail(message);
  }

}
