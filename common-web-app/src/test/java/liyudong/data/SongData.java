package liyudong.data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SongData {

  public static final List<Song> Songs = Stream.of(
      new Song("陈奕迅", "白玫瑰"),
      new Song("谭咏麟 / 陈慧娴", "活得潇洒"),
      new Song("黄霑", "男儿当自强(主题音乐)"),
      new Song("陈奕迅", "爱情转移"),
      new Song("陈奕迅", "婚礼的祝福"),
      new Song("陈奕迅", "最冷一天"),
      new Song("Aki阿杰", "东风志"),
      new Song("Aki阿杰", "闲云志"),
      new Song("李文世", "옛사랑")
  ).collect(Collectors.toList());

}
