package liyudong.jvms;

/**
 * @author liyudong
 */
public class FinalizeEscapeGC {

  public static FinalizeEscapeGC SAVE_HOOK = null;

  public void isAlive(){
    System.out.println("我还活着");
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }
}
