public class Account implements Transferable {

    private String accountNumber;
    private String owner;
    private double balance;
    private TransactionHistory historia;

    public Account(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        this.historia = new TransactionHistory();
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public TransactionHistory getHistoria() {
        return historia;
    }

    public void deposit(double amount) {
        Transaction.deposit(this, amount);
    }

    public void withdraw(double amount) {
        Transaction.withdraw(this, amount);
    }

    @Override
    public void transfer(Account from, Account to, double amount) {
        Transaction.transfer(from, to, amount);
    }
}
