package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {


    @Test // нулевой баланс пополнение
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test // положительный баланс пополнение, неправельный код, баланс устанавливается на amount
    public void shouldAddToPositiveBalance2() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test //отрицательная сумма пополнения
    public void shouldAddToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToNegativeAmount2() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(-3_000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToPay1() { //сумма покупки меньше 0, должно возвращаться False
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.pay(-3_000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldAddToPay2() { //сумма покупки меньше 0, должно возвращаться False
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddToPay3() { //сумма покупки баланс должен уменьшаться на сумму покупки. Неправельный код, баланс устанавливается на -amount.
        CreditAccount account = new CreditAccount(
                5000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldAddToPay4() { //сумма покупки меньше больше лимита, должно возвращаться False
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void TestYearChange() {//положительный баланс, должно возвращаться 0, ошибка кода, нет проверки на баланс.
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        int actual = account.yearChange();

        Assertions.assertEquals(0, actual);
    }

    @Test
    public void TestYearChange2() {//Отрицательный баланс
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(200);
        account.yearChange();

        int actual = account.yearChange();

        Assertions.assertEquals(-30, actual);
    }


    @Test // исключения rate
    public void TestCreditAccount1() {

        Account account = new Account();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account1 = new CreditAccount(
                    0,
                    5000,
                    -15
            );
        });
    }

    @Test // исключения кредитного лимита, нужно добавить исключения
    public void TestCreditAccount2() {
        Account account = new Account();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account1 = new CreditAccount(
                    0,
                    -5000,
                    15
            );
        });
    }

    @Test // исключения стартового баланса, нужно добавить исключения
    public void TestCreditAccount3() {
        Account account = new Account();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account1 = new CreditAccount(
                    -1000,
                    5000,
                    15
            );
        });
    }

    @Test // выдаёт ошибку на rate = 0, хотя должен выдавать только на отрицательное число
    public void TestCreditAccount1rate0() {

        CreditAccount account = new CreditAccount(
                0,
                5_000,
                0
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
}
