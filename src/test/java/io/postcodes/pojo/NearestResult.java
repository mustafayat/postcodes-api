package io.postcodes.pojo;

import lombok.Data;

@Data
public class NearestResult {

  private String postcode;
  private String country;
  private String region;

  public NearestResult() {}

  public NearestResult(String postcode, String country, String region) {
    super();
    this.postcode = postcode;
    this.country = country;
    this.region = region;
  }
}
