package com.twilio.test.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.test.model.Transaction;
import com.twilio.test.model.TransactionHistory;
import com.twilio.test.model.TransactionRequest;
import com.twilio.test.model.User;
import com.twilio.test.model.UserMap;

@RestController
@RequestMapping("v1/transactions")
public class TwilioTechChallengeService {

  @Autowired
  private UserMap userMap;
  
  @Autowired
  private TransactionHistory TransactionHistory;
  
  @GetMapping
  @RequestMapping("/getBalance")
  public ResponseEntity<Double> getBalance(@RequestParam("id") String userId) {
    // validate User ID
    HttpStatus httpStatus = HttpStatus.OK;
    Double balance = Double.NaN;
    if (userId == null) {
      httpStatus = HttpStatus.BAD_REQUEST;
    } else {
      User user = userMap.getUser(userId);
      if (user != null) {
        balance = user.getBalance();
      }
    }
     return ResponseEntity.status(httpStatus).body(balance);
  }
  
  @PostMapping
  @RequestMapping("/request")
  public ResponseEntity<String> requestAmount(@RequestBody TransactionRequest transaction) {
    // TODo validate the transaction
    if (transaction == null ) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid paramters");
    }
    
    User sourceUser =  userMap.getUser(transaction.getSourceUserId());
    User targetUser = userMap.getUser(transaction.getTargetUserId());
    double amount = transaction.getAmout();
    
    if (sourceUser.getBalance() < amount ) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("insufficient balance");
    }
    
    // subtract amount from source user
    sourceUser.addBalance(amount * -1);
    // add amount to target user
    targetUser.addBalance(amount);
    
    // craete a transaction
    Transaction transHistory = new Transaction();
    transHistory.setSourceUser(sourceUser);
    transHistory.setTargetUser(targetUser);
    transHistory.setAmount(amount);
    transHistory.setTime(new Date());
    TransactionHistory.addTransaction(sourceUser.getUserId(), transHistory);
    TransactionHistory.addTransaction(targetUser.getUserId(), transHistory);
    
    
    return ResponseEntity.status(HttpStatus.OK).body("Succefully transferred");
  }
}
