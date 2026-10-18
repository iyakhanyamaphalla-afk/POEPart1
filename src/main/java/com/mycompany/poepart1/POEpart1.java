/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Student
 */
public class POEpart1 {

    public static void main(String[] args) {
       Scanner input= new Scanner(System.in);
     
              System.out.println("====================");
              System.out.println("   CHAT APP REGISTRATION    ");
              System.out.println("=====================");
       
        System.out.println("Enter your Firstname: ");
        String Firstname=input.nextLine();
        
        System.out.println("Enter your Lastname: ");
        String Lastname=input.nextLine();
       System.out.print("Enter your username: ");
String enteredUsername = input.nextLine();

System.out.print("Enter your password: ");
String enteredpassword = input.nextLine();
        System.out.println("Enter your South African cellphone number: ");
        String cellphoneNumber=input.next();
       
       
        login user = new login(Firstname, Lastname,enteredUsername, enteredpassword, cellphoneNumber); 
        
        System.out.println("\n=========REGISTRATION==========");
        
        String registrationMessege= user.registerUser();
        System.out.println(registrationMessege);
        
        if(true){
        
            System.out.println("\n======LOGIN=======");
            
            
            
       user.LoginUser(enteredUsername, enteredpassword);
System.out.println(user.returnLoginStatus(true));
           
       
                       // ==========================================
            // PART 2 CODE STARTS HERE
            // ==========================================
            
            System.out.println("\nWelcome to QuickChat.");
            
            // 5. DEFINE MESSAGE LIMIT
            System.out.print("How many messages do you wish to enter? ");
            int maxMessages = input.nextInt();
            input.nextLine(); // Consume newline

            // Array to store sent messages
            java.util.ArrayList<messageclass> sentMessagesList = new java.util.ArrayList<>();
            int totalSentCount = 0; 
            boolean running = true;

            // 4. APPLICATION LOOP
            while (running) {
                
                // 3. NUMERIC MENU
                System.out.println("\n--- Main Menu ---");
                System.out.println("Option 1) Send Messages");
                System.out.println("Option 2) Show recently sent messages");
                System.out.println("Option 3) Quit");
                System.out.print("Select an option: ");
                
                int menuChoice = input.nextInt();
                input.nextLine(); // Consume newline

                switch (menuChoice) {
                    case 1:
                        // FOR LOOP to handle the specific number of messages
                        for (int i = 0; i < maxMessages; i++) {
                            
                            if (totalSentCount >= maxMessages) {
                                System.out.println("\nYou have reached your limit of " + maxMessages + " messages.");
                                break; 
                            }

                            System.out.println("\n--- Sending Message " + (totalSentCount + 1) + " of " + maxMessages + " ---");
                            
                            // --- RECIPIENT VALIDATION ---
                            String recipient = "";
                            boolean validRecipient = false;
                            while (!validRecipient) {
                                System.out.print("Enter recipient cell number (must start with '+' and be <= 10 chars): ");
                                recipient = input.nextLine();
                                
                                messageclass tempMessage = new messageclass(totalSentCount + 1, recipient, "");
                                String recipientCheck = tempMessage.checkRecipientCell();
                                
                                if (recipientCheck.equals("Cell phone number successfully captured.")) {
                                    validRecipient = true;
                                } else {
                                    System.out.println(recipientCheck);
                                }
                            }

                            // --- MESSAGE VALIDATION ---
                            String messageText = "";
                            boolean validMessage = false;
                            while (!validMessage) {
                                System.out.print("Enter your message (max 250 characters): ");
                                messageText = input.nextLine();

                                if (messageText.length() > 250) {
                                    System.out.println("Please enter a message of less than 250 characters.");
                                } else {
                                    validMessage = true;
                                    System.out.println("Message sent");
                                }
                            }

                            // --- CREATE AND PROCESS MESSAGE ---
                            messageclass newMessage = new messageclass(totalSentCount + 1, recipient, messageText);
                            newMessage.createMessageHash(); 

                            String actionResult = newMessage.SentMessage();
                            System.out.println(actionResult);

                            if (actionResult.equals("Message successfully sent")) {
                                sentMessagesList.add(newMessage);
                                totalSentCount++;
                                
                                // 7. DISPLAY MESSAGE DETAILS ON SCREEN
                                System.out.println("\n--- Message Details ---");
                                System.out.println(newMessage.printMessages());
                            } 
                            else if (actionResult.equals("Press 0 to delete the message")) {
                                System.out.print("Enter 0 to confirm deletion: ");
                                int deleteConfirm = input.nextInt();
                                input.nextLine(); 
                                if (deleteConfirm == 0) {
                                    System.out.println("Message deleted.");
                                }
                            }
                        } // End of FOR loop
                         
        // ADD THIS CHECK:
        if (totalSentCount >= maxMessages) {
            System.out.println("\nYou have reached your limit. Exiting QuickChat...");
            running = false; // <--- THIS STOPS THE MAIN MENU FROM REPEATING
        }
        
        break;
                       
                    case 2:
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        running = false;
                        System.out.println("Exiting QuickChat...");
                        break;

                    default:
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }
            }

            // 6. TOTAL MESSAGES ACCUMULATED
            System.out.println("\n--- Final Summary ---");
            System.out.println("Total number of messages successfully sent: " + totalSentCount);

            // ==========================================
            // END OF PART 2 CODE
            // ==========================================
        
        
        }
        
        
        
        
        
    }
}
