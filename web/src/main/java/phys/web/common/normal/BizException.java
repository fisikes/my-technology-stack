package phys.web.common.normal;

import java.io.Serializable;

public class BizException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer code;
  private String message;

  public BizException() {
  }


  public BizException(Throwable cause) {
    super(cause);
  }

  public BizException(String message) {
    this.message = message;
  }

  public BizException(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}