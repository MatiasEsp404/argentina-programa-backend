package com.matias.argentinaprograma.config.security.common;

import java.util.List;

public class ErrorResponse {

  private int statusCode;
  private String message;
  private List<String> moreInfo;

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getMoreInfo() {
    return moreInfo;
  }

  public void setMoreInfo(List<String> moreInfo) {
    this.moreInfo = moreInfo;
  }
}
