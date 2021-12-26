package io.postcodes.pojo;

import lombok.Data;

@Data
public class PostcodesResult {

  private String postcode;
  private String country;
  private String region;

  public PostcodesResult() {}

  public PostcodesResult(String postcode, String country, String region) {
    super();
    this.postcode = postcode;
    this.country = country;
    this.region = region;
  }
}
