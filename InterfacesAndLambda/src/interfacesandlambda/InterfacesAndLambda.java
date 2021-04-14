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
public class InterfacesAndLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cheakable oblong1 = new CheakableOblong(5, 0);
        Cheakable oblong2 = new CheakableOblong(5, 5);

        System.out.println("oblong1 is " + checkValidity(oblong1));
        System.out.println("oblong2 is " + checkValidity(oblong2));
    }

    private static String checkValidity(Cheakable objectIn) {
        if (objectIn.check()) {
            return "valid";
        } 
        else {
            return "invalid";
        }
    }
}
