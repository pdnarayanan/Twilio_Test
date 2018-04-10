package com.twilio.test.model;

import java.util.Date;

public class Transaction {
  
  private String transactionId;
  private double amount;
  private User sourceUser;
  private User targetUser;
  private Date time;
  
  
  public String getTransactionId() {
    return transactionId;
  }
  
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }
  
  public double getAmount() {
    return amount;
  }
  
  public void setAmount(double amount) {
    this.amount = amount;
  }
  
  public User getSourceUser() {
    return sourceUser;
  }
  
  public void setSourceUser(User sourceUser) {
    this.sourceUser = sourceUser;
  }
  
  public User getTargetUser() {
    return targetUser;
  }
  
  public void setTargetUser(User targetUser) {
    this.targetUser = targetUser;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
  
  
}
