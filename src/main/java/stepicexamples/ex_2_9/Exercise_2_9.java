package stepicexamples.ex_2_9;

import java.util.ArrayList;
import java.util.List;

public class Exercise_2_9 {

    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<Account>();
        setBankAccounts(accountList);
        Filter<Account>  filter = new Filter<>();

        List<Account> nonEmptyAccounts = filter.doFilter(accountList, account -> account.getBalance() > 0);
        nonEmptyAccounts.forEach(account -> System.out.println(account));

        List<Account> accountsWithTooMuchMoney = filter.doFilter(accountList, account -> (account.isLocked() == false) && (account.getBalance() >= 100000000));
        accountsWithTooMuchMoney.forEach(account -> System.out.println(account));
    }


    public static void setBankAccounts(List<Account> accounts) {
        accounts.add(new Account(1L, 2000, true));
        accounts.add(new Account(2L, 5000, false));
        accounts.add(new Account(3L, 100000000, false));
        accounts.add(new Account(4L, 100000001, false));
        accounts.add(new Account(5L, 100000031, true));
        accounts.add(new Account(6L, 0, true));
        accounts.add(new Account(7L, 0, true));
    }

}
