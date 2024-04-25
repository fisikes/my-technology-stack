package fisikes.service;


import fisikes.config.Opt;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @Opt(expression = "用户【#{#req['userId']}】执行了get方法")
  public String get(String tenantId, String userId, Map<String, Object> params) {
    return "result";
  }

}
