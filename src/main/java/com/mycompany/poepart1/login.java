/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author Student
 */
public class login {
    
    private String Firstname;
    private String Lastname;
    private String Username;
    private String password;
    private String cellphoneNumber;
    private boolean IsLoggedIN;
    public login(String Firstname, String Lastname, 
            String Username, String password, String cellphoneNumber){
    
    this.Firstname=Firstname;
    this.Lastname=Lastname;
    this.Username=Username;
    this.password=password;
    this.cellphoneNumber=cellphoneNumber;
    
    }

    login() {
        
    }
    
    public boolean CheckUserName(){
    
    return Username.contains("_")
            &&Username.length()<= 5;
    
    }
     public boolean CheckPasswordComplexity() {
         
         if(password==null || password.length()<=8){
         
         return false;
         }
         boolean hasCapitalLetter=false;
         boolean hasNumber=false;
         boolean hasSpecialCharacter=false;
         
         for (int i=0; i<password.length(); i++){
         char ch=password.charAt(i);
         
         
         if(Character.isUpperCase(ch)){
         
         hasCapitalLetter=true;
         
         }else if(Character.isDigit(ch)){
         
         hasNumber=true;
         
         }else if(!Character.isLetterOrDigit(ch)){
         hasSpecialCharacter=true;
         
         }
      
         }
         return hasCapitalLetter && hasNumber && hasSpecialCharacter; 
        
     }
    public boolean CheckCellPhoneNumber(String cellPhoneNumber) {
    // This Regex checks for: 
    // 1. Starts with a '+' 
    // 2. Followed by 1 to 3 digits for the country code (e.g., 27)
    // 3. Followed by 9 to 10 digits for the actual number
    // Example of a valid number: +27838968976
    return cellPhoneNumber != null && cellPhoneNumber.matches("^\\+[0-9]{1,3}[0-9]{9,10}$");
}
    public String registerUser(){
    
    if(!CheckUserName()){
    
    return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length";
    }
    
    if(!CheckPasswordComplexity()){
        
        return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }
    
    if(!CheckCellPhoneNumber(cellphoneNumber)){
    
    return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
    
    this.Firstname=Firstname;
    this.Lastname= Lastname;
    this.Username= Username;
    this.cellphoneNumber= cellphoneNumber;
    this.password= password;
    
    return  "Password successfully captured";
    
   
    }
    public boolean LoginUser(String enteredUsername, String enteredPassword) {
    return enteredUsername.equals(this.Username) && enteredPassword.equals(this.password);
}
    public String returnLoginStatus(boolean IsLoggedIN){
    
    if(IsLoggedIN){
    return "welcome " + this.Firstname + "  " + this.Lastname + " It is great to see you again. ";
   
    }else{
    
    return "useranme or password is incorrect,please try again";
    
    }
    
   
    
    }
    
    }
    

