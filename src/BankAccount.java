import java.util.Scanner;
import java.util.InputMismatchException;

public class BankAccount {
    double bal;
    double prevTrans;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(double amount) {
        if (amount > 0) {
            bal += amount;
            prevTrans = -amount;
            System.out.println("Successfully Deposited " + amount);
        } else {
            System.out.println("Please enter a value higher than 0");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && bal >= amount) {
            bal -= amount;
            prevTrans = amount;
            System.out.println("Successfully withdrew " + amount);
        } else if (bal < amount) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Please enter a value higher than 0");
        }
    }

    void getPreviousTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrew: " + Math.abs(prevTrans));
        } else {
            System.out.println("No previous transactions.");
        }
    }

    void menu() {
        char option;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println("\n");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            System.out.println("a) Check Balance");
            System.out.println("b) Deposit Amount");
            System.out.println("c) Withdraw Amount");
            System.out.println("d) Previous Transaction");
            System.out.println("e) Exit");
            option = Character.toLowerCase(sc.next().charAt(0));
            System.out.println("\n");

            switch (option) {
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balance = " + bal);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("......................");
                    try {
                        double amountIn = sc.nextDouble();
                        deposit(amountIn);
                        System.out.println("\n");
                        break;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Please enter a valid number");
                        break;
                    }
                case 'c':
                    System.out.println("......................");
                    System.out.println("Enter an amount to withdraw: ");
                    System.out.println("......................");
                    try {
                        double amountOut = sc.nextDouble();
                        withdraw(amountOut);
                        System.out.println("\n");
                        break;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Please enter a valid number");
                        break;
                    }
                case 'd':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'e':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }

        } while (option != 'e');

        System.out.println("Thank you for banking with Reyaly Bank");
    }
}
