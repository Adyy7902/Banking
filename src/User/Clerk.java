package User;

import bank.Bank;
import bank.Banking;
import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author V KUMAR
 */
public class Clerk {
    public static void main(String[] args) {
        try{
            Bank account = new Banking();
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            
            String option = "";
            do{
                try{
                    System.out.println("Choose one option: ");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Balance Enquiry");
                    
                    System.out.print("Enter option: ");
                    option = read.readLine();
                    
                    switch(option){
                        case "1" ->
                        {
                            System.out.print("Enter amount to deposit: ");
                            String s = read.readLine();
                            double amount = Double.parseDouble(s);
                            
                            account.deposit(amount);
                            System.out.println(amount + " have been deposited in your account!");
                            account.balanceEnquiry();
                            
                        }
                        case "2" ->
                        {
                            System.out.print("Enter amount to withdraw: ");
                            String s = read.readLine();
                            double amount = Double.parseDouble(s);
                                
                            double withdraw = account.withdraw(amount);
                            System.out.println(withdraw + " have been withdrawn from you account!");
                            account.balanceEnquiry();
                        }
                        case "3" ->
                        {
                            account.balanceEnquiry();
                        }
                        default ->
                        { 
                                    System.out.println("Invalid Option!");
                        }
                    }
                }catch(InvalidAmountException | InsufficientBalanceException e){
                    System.out.println(e.getMessage());
                }catch(NumberFormatException nfe){
                    System.out.println("Please enter number only!");
                }
                System.out.print("Do you want to continue: (yes/no) ");
                option = read.readLine();
            }while(option.equalsIgnoreCase("yes")||option.equalsIgnoreCase("y"));
            System.out.println("Thank You for using our Bank!!");
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
