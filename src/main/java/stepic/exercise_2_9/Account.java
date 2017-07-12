package stepic.exercise_2_9;

public class Account {

    private Long number;
    private Integer balance;
    private boolean isLocked;

    public Account() { }

    public Account(Long number, Integer balance, boolean isLocked) {
        this.number = number;
        this.balance = balance;
        this.isLocked = isLocked;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                ", balance=" + balance +
                ", isLocked=" + isLocked +
                '}';
    }

}
