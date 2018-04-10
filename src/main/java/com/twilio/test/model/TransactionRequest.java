package com.twilio.test.model;

public class TransactionRequest {

  private String sourceUserId;
  private String targetUserId;
  private Double amout;
  
  public String getSourceUserId() {
    return sourceUserId;
  }
  
  public void setSourceUserId(String sourceUserId) {
    this.sourceUserId = sourceUserId;
  }
  
  public String getTargetUserId() {
    return targetUserId;
  }
  
  public void setTargetUserId(String targetUserId) {
    this.targetUserId = targetUserId;
  }
  
  public Double getAmout() {
    return amout;
  }
  
  public void setAmout(Double amout) {
    this.amout = amout;
  }
  
  
}
