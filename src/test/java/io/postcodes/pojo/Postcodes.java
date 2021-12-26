package io.postcodes.pojo;

import lombok.Data;

@Data
public class Postcodes {

  private Integer status;
  private PostcodesResult result;

  public Postcodes() {}

  public Postcodes(Integer status, PostcodesResult result) {
    super();
    this.status = status;
    this.result = result;
  }
}
