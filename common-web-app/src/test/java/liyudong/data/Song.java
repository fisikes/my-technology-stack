package liyudong.data;

public class Song {
  private String singer;
  private String song;

  public Song() {
  }

  public Song(String singer, String song) {
    this.singer = singer;
    this.song = song;
  }

  public String getSinger() {
    return singer;
  }

  public String getSong() {
    return song;
  }

  @Override
  public String toString() {
    return "Song{" +
        "singer='" + singer + '\'' +
        ", song='" + song + '\'' +
        '}';
  }
}
