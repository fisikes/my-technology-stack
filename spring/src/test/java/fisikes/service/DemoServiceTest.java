package fisikes.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemoServiceTest {

  @Autowired
  private DemoService demoService;

  @Test
  void get() {
    demoService.get("123", "456", new HashMap<>());
  }
}