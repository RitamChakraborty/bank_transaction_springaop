package dev.ritam;

import dev.ritam.config.AppConfig;
import dev.ritam.model.Bank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Bank bank = context.getBean(Bank.class);

        while (true) {
            System.out.println("Enter your pin:");
            int tempPin = scanner.nextInt();
            bank.setTempPin(tempPin);

            System.out.println("1. Show Balance");
            System.out.println("2. Cash Withdraw");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change Pin");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    bank.showBalance();
                    break;
                }
                case 2: {
                    System.out.println("Enter amount to be withdrawn:");
                    int amount = scanner.nextInt();
                    bank.withdraw(amount);
                    break;
                }
                case 3: {
                    System.out.println("Enter the amount to be deposited:");
                    int amount = scanner.nextInt();
                    bank.deposit(amount);
                    break;
                }
                case 4: {
                    System.out.println("Enter new pin:");
                    int newPin = scanner.nextInt();
                    bank.changePin(newPin);
                    break;
                }
                case 5: {
                    System.exit(0);
                }
                default: {
                    System.err.println("UNKNOWN INPUT!");
                }
            }
        }
    }
}