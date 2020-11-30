package dev.ritam.model;

public class Bank {
    private int pinCode;
    private int balance;
    private int tempPin;

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

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
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("\nYou have successfully withdrawn %d.", amount);
        } else {
            System.out.println("Insufficient Fund");
        }
    }

    void deposit(int amount) {
        balance += amount;
        System.out.printf("\nYour balance is %d", amount);
    }

    void changePin(int oldPin, int newPin) {
        if (oldPin != pinCode) {
            throw new RuntimeException();
        } else {
            pinCode = newPin;
        }
    }

    void showBalance() {
        System.out.printf("\nYour balance is %d", balance);
    }
}
