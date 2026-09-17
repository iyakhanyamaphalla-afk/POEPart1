/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class POEpart1 {

    public static void main(String[] args) {
       Scanner input= new Scanner(System.in);
       login Login = new login();
        
              System.out.println("====================");
              System.out.println("   CHAT APP REGISTRATION    ");
              System.out.println("=====================");
       
        System.out.println("Enter your Firstname: ");
        String Firstname=input.nextLine();
        
        System.out.println("Enter your Lastname: ");
        String Lastname=input.nextLine();
        
        System.out.println("Enter your Username: ");
        String Username=input.nextLine();
        
        System.out.println("Enter your password: ");
        String password=input.nextLine();
        
        System.out.println("Enter your South African cellphone number: ");
        String cellphoneNumber=input.next();
       
       
        login user = new login(Firstname, Lastname, Username, password,
                cellphoneNumber); 
        
        System.out.println("\n=========REGISTRATION==========");
        
        String registrationMessege= user.registerUser();
        System.out.println(registrationMessege);
        
        if(registrationMessege.equals("Registration Successful.")){
        
            System.out.println("\n======LOGIN=======");
            System.out.println("Enter your username");
            String enteredUsername=input.nextLine();
            
            System.out.println("Enter your password");
        String enteredpassword=input.nextLine();
        Login.LoginUser(enteredUsername, enteredpassword);
           System.out.println(Login.returnLoginStatus(true));
           
       
           
        
        
        }
        
        
        
        
        
    }
}
