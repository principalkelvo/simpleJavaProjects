/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;
import java.util.Scanner;

/**
 *
 * @author KELVO FRAYAY
 */
public class EasyScanner {
    public static int nextInt(){
        Scanner keyboard = new Scanner(System.in);
        int i = keyboard.nextInt();
        return i;
    }
    public static double nextDouble(){
        Scanner keyboard = new Scanner(System.in);
        double d = keyboard.nextDouble();
        return d;
    }
    public static String nextString(){
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.nextLine();
        return s;
    }
    public static char nextChar(){
        Scanner keyboard = new Scanner(System.in);
        char c = keyboard.next().charAt(0);
        return c;
    }
}
