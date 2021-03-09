package com.itbank.atm;

import com.itbank.atm.model.BankAccount;
import com.itbank.atm.service.BankService;
import com.itbank.atm.service.BankServiceImpl;

import java.util.Scanner;

public class CityBankATM {
    public static void main(String[] args) {
        //psvm
        BankService service = new BankServiceImpl();
        boolean f = true;
        Scanner cin = new Scanner(System.in);
        System.out.println("введите номер карты");
        String number = cin.next();
        System.out.println("введите пин код");
        String password = cin.next();
        BankAccount client = service.getClient(number, password);

        String className = client.getClass().getSimpleName();

        if(className.equals("CityBankAccount")) {
            while (f) {

                System.out.println("  PRESS [1] TO CASH WITHDRAWAL ");
                System.out.println("  PRESS [2] TO VIEW BALANCE  ");
                System.out.println("  PRESS [3] TO CHANGE PIN CODE ");
                System.out.println("  PRESS [4] TO REFILL ACCOUNT ");
                System.out.println("  PRESS [5] TO VIEW ACCOUNT DATA  ");
                System.out.println("  PRESS [6] TO EXIT  ");

                Integer press = cin.nextInt();

                switch (press) {
                    case (1):
                        System.out.println(" сколько хотите снять? ");
                        Integer money = cin.nextInt();
                        service.withdrawal(client, money);
                        break;
                    case (2):
                        System.out.println("на вашем счету " + client.getBalance());
                        break;
                    case (3):
                        System.out.println(" новый пароль ");
                        String newpPassword = cin.next();
                        client.setPinCode(newpPassword);
                        break;
                    case (4):
                        System.out.println("сумма пополнения ");
                        Integer money2 = cin.nextInt();
                        service.replenishment(client, money2);
                        break;
                    case (5):
                        System.out.println(service.accountData(client));
                        break;
                    case (6):
                        f = false;
                        break;
                }
            }
        }
        else if(className.equals("NationalBankAccount"))
        {
            while (f) {

                System.out.println("  PRESS [1] TO CASH WITHDRAWAL ");
                System.out.println("  PRESS [2] TO VIEW BALANCE  ");
                System.out.println("  PRESS [3] TO EXIT ");

                Integer press = cin.nextInt();

                switch (press) {
                    case (1):
                        System.out.println(" сколько хотите снять? ");
                        Integer money = cin.nextInt();
                        service.withdrawal(client, money + 200);
                        break;
                    case (2):
                        System.out.println("на вашем счету " + client.getBalance());
                        break;
                    case (3):
                        f = false;
                        break;
                }
            }
        }

        }

}
