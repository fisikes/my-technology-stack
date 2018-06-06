package liyudong.enums;


/**
 * https://blog.csdn.net/qq_27093465/article/details/52180865
 */
public enum ArchTypeEnum {

  ELECTRONIC_RECORD("电子档案", 1), MEETING_MINUTES("会议纪要", 2);

  // 成员变量
  private String name;
  private Integer index;

  // 构造方法
  ArchTypeEnum(String name, Integer index) {
    this.name = name;
    this.index = index;
  }

  public int getIndex(){
    return this.index;
  }

  //覆盖方法
  @Override
  public String toString() {
    return this.index+"_"+this.name;
  }



}
