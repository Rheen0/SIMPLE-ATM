import java.util.Scanner;

public class MicasamaATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        double bal = 0;
        int pin = 1234;
        int maxAttempts = 3;
        boolean isAuthenticated = false;
        boolean isTrue = true;

        // Message banner
        System.out.println("\n*********************************");
        System.out.println("*    Welcome to Micasama ATM    *");
        System.out.println("*********************************\n");

        // Usage of For Loop in order to check the input of user
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Enter your 4-digit PIN: ");
            int userPin = input.nextInt();

            if (userPin == pin) {
                System.out.println("PIN is correct. Welcome!");
                isAuthenticated = true;
                break;
            } else {
                System.out.println("Incorrect PIN. Please try again.");
                if (attempt == maxAttempts) {
                    System.out.println("Too many failed attempts. Exiting...");
                    isTrue = false;
                }
            }
        }

        // Usage of While Loop to continue program until condition is false
        while (isTrue && isAuthenticated) {
            System.out.println("\n****************************************");
            System.out.println("*          Micasama ATM Menu           *");
            System.out.println("****************************************");
            System.out.println("* 1. Check Balance                     *");
            System.out.println("* 2. Deposit Money                     *");
            System.out.println("* 3. Withdraw Money                    *");
            System.out.println("* 4. Exit                              *");
            System.out.println("****************************************");
            System.out.println("Enter your choice: ");

            choice = input.nextInt();

            // Switch cases for the choices
            switch (choice) {
                case 1:
                    System.out.println("\n----------------------------");
                    System.out.println("Your current balance is: $" + bal);
                    System.out.println("----------------------------");
                    break;

                case 2:
                    double deposit;
                    do {
                        System.out.print("Enter deposit amount: $");
                        deposit = input.nextDouble();
                        if (deposit <= 0) {
                            System.out.println("Invalid amount. Please enter a positive value.");
                        }
                    } while (deposit <= 0);

                    bal += deposit;
                    System.out.println("The amount $" + deposit + " is successfully deposited.");
                    System.out.println("----------------------------");
                    break;

                case 3:
                    double withdraw;
                    System.out.print("Enter the withdrawal amount: ");
                    withdraw = input.nextDouble();
                    if (withdraw > 0 && withdraw <= bal) {
                        bal -= withdraw;
                        System.out.println("You successfully withdrew the amount $" + withdraw);
                        System.out.println("----------------------------");
                    } else if (withdraw > bal) {
                        System.out.println("Insufficient balance. Please try again.");
                        System.out.println("----------------------------");
                    } else {
                        System.out.println("The amount you entered is invalid. Please try again.");
                        System.out.println("----------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Micasama ATM simulation!");
                    isTrue = false;
                    break;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }

        input.close();
    }
}
