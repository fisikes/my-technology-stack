package liyudong;

import liyudong.data.Song;
import liyudong.data.SongData;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupByTest {

  @Test
  public void test() {
    Map<String, List<Song>> SongsGroupBySinger = SongData.Songs.stream().collect(
        Collectors.groupingBy(Song::getSinger, Collectors.toList())
    );
    System.out.println(SongsGroupBySinger.toString());
  }
}
