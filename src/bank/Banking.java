package bank;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

/**
 *
 * @author V KUMAR
 */
public class Banking implements Bank {
    
    private double balance;

    @Override
    public void deposit(double amount) throws InvalidAmountException {
        if(amount <= 0){
            throw new InvalidAmountException(amount + " is invalid amount! Please enter correct amount!");
        }
        
        balance += amount;
    }

    @Override
    public double withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        
        if(amount <= 0)
            throw new InvalidAmountException(amount + " is invalid amount! Please enter correct amount!");
        
        if(balance < amount)
            throw new InsufficientBalanceException("Insufficient balance in the account! Please choose correct amount!");
        
        balance -= amount;
        return amount;
    }

    @Override
    public void balanceEnquiry() {
        System.out.println("Current Balance: " + balance);
    }
    
    
}
