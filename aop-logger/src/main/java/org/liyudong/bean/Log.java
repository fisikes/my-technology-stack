package org.liyudong.bean;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author liyudong
 */
@Data
public class Log {

  /**
   * 日志主键
   */
  private String logId;
  /**
   * 日志类型
   */
  private String type;
  /**
   * 日志标题
   */
  private String title;
  /**
   * 请求地址
   */
  private String remoteAddr;
  /**
   * URI
   */
  private String requestUri;
  /**
   * 请求方式
   */
  private String method;
  /**
   * 提交参数
   */
  private String params;
  /**
   * 异常
   */
  private String exception;
  /**
   * 操作时间
   */
  private LocalDateTime operateLocalDateTime;
  /**
   * 结束时间
   */
  private String timeout;
  /**
   * 用户ID
   */
  private String userId;

}
