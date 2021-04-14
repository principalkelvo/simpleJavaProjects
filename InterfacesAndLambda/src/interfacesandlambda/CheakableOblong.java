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
public class CheakableOblong extends Oblong implements Cheakable{
    //override the comstructor
    public CheakableOblong(double lengthIn, double heightIn){
        super(lengthIn,heightIn);
    }
    @Override
    public boolean check(){//the check method of Cheakable mudt be overriden
        //the length and height must both be greater than zero
        return getLength()>0&&getHeight()>0;
    }
}
