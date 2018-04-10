package com.twilio.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.twilio.test.model.TransactionHistory;
import com.twilio.test.model.UserMap;

@Component
public class BeanDefenition {

  /**
   * the users are following format firstuserId~balance*seconduserid~balance
   */
  @Value("${users}")
  private String users;


  @Bean
  public UserMap getUserMap() {
    UserMap userMap = new UserMap();
    // TODO add validation

    String[] userList = users.split("*");
    for (String user : userList) {
      String[] userInfo = user.split("~");
      userMap.addUser(userInfo[0], Double.valueOf(userInfo[1]));
    }
    return userMap;
  }

  @Bean
  public TransactionHistory getTransactionHistory() {
    return new TransactionHistory();
  }
}
