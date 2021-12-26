package io.postcodes.pojo;

import lombok.Data;

import java.util.List;

@Data
public class NearestPostcode {

  private Integer status;
  private List<NearestResult> result = null;

  public NearestPostcode() {}

  public NearestPostcode(Integer status, List<NearestResult> result) {
    super();
    this.status = status;
    this.result = result;
  }
}
