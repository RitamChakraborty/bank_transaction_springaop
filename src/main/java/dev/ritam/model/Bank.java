package dev.ritam.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bank {
    private int pinCode;
    private int balance;
    private int tempPin;

    public int getPinCode() {
        return pinCode;
    }

    @Value("6789")
    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    @Value("10000")
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTempPin() {
        return tempPin;
    }

    public void setTempPin(int tempPin) {
        this.tempPin = tempPin;
    }

    public void withdraw(int amount) {
        balance -= amount;
        System.out.printf("You have successfully withdrawn %d.\n", amount);
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.printf("Your balance is %d.\n", balance);
    }

    public void changePin(int newPin) {
        pinCode = newPin;
    }

    public void showBalance() {
        System.out.printf("Your balance is %d\n", balance);
    }
}
