package liyudong;

import org.junit.Test;

/**
 * @author liyudong
 */
public class StrAsciiTest {

  @Test
  public void test(){

    String a = "a1b20c3cc6";
    String[] c = a.split("[0-9]+");
    String[] word = a.split("[a-zA-Z]+");
    for (String cs : c){
      System.out.println(cs);
    }
    for (String w : word){
      System.out.println(w);
    }

  }
}
