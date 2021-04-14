/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package innerclassdemo;

/**
 *
 * @author KELVO FRAYAY
 */
public class InnerClassDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inner class
        class CheakableOblong extends Oblong implements Cheakable {
            //override the comstructor

            public CheakableOblong(double lengthIn, double heightIn) {
                super(lengthIn, heightIn);
            }

            @Override
            public boolean check() {//the check method of Cheakable mudt be overriden
                //the length and height must both be greater than zero
                return getLength() > 0 && getHeight() > 0;
            }
        }
        Cheakable oblong1 = new CheakableOblong(5, 0);
        Cheakable oblong2 = new CheakableOblong(5, 5);

        System.out.println("oblong1 is " + checkValidity(oblong1));
        System.out.println("oblong2 is " + checkValidity(oblong2));
    }

    private static String checkValidity(Cheakable objectIn) {
        if (objectIn.check()) {
            return "valid";
        } else {
            return "invalid";
        }
    }
}
