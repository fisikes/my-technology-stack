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

  public void setSinger(String singer) {
    this.singer = singer;
  }

  public void setSong(String song) {
    this.song = song;
  }

  @Override
  public String toString() {
    return "Song{" +
        "singer='" + singer + '\'' +
        ", song='" + song + '\'' +
        '}';
  }
}
