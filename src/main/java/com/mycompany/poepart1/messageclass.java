/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Student
 */
class messageclass {
    
       private final String messageID;
    private int numMessagesSent;
    private final String recipient;
    private final String messageContent;
    private String messageHash;

    // This is the constructor (the <init> method)
public messageclass(int numMessagesSent, String recipient, String messageContent) {
    
    // DELETE the UnsupportedOperationException line!
    
    // Add these 4 lines:
    this.numMessagesSent = numMessagesSent;
    this.recipient = recipient;
    this.messageContent = messageContent;
    this.messageID = generateRandomID(); // If you have this method in your class
}

    
private String generateRandomID() {
        Random rand = new Random();
        // Generates a number between 1,000,000,000 and 9,999,999,999
        long id = (long) (rand.nextDouble() * 9_000_000_000L) + 1_000_000_000L;
        return String.valueOf(id);
    }
public boolean checkMessageID() {
        // Ensures the message ID is not more than ten characters
        return this.messageID != null && this.messageID.length() >= 10;
    }
    
    public String checkRecipientCell() {
        // Ensures cell number is no more than 10 chars and starts with an international code (+)
        if (recipient.length() <= 10 && recipient.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }
     public String createMessageHash() {
        // First two numbers of the message ID
        String firstTwoID = messageID.substring(0, 2);
        
        // Split the message into words to find the first and last word
        String[] words = messageContent.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", ""); // Removes punctuation
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        
        // Format: 00:0:HITHANKS (All caps)
        this.messageHash = (firstTwoID + ":" + numMessagesSent + ":" + firstWord + lastWord).toUpperCase();
        return this.messageHash;
    }
    
     public String SentMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose an option:");
        System.out.println("1 - Send Message");
        System.out.println("2 - Disregard Message");
        System.out.println("3 - Store Message to send later");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                return "Message successfully sent";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                storeMessage(); // Calls the JSON method
                return "Message successfully stored";
            default:
                return "Invalid option chosen. Message discarded.";
        }
    }
public String printMessages() {
        // Returns details in the exact order requested: ID, Hash, Recipient, Message
        return "Message ID: " + messageID + "\n" +
               "Message Hash: " + messageHash + "\n" +
               "Recipient: " + recipient + "\n" +
               "Message: " + messageContent;
    }
    
     public int returnTotalMessagess() {
        return this.numMessagesSent;
    }
public void storeMessage() {
        // Formats the message data into a JSON string
        String jsonString = "{\n" +
                "  \"MessageID\": \"" + this.messageID + "\",\n" +
                "  \"MessageHash\": \"" + this.messageHash + "\",\n" +
                "  \"Recipient\": \"" + this.recipient + "\",\n" +
                "  \"Message\": \"" + this.messageContent + "\"\n" +
                "}\n";
        
        // Appends the JSON string to a file named messages.json
        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(jsonString);
        } catch (IOException e) {
            System.out.println("An error occurred while storing the message: " + e.getMessage());
        }
    
    
    
    
}
}

    
    
    
    
    
    
    
    

