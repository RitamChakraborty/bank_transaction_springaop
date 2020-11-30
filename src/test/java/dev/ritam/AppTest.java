package dev.ritam;

import dev.ritam.config.AppConfig;
import dev.ritam.model.Bank;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AppTest {
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    public void test() {
        Bank bank = context.getBean(Bank.class);

        assertNotNull(bank);
        assertEquals(10000, bank.getBalance());
        assertEquals(6789, bank.getPinCode());
    }
}
