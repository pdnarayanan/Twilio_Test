package com.twilio.test.model;

public class User {
  private String userId;
  private double balance = 0;
  
  public User(String userId, double balance) {
    this.userId = userId;
    this.balance = balance;
  }

  public String getUserId() {
    return userId;
  }
  
  public void setUserId(String userId) {
    this.userId = userId;
  }
  
  public double getBalance() {
    return balance;
  }
  
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  public void addBalance(double balance) {
    this.balance = this.balance + balance;
  }
}
