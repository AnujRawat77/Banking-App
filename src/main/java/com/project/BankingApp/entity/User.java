package com.project.BankingApp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;

    private double balance;
    private List<Transaction> transactions;
}
