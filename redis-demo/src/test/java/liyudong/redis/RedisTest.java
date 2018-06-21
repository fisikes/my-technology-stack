package liyudong.redis;

import java.util.Objects;
import org.junit.Test;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * @author liyudong
 */
public class RedisTest {

  /**
   * 无密码的redis连接测试
   */
  @Test
  public void connectTest() {
    /*
     * 注意:
     * redis启动时需要加参数 --protected-mode no (测试使用)
     *
     * 也可修改配置文件
     */
    Jedis jedis = new Jedis("172.16.10.182");
    // PONG
    System.out.println(jedis.ping());
  }

  /**
   * 带有密码的 redis连接测试
   */
  @Test
  public void connectByPasswordTest() {

    /*
    启动redis时, 后带上配置文件. 这样写在配置文件中的配置才能生效
    redis-server redis.conf
     */
    Jedis jedis = new Jedis("172.16.10.182", 6379);
    jedis.auth("liyudong");
    // PONG
    System.out.println(jedis.ping());
    jedis.close();
  }

  @Test
  public void getName(){
    Jedis jedis = new Jedis("172.16.10.182", 6379);
    jedis.auth("liyudong");
    Object o = jedis.get("name");
    System.out.println(Objects.toString(o));
    jedis.close();
  }


}
