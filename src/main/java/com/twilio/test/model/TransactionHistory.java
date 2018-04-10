package com.twilio.test.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionHistory {

  private Map<String, List<Transaction>> transactions = new HashMap<>();

  public List<Transaction> getTransactionHistory(String userId) {
    List<Transaction> transactionList = transactions.get(userId);

    if (transactionList == null) {
      transactionList = new ArrayList<>();
    }
    return transactionList;
  }

  public void addTransaction(String userId, Transaction txn) {
    
    if (userId != null) {
      List<Transaction> transactionList = transactions.get(userId);
      if (transactionList == null) {
        transactionList = new ArrayList<>();
      }
      transactionList.add(txn);
      transactions.put(userId, transactionList);
      
    }
  }
}
