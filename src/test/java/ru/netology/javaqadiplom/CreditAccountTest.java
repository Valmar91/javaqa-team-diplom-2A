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

    @Test // положительный баланс пополнение
    public void shouldAddToPositiveBalance2() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test //пополнение с отрицательным балансом
    public void shouldAddToPositiveBalance3() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(4_000);
        account.add(3_000);

        Assertions.assertEquals(-1_000, account.getBalance());
    }

    @Test //пополнение с отрицательным балансом
    public void shouldAddToPositiveBalance4() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(4_000);
        account.add(6_000);

        Assertions.assertEquals(2_000, account.getBalance());
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
    public void shouldAddToPay3() { //сумма покупки баланс должен уменьшаться на сумму покупки.
        CreditAccount account = new CreditAccount(
                5000,
                5_000,
                15
        );

        account.pay(3_000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void shouldAddToPay4() { //сумма покупки больше лимита, должно возвращаться False
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test //покупка до кридитного лимита на отрицательное значение
    public void shouldAddToPay5() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test //несколько покупок превышающих кредитный лимит
    public void shouldAddToPay6() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );
        account.pay(3000);
        account.pay(3000);
        account.pay(3000);

        Assertions.assertEquals(-4000, account.getBalance());

    }

    @Test //несколько покупок до кредитного лиммита
    public void shouldAddToPay7() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );
        account.pay(3000);
        account.pay(3000);

        Assertions.assertEquals(-4000, account.getBalance());

    }

    @Test // покупка
    public void shouldAddToPay8() {
        CreditAccount account = new CreditAccount(
                10000,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(7000, account.getBalance());
    }

    @Test
    public void TestYearChange() {//положительный баланс
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

    @Test
    public void TestYearChange3() {//0 баланс
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.yearChange();

        int actual = account.yearChange();

        Assertions.assertEquals(0, actual);
    }


    @Test // исключения rate
    public void TestCreditAccount1() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    5000,
                    -15
            );
        });
    }

    @Test // исключения кредитного лимита, нужно добавить исключения
    public void TestCreditAccount2() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    0,
                    -5000,
                    15
            );
        });
    }

    @Test // исключения стартового баланса
    public void TestCreditAccount3() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(
                    -1000,
                    5000,
                    15
            );
        });
    }

    @Test //
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
