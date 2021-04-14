/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

/**Class used to store details of a single payment in a hostel
 * @author KELVO FRAYAY
 * @version 8th May 2020
 */
public class Payment {
    private String month;
    private Double amount;
    
    /**Constructor initializes the payment month and the amount paid
     * @param monthIn: month of payment
     * @param amountIn: amount of payment
    */
    public Payment(String monthIn,double amountIn){
        month= monthIn;
        amount= amountIn;
    }
    
    /**Reads the month for payment was made
     * @return Returns the month for which payment was made
    */
    public String getMonth(){
        return month;
    }
    
    /**Reads the amount paid
     * @return Returns the amount paid
     */
    public double getAmount(){
        return amount;
    }
    
    @Override
    public String toString(){
        return"("+month+","+amount+")";//a convenient way to displaying attributes
    }
}
