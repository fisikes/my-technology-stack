package liyudong;

import liyudong.enums.ArchTypeEnum;
import org.junit.Test;

public class EnumTest {

  @Test
  public void test(){
    System.out.println("电子档案存入数据库的状态值: "+ArchTypeEnum.ELECTRONIC_RECORD.getIndex());
  }


}
