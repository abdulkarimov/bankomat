package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

import java.util.List;

public class BankServiceImpl implements BankService {


    @Override
    public BankAccount getClient(String accountNumber, String pincode) {

        BankAccount client = null;

        for (BankAccount account : Database.getBankAccountList()) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPinCode().equals(pincode)){
                client = account;
                break;
            }
        }
        return client;
    }

    @Override
    public String getAccountNumber(BankAccount client) {
        return client.getAccountNumber().toString();
    }

    @Override
    public String getPinCode(BankAccount client) {
        return client.getPinCode().toString();
    }

    @Override
    public void setPinCode(BankAccount client, String pinCode) {
        client.setPinCode(pinCode);
    }

    @Override
    public Integer totalBalance(BankAccount client) {
        return client.getBalance();
    }

    @Override
    public void withdrawal(BankAccount client, Integer money) {
            Integer a = client.getBalance();
            if(a >= money) {
                a -= money;
                client.setBalance(a);
            }
            else
                System.out.println("не достаточно средств");
    }

    @Override
    public void replenishment(BankAccount client, Integer money) {
        Integer a = client.getBalance();
        a += money;
        client.setBalance(a);
    }

    @Override
    public String accountData(BankAccount client) {

       String s = client.getAccountNumber() +" "+ client.getPinCode() +" "+ client.getBalance();
       return s;

    }
}
