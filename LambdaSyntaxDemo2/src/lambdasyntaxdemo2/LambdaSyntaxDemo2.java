/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambdasyntaxdemo2;

/**
 *
 * @author KELVO FRAYAY
 */
public class LambdaSyntaxDemo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        testMethod(()->{
            System.out.print("Hello ");
            System.out.println("World");
        });
    }
    static void testMethod(TestInterface testObjectIn){
        testObjectIn.test();
    }
}
