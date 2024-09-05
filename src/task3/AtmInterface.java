package task3;

import java.util.Scanner;

public class AtmInterface {

    private BankAccount bankAccount;
    Scanner sc;

    public AtmInterface(BankAccount bankAccount)
    {
        this.bankAccount=bankAccount;
        this.sc=new Scanner(System.in);
    }
    public void showAtmMenu()
    {
        System.out.println("Welcome to ATM Machine!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void withdraw(double amount)
    {
        if(bankAccount.withdraw(amount)){
            System.out.println("Withdrawal successful"+amount);
        }

        else
        {
            System.out.println("Insufficient or invalid amount");
        }
    }

    public void deposit(double amount)
    {
        if (bankAccount.deposit(amount))
        {
            System.out.println("Deposited amount: "+amount);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }

    //method to check balance
    public void checkBalance()
    {
        System.out.println("Your current balance is $"+ bankAccount.checkBalance());
    }

    //method to display balance after a transaction
    public  void displayBalance(){
        System.out.println("Your balance after transaction is :"+ bankAccount.checkBalance());
    }

    public static void main(String [] args)
    {
        BankAccount bankAccount1=new BankAccount("john", 1000);
        AtmInterface atm=new AtmInterface(bankAccount1);
        Scanner scanner=new Scanner(System.in);

        while (true)
        {
            atm.showAtmMenu(); //displaying atm machine
            System.out.println("Select the option from 1 to 4!");

            int choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the amount to withdraw");
                    double withDrawAmount=scanner.nextDouble();
                    atm.withdraw(withDrawAmount);
                    atm.displayBalance();
                    break;

                case 2:
                    System.out.println("Enter the amount to deposit");
                    double depositAmount=scanner.nextDouble();
                    atm.deposit(depositAmount);
                    atm.displayBalance();
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you!!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Please enter valid option.");
                    break;
            }


        }
    }
}


