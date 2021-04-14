/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;


/**GUI for the Hostel application
 * @author KELVO FRAYAY
 * @version 11th August 2020
 */
public class Hostel extends Application {
    
    //the attributes
    private int noOfRooms;
    private TenantList list;
    
    //WIDTH and HEIGHT of GUI stored as constants
    private final int WIDTH= 800;
    private final int HEIGHT=500;
    
    //visual components
    private Label headingLabel= new Label("Hostel Application");
    private Label roomLabel1= new Label("Room");
    private TextField roomField1= new TextField();
    private Label nameLabel= new Label("Name");
    private TextField nameField= new TextField();
    private Button addButton= new Button("add Tenant");
    private Button displayButton= new Button("Display Tenant");
    private Button removeButton= new Button("Remove Tenant");
    private Button saveAndQuitButton= new Button("Save and Quit");;
    private TextArea displayArea1= new TextArea();
    private Label roomLabel2= new Label("Room");
    private TextField roomField2= new TextField();
    private Label monthLabel= new Label("Month");
    private TextField monthField= new TextField();
    private Label amountLabel= new Label("Amount");
    private TextField amountField= new TextField();
    private Button paymentButton= new Button("Make Payments");
    private Button listButton= new Button("List Payments");;
    private TextArea displayArea2= new TextArea();
    
    
    @Override
    /**initializes the screen
     * @param stage: The scene's stage
     */
    public void start(Stage stage){
    noOfRooms= getNumberOfRooms();//call private method
    
    //initialize tenant list
    list= new TenantList(noOfRooms);
    TenantFileHandler.readRecords(list);
    
    //create four HBoxes
    HBox roomDetails = new HBox(10);
    HBox tenantButtons = new HBox(10);
    HBox paymentDetails = new HBox(10);
    HBox paymentButtons = new HBox(10);
    
    //add components to HBoxes
    roomDetails.getChildren().addAll(roomLabel1,roomField1,nameLabel,nameField);
    tenantButtons.getChildren().addAll(addButton,displayButton,removeButton,saveAndQuitButton);
    paymentDetails.getChildren().addAll(roomLabel2,roomField2,monthLabel,monthField,
                                        amountLabel,amountField);
    paymentButtons.getChildren().addAll(paymentButton,listButton);
    
    //create VBox
    VBox root= new VBox(10);
    //add all components to VBox
    root.getChildren().addAll(headingLabel,roomDetails,tenantButtons,displayArea1,
                               paymentDetails,paymentButtons,displayArea2);
    
    //create the scene
    Scene scene= new Scene(root,Color.LIGHTBLUE);
    
    //set font of heading
    Font font = new Font("Calibri",40);
    headingLabel.setFont(font);
    
    //set alignment of HBoxes
    roomDetails.setAlignment(Pos.CENTER);
    tenantButtons.setAlignment(Pos.CENTER);
    paymentDetails.setAlignment(Pos.CENTER);
    paymentButtons.setAlignment(Pos.CENTER);
    
    //set alignment of VBox
    root.setAlignment(Pos.CENTER);
    
    //set minimum and maximum width of components
    roomField1.setMaxWidth(50);
    roomField2.setMaxWidth(50);
    
    roomDetails.setMinWidth(WIDTH);
    roomDetails.setMaxWidth(WIDTH);
    
    tenantButtons.setMinWidth(WIDTH);
    tenantButtons.setMaxWidth(WIDTH);
    
    paymentDetails.setMinWidth(WIDTH);
    paymentDetails.setMaxWidth(WIDTH);
    
    roomDetails.setMinWidth(WIDTH);
    roomDetails.setMaxWidth(WIDTH);
    
    paymentButtons.setMinWidth(WIDTH);
    paymentButtons.setMaxWidth(WIDTH);
    
    root.setMinSize(WIDTH,HEIGHT);
    root.setMaxSize(WIDTH, HEIGHT);
    
    displayArea1.setMaxSize(WIDTH-80, HEIGHT/5);
    displayArea2.setMaxSize(WIDTH-80, HEIGHT/5);
    
    stage.setWidth(WIDTH);
    stage.setHeight(HEIGHT);
    
    //customize the visual components
    
    //customize the VBox boarder and background
    BorderStroke style= new BorderStroke(Color.BLACK,BorderStrokeStyle.SOLID,
                                        new CornerRadii(0),new BorderWidths(2));
    root.setBorder(new Border(style));
    root.setBackground(Background.EMPTY);
    
    //customize buttons
    addButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                            new CornerRadii(10),Insets.EMPTY)));
    displayButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                            new CornerRadii(10),Insets.EMPTY)));
    removeButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                            new CornerRadii(10),Insets.EMPTY)));
    saveAndQuitButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                            new CornerRadii(10),Insets.EMPTY)));
    paymentButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                            new CornerRadii(10),Insets.EMPTY)));
    listButton.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,
                            new CornerRadii(10),Insets.EMPTY)));
    
    //call private methods for button event handlers
    addButton.setOnAction(e->addHandler());
    displayButton.setOnAction(e->displayHandler());
    removeButton.setOnAction(e->removeHandler());
    paymentButton.setOnAction(e->paymentHandler());
    listButton.setOnAction(e->listHandler());
    saveAndQuitButton.setOnAction(e->saveAndQuitHandler());
    
    //configure the stage and make the stage visible
    stage.setScene(scene);
    stage.setTitle("Hostel Application");
    stage.setResizable(false);
    stage.show();
}
    
    
    /**
     * Method to request number of hostel rooms from the user
     * @return number of rooms
     */
    private int getNumberOfRooms(){
        TextInputDialog dialog= new TextInputDialog();
        dialog.setHeaderText("How many rooms? ");
        dialog.setTitle("Room Information Request");
        String response = dialog.showAndWait().get();
        return Integer.parseInt((response));
    }
    
    
    //event handler methods
    private void addHandler(){
        String roomEntered = roomField1.getText();
        String nameEntered = nameField.getText();
        
        //check for errors
        if(roomEntered.length()==0 || nameEntered.length()==0){
            displayArea1.setText("Room number and name must be entered");
        }
        else if(Integer.parseInt(roomEntered)<1 || Integer.parseInt(roomEntered)>noOfRooms){
            displayArea1.setText("There are only "+noOfRooms+" rooms");
        }
        else if(list.search(Integer.parseInt(roomEntered))!=null){
            displayArea1.setText("Room number "+Integer.parseInt(roomEntered)+" is occupied");
        }
        else{//ok to add a tenant
            Tenant t= new Tenant(nameEntered,Integer.parseInt(roomEntered));
            list.addTenant(t);
            roomField1.setText("");
            nameField.setText("");
            displayArea1.setText("New tenant in room "+roomEntered+" successfully added");
        }
    }
    private void displayHandler(){
        int i;
        if(list.isEmpty()){//no rooms to display
            displayArea1.setText("All rooms are empty");
        }
        else{//display rooms
            displayArea1.setText("Room"+"\t"+"Name"+"\n");
            for(i=1;i<=list.getTotal();i++){
                displayArea1.appendText(list.getTenant(i).getRoom()+"\t\t"
                                        +list.getTenant(i).getName()+"\n");
            }
        }
        
    }
    private void removeHandler(){
        String roomEntered= roomField1.getText();
        
        //check for errors
        if(roomEntered.length()==0){
            displayArea1.setText("Room number must be entered");
        }
        else if(Integer.parseInt(roomEntered)<1 || Integer.parseInt(roomEntered)>noOfRooms){
            displayArea1.setText("Invalid room number");
        }
        else if(list.search(Integer.parseInt(roomEntered))==null){
            displayArea1.setText("Room number "+roomEntered+" is empty");
        }
        else{//ok to remove Tenant
            list.removeTenant(Integer.parseInt(roomEntered));
            displayArea1.setText("Tenant removed from room "+Integer.parseInt(roomEntered));
        }
    }
    private void paymentHandler(){
        String roomEntered = roomField2.getText();
        String monthEntered = monthField.getText();
        String amountEntered = amountField.getText();
        
        //check for errors
        if(roomEntered.length()==0||monthEntered.length()==0||amountEntered.length()==0){
            displayArea2.setText("Room number,month and amount must all be entered");
        }
        else if(Integer.parseInt(roomEntered)<1||Integer.parseInt(roomEntered)>noOfRooms){
            displayArea2.setText("invalid room number");
        }
        else if(list.search(Integer.parseInt(roomEntered))==null){
            displayArea2.setText("Room number "+roomEntered+" is Empty");
        }
        else if(Double.parseDouble(amountEntered)<0){
            displayArea2.setText("Amount cant be negative");
        }
        else{//ok to process payment
            Payment p= new Payment(monthEntered,Double.parseDouble(amountEntered));
            list.search(Integer.parseInt(roomEntered)).makePayment(p);
            displayArea2.setText("Payment recorded");
        }
    }
    private void listHandler(){
        int i;
        String roomEntered = roomField2.getText();
        if(roomEntered.length()==0){
            displayArea2.setText("Room number,month and amount must all be entered");
        }
        else if(Integer.parseInt(roomEntered)<1||Integer.parseInt(roomEntered)>noOfRooms){
            displayArea2.setText("invalid room number");
        }
        else if(list.search(Integer.parseInt(roomEntered))==null){
            displayArea2.setText("Room number "+roomEntered+" is Empty");
        }
        else{ //ok to list payments
            Tenant t= list.search(Integer.parseInt(roomEntered));
            PaymentList p= t.getPayments();
            if(t.getPayments().getTotal()==0){
                displayArea2.setText("No payments made for this tenant");
            }
            else{
                /*
                The NumberFormat class is similar to the DecimalFormat class.
                The getCurrencyInstance method of this class reads the system 
                values to find out which country you are in, then uses the correct
                currency symbol
                */
                NumberFormat nf= NumberFormat.getCurrencyInstance();
                String s;
                displayArea2.setText("Month "+"\t\t"+"Amount"+"\n");
                for(i=1;i<=p.getTotal();i++){
                    s= nf.format(p.getPayment(i).getAmount());
                    displayArea2.appendText(""+p.getPayment(i).getMonth()+"\t\t\t"+s+"\n");
                }
                displayArea2.appendText("\n"+"Total paid so far: "+nf.format(p.calculateTotalPaid()));
                monthField.setText("");
                amountField.setText("");
            }
        }
    }
    private void saveAndQuitHandler(){
        TenantFileHandler.saveRecords(noOfRooms, list);
        Platform.exit();
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
       /* // payment tester
        Payment p1= new Payment("January",175);//create object to test
        System.out.println(p1);//this will call the toString method in our Payment class
        //PaymentList tester
        char choice;
        int size;
        PaymentList list;//declare PaymentList object to test
        //get size of list
        System.out.println("size of list?");
        size= EasyScanner.nextInt();
        list= new PaymentList(size);//create object to test
        
        //menu
        do{
         //display options
         System.out.println();
         System.out.println("[1] ADD");
         System.out.println("[2] DISPLAY");
         System.out.println("[3] IS FULL");
         System.out.println("[4] GET PAYMENT");
         System.out.println("[5] GET TOTAL");
         System.out.println("[6] CALCULATE TOTAL PAID");
         System.out.println("[7] QUIT");
         System.out.println();
         System.out.println("Enter a choice [1-7]: ");
         //get choice
         choice= EasyScanner.nextChar();
         System.out.println();
         //process choice
         switch(choice){
             case '1':
                 option1(list);
                 break;
             case '2':
                 option2(list);
                 break;
             case '3':
                 option3(list);
                 break;
             case '4':
                 option4(list);
                 break;
             case '5':
                 option5(list);
                 break;
             case '6':
                 option6(list);
                 break;
             case '7':
                 System.out.println("TESTING COMPLETE");
                 break;
             default:
                 System.out.println("1-7 only");
                 break;
        }
        }while(choice!='7');
    }
    
    //ADD
    static void option1(PaymentList listIn){
        //prompt for payment details
        System.out.print("Enter month: ");
        String month= EasyScanner.nextString();
        System.out.print("Enter amount: ");
        double amount= EasyScanner.nextDouble();
        //create new payment object from input
        Payment p= new Payment(month,amount);
        //attempt to add payment to list
        boolean ok=listIn.addPayment(p);//value of false sent back if unable to add
        if(!ok){//check if item was not added
            System.out.println("ERROR: List is full");
        }
    }
    
    //DISPLAY
    static void option2(PaymentList listIn){
        System.out.println("ITEMS ENTERED");
        System.out.println(listIn);//calls toString of PaymentList
    }
    
    //IS FULL
    static void option3(PaymentList listIn){
        if(listIn.isFull()){
            System.out.println("list is full");
        }
        else{
            System.out.println("list is not full");
        }
    }
    
    //GET PAYMENT
    static void option4(PaymentList listIn){
        //prompt for and receive payment number
        System.out.println("Enter payment number to retrieve: ");
        int num= EasyScanner.nextInt();
        //retrieve payment object form list
        Payment p=listIn.getPayment(num);//returns null if invalid position
        if(p!=null){//check if Payment retrieved
            System.out.println(p);//calls toString method of payment
        }
        else{
            System.out.println("INVALID PAYMENT NUMBER");//invalid position
        }
    }
    
    //GET TOTAL
    static void option5(PaymentList listIn){
        System.out.print("TOTAL NUMBER OF PAYMENTS ENTERED: ");
        System.out.println(listIn.getTotal());
    }
    
    //GET TOTAL PAID
    static void option6(PaymentList listIn){
        System.out.print("TOTAL OF PAYMENTS MADE SO FAR: ");
        System.out.println(listIn.calculateTotalPaid());
    }*/
}
