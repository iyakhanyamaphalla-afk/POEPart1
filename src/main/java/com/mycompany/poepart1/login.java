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
    private boolean LastLOgInSuccessful;
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
         
         if(password==null || password.length()<8){
         
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
    public boolean CheckCellPhoneNumber(String cellphoneNumber){
    return cellphoneNumber.matches("^\\+27[0-9]{9}^");
    }
    public String registerUser(){
    
    if(!CheckUserName()){
    
    return "Username is not correctly formatted,please ensure that your username contains an underscore and is no more than 5 characters in length";
    }
    if(!CheckPasswordComplexity()){
    
    return"Password is not correctly formated,please ensure that the password contains atleast 8 characters,a capital letter,a number and a special character.";
    }
    if(!CheckCellPhoneNumber(cellphoneNumber)){
    
    return "cellphone number is incorrectly formated or does not contain an international code,please correct the number and try again";
    }
    this.Firstname=Firstname;
    this.Lastname= Lastname;
    this.Username= Username;
    this.cellphoneNumber= cellphoneNumber;
    this.password= password;
    
    
    return "cellphone number successfully captured";
    }
    public boolean LoginUser(String enteredUsername, String enteredpassword){
    if(enteredUsername==null || enteredpassword==null){
    return false;
    }
   return enteredUsername.equals(this.Username)&& enteredpassword.equals(this.password);
   
    }
    public String returnLoginStatus(boolean isLoggedIn){
    
    if( LastLOgInSuccessful){
    return"welcome" +this.Firstname + "," +this.Lastname+"It is great to see you again.";
   
    }else{
    
    return "useranme or password is incorrect,please try again";
    
    }
    
   
    
    }
    
    }
    

