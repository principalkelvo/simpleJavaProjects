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
public class CheakableBankAccount extends BankAccount implements Cheakable {
    //override the constructor
    public CheakableBankAccount(String numberIn, String nameIn){
        super(numberIn, nameIn);
    }
    @Override
    public boolean check() {
        //check that the account number is exactly 8 charactors
        if (getAccountNumber().length() != 8) {
            return false;
        }
        //check that the accountnumber contains only digits
        for (int i = 0; i <= 7; i++) {
            if (!Character.isDigit(getAccountNumber().charAt(i))) {
                return false;
            }
        }
        //check that accountName contains only alphabets
        for(int i=0; i<=getAccountName().length();i++){
            if(!Character.isAlphabetic(getAccountName().charAt(i))){
                return false;
            }
        }
        return true;
    }
}
