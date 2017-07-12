package bigjava.exercise_e19_8;

import java.util.Arrays;
import java.util.function.Function;

/**
 * • E19.8 Write a program that sorts an array of bank accounts by increasing balance. Pass an
 * appropriate lambda expression to Arrays.sort
 */
public class Exercise_e19_8 {

    public static void main(String[] args) {
        Account[] accounts = setBankAccounts();
        for (Account account: accounts) {
            System.out.println(account);
        }
        Arrays.sort(accounts,(o1, o2) -> {return o1.getBalance() - o2.getBalance();} );
        System.out.println(" ------------- ");
        for (Account account: accounts) {
            System.out.println(account);
        }
    }

    public static Account[] setBankAccounts() {
        Account[] accounts = {
            new Account(1L, 2000, true),
            new Account(2L, 5000, false),
            new Account(3L, 300, false),
            new Account(4L, 3000, false),
            new Account(5L, 700, true),
            new Account(6L, 4000, true),
            new Account(7L, 8000, true)
        };
        return accounts;
    }

}
