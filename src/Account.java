public class Account implements Transferable {

    private String accountNumber;
    private String owner;
    private double balance;

    Account(String An, String O, double b) {
        accountNumber = An;
        owner = O;
        balance = b;


    }
    ////
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

    public void withdraw(double amount) {
        if(balance >= amount && amount > 0) {
            balance -= amount;
            System.out.println("Wypłacono " + amount+" PLN, na koncie pozostalo: "+balance+" PLN");
        }else{
            System.out.println("Zbyt niskie salko aby dokonać wypłaty!!");
        }
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Pomyślnie wpłacono "+amount+" PLN, na koncie jest obecnie: "+balance+" PLN");
        }else{
            System.out.println("Nieprawidłowa kwota wpłaty!!");
        }
    }

    public void transfer(){

    }

    @Override
    public void transfer(Account acc1, Account acc2, double amount) {
        if(acc1.balance >= amount && amount > 0){
            acc1.balance -= amount;
            acc2.balance += amount;
            System.out.println("pomyslnie przelano "+amount+" PLN do uzytkownika "+acc2.owner);
        }else{
            System.out.println("nieprawidłowa kwota przelewu lub brak wystarczających średkow na koncie!!");
        }
    }
}
