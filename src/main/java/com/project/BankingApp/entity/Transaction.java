package com.project.BankingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private int transactionId;

    private Operation operation;
    private Status status;
    private double amount;
    private double currBalance;
    private double balanceLeft;

}
