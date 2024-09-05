package task3;

public class BankAccount {
    private String accountHolder;
    private double balance;

//    constructor to initialize account with accountHolder ad balance
    public BankAccount(String accountHolder, double balance)
    {
        this.accountHolder=accountHolder;
        this.accountHolder=accountHolder;
    }

    public boolean deposit(double amount){
        if(amount>0)
        {
            this.balance+=amount;
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean withdraw(double amount)
    {
        if(amount>0 && amount<=balance)
        {
            balance-=amount;
            return true;
        }

        else {
            return false;
        }
    }

    public double checkBalance()
    {
        return balance;
    }



}
