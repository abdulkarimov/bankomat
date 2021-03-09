package com.itbank.atm.dao;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.model.NationalBankAccount;

import java.util.ArrayList;
import java.util.List;

public class Database {

    static List <BankAccount> bankAccountList = new ArrayList<>();
    static{
        bankAccountList.add(new CityBankAccount(20000,"kz2441", "9999","Alex","Robertson"));
        bankAccountList.add(new CityBankAccount(40000,"kz2241", "2431","Mike","Tacker"));
        bankAccountList.add(new CityBankAccount(80000,"kz1441", "4432","Billy","Elroy"));
        bankAccountList.add(new CityBankAccount(4000000,"kz4521", "7777","Alihan","Ibrashev"));
        bankAccountList.add(new NationalBankAccount(10000,"kz2221", "7667","beka macaev"));
    }

    public static List<BankAccount> getBankAccountList() {
        return bankAccountList;
    }
}
