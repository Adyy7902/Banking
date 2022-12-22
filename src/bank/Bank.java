package bank;

import exceptions.InsufficientBalanceException;
import exceptions.InvalidAmountException;

/**
 *
 * @author V KUMAR
 */
public interface Bank {
    
    public void deposit(double amount) throws InvalidAmountException;
    
    public double withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException;
    
    public void balanceEnquiry();
}
