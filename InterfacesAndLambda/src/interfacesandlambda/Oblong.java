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
public class Oblong {
    //the attributes
    private double length;
    private double height;
    
    //the methods
    //the constructor
    public Oblong(double lengthIn, double heightIn){
        length = lengthIn;
        height = heightIn;
    }
    //this method allows us to read the length attribute
    public double getLength(){
        return length;
    }
    //this method allow us to read the height attribute
    public double getHeight(){
        return height;
    }
    //this method allow us to write the length attribute
    public void setLength(double lengthIn){
        length= lengthIn;
    }
    //this method allow us to write the height attribute
    public void setHeight(double heightIn){
        height= heightIn;
    }
    //this method returns the area of the Oblong
    public double calculateArea(){
        double area= length*height;
        return area;
    }
    //this method returns the perimeter of the Oblong
    public double calculatePerimeter(){
        double perimeter= 2*(length+height);
        return perimeter;
    }
}
