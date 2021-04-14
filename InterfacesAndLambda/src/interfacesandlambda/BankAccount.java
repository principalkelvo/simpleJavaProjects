/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesandlambda;

/**
 *
 * @author KELVO FRAYAY
 */
public class BankAccount {
    //private attributes
    private String accountNumber;
    private String accountName;
    private double balance;
    
    //THE METHODS
    
    //the constructor
    public BankAccount(String numberIn, String nameIn){
        accountNumber= numberIn;
        accountName= nameIn;
        balance= 0;
    }
    
    //methods to read attributes
    public String getAccountNumber(){
    return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
    public double getBalance(){
        return balance;
    }
    
    //methods to deposit and withdraw money
    public void deposit(double amountIn){
        balance= balance+ amountIn;
    }
    public boolean withdraw(double amountIn){
        if (amountIn>balance){
            return false;//no withdraw was made
        }
        else{
            balance= balance-amountIn;
            return true; //money was withdrawn successfully
        }
    }
}
