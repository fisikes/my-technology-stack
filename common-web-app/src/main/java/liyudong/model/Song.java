package liyudong.model;

public class Song {

  private String song;
  private String singer;

  @Override
  public String toString() {
    return "Song{" +
            "song='" + song + '\'' +
            ", singer='" + singer + '\'' +
            '}';
  }

  public String getSong() {
    return song;
  }

  public void setSong(String song) {
    this.song = song;
  }

  public String getSinger() {
    return singer;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }
}
