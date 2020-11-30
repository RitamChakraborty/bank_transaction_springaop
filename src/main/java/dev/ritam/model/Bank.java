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

    void withdraw(int amount) {
        balance -= amount;
        System.out.printf("\nYou have successfully withdrawn %d.", amount);
    }

    void deposit(int amount) {
        balance += amount;
        System.out.printf("\nYour balance is %d", amount);
    }

    void changePin(int newPin) {
        pinCode = newPin;
    }

    void showBalance() {
        System.out.printf("\nYour balance is %d", balance);
    }
}
