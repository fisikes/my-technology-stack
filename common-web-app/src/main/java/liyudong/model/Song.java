package liyudong.model;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Song {

  @NotNull
  private String song;
  @NotNull
  private String singer;
  @NotNull
  private Integer year;

}
