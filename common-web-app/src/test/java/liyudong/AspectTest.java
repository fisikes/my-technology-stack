package liyudong;


import liyudong.logger.aoptest.AspectService;
import liyudong.model.Song;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liyudong
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AspectTest {

  @Autowired
  private AspectService aspectService;

  @Test
  public void test() {
    Song song = new Song();
    song.setSinger("我不后悔");
    song.setSong("林志颖");
    aspectService.test(song);
  }
}
