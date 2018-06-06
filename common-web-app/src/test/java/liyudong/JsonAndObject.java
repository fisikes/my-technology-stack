package liyudong;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import liyudong.data.Song;
import liyudong.data.SongData;
import org.junit.Test;

import java.util.List;

public class JsonAndObject {

  @Test
  public void objectToJsonString() {
    Gson gson = new Gson();
    String songs = gson.toJson(SongData.Songs);

    System.out.println(songs);
  }

  /**
   * json to javabean
   */
  @Test
  public void jsonToObject() {
    Gson gson = new Gson();
    Song s = gson.fromJson("{\"singer\":\"李文世\",\"song\":\"옛사랑\"}", Song.class);
    System.out.println(s.toString());
  }

  /**
   * json to java list
   */
  @Test
  public void jsonToList() {

    Gson gson = new Gson();
    String json = "[{\"singer\":\"陈奕迅\",\"song\":\"白玫瑰\"},{\"singer\":\"" +
        "谭咏麟 / 陈慧娴\",\"song\":\"活得潇洒\"},{\"singer\":\"黄霑\",\"song\"" +
        ":\"男儿当自强(主题音乐)\"},{\"singer\":\"陈奕迅\",\"song\":\"爱情转移\"" +
        "},{\"singer\":\"陈奕迅\",\"song\":\"婚礼的祝福\"},{\"singer\":\"陈奕迅\"" +
        ",\"song\":\"最冷一天\"},{\"singer\":\"Aki阿杰\",\"song\":\"东风志\"},{\"" +
        "singer\":\"Aki阿杰\",\"song\":\"闲云志\"},{\"singer\":\"李文世\",\"song\"" +
        ":\"옛사랑\"}]";
    List<Song> songs = gson.fromJson(json, new TypeToken<List<Song>>() {
    }.getType());
    System.out.println(songs.toString());
  }

}
