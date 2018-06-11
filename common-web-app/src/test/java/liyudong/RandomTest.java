package liyudong;

import org.junit.Test;

/**
 * 随机数操作
 *
 * @author liyudong
 */
public class RandomTest {

  @Test
  public void randomTestArr() {

    int[] arr = {10, 20, 31, 41, 51, 61};

    for (int i = 0; i <= 100; i++) {
      // 生成arr.length的随机数
      int index = (int) (Math.random() * arr.length);
      System.out.println(arr[index]);

    }
  }

}
