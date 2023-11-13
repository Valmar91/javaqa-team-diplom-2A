package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
    @Test
    public void shouldThrowIllegalArgumentException() {
        SavingAccount account = new SavingAccount(
                2_000,
                10_000,
                10_000,
                -5
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(2_000, 10_000, 10_000, -5);
        });
    }

    @Test
    public void shouldAddAmountToActualBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

@Test
public void shouldNotAddAmountIfResultMoreThanMaxBalance() {
    SavingAccount account = new SavingAccount(
            2_000,
            1_000,
            10_000,
            5
    );

    account.add(9_000);

    Assertions.assertEquals(2000, account.getBalance());
}
    @Test
    public void shouldNotAddMinusAmount() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldNotChangeBalanceIfAddZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayFromCard() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1500, account.getBalance());
    }
    @Test
    public void shouldNotPayFromCardIfBalanceBecomesLessThanMinimum() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1500);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldNotPayFromCardIfBalanceBecomesZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(2000);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldNotPayFromCardIfBalanceBecomesMinusSum() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(2500);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldNotPayFromCardMinusSum() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-500);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldNotChangeBalanceIfPayZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void shouldMakePercentOnBalance() {
        SavingAccount account = new SavingAccount(
                200,
                100,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(30, account.yearChange());
    }

}


