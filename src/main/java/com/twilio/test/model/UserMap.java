package com.twilio.test.model;

import java.util.HashMap;
import java.util.Map;

/**
 * hold a map of all users initialized at startup
 * 
 * @author ndurgadathan
 *
 */
public class UserMap {

  private Map<String, User> userMap = new HashMap<>();
  
  public void addUser(String userId, double balance) {
    User user = new User(userId, balance);
    userMap.put(userId, user);
  }
  
  public User getUser(String userId) {
    return userMap.get(userId);
  }
  
}
