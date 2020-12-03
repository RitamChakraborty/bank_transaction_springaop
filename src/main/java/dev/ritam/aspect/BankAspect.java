package dev.ritam.aspect;

import dev.ritam.model.Bank;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BankAspect {
    private Bank bank;

    public Bank getBank() {
        return bank;
    }

    @Autowired
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Around("execution(public void dev.ritam.model.Bank.withdraw(..)) && args(amount)")
    public Object validateWithDraw(ProceedingJoinPoint joinPoint, int amount) throws Throwable {
        if (amount >= bank.getBalance()) {
            throw new RuntimeException("Insufficient Balance");
        }

        Object object = joinPoint.proceed();
        System.out.println("Your remaining balance is " + bank.getBalance());

        return object;
    }

    @After("execution(public void dev.ritam.model.Bank.setTempPin(..))")
    public void validatePin() {
        if (bank.getPinCode() != bank.getTempPin()) {
            throw new RuntimeException("Wrong Pin");
        } else {
            System.out.println("Correct Pin");
        }
    }

    @AfterThrowing(value = "execution(public void dev.ritam.model.Bank.setTempPin(..))", throwing = "e")
    public void logException(Exception e) {
        System.out.println(e.getMessage());
    }
}