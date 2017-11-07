package stepic.flatmap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *  the total sum of canceled transactions for all non-empty accounts (balance > 0)
 */
public class TotalSumOfCanceledTransactions {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.stream()
                .filter(account -> (account.getBalance() > 0))
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() != State.CANCELED)
                .mapToLong(Transaction::getSum)
                .reduce(0, (elem, sum) -> elem + sum);
    }

    public static class Transaction {
        private String uuid;
        private State state;
        private Long sum;
        private Date created;

        public Transaction(String uuid, State state, Long sum, Date created) {
            this.uuid = uuid;
            this.state = state;
            this.sum = sum;
            this.created = created;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public Long getSum() {
            return sum;
        }

        public void setSum(Long sum) {
            this.sum = sum;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }
    }

    public static class Account {
        private String number;
        private Long balance;
        private List<Transaction> transactions;

        public Account(String number, Long balance, List<Transaction> transactions) {
            this.number = number;
            this.balance = balance;
            this.transactions = transactions;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public Long getBalance() {
            return balance;
        }

        public void setBalance(Long balance) {
            this.balance = balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }

        public void setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
        }
    }

    public static enum State {
        CANCELED, FINISHED, PROCESSING
    }

}
