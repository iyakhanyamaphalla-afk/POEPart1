/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Student
 */
public class messageclassIT {
    
    
    @Test
    public void testMessageLengthSuccess() {
        // Data from Task 1 image
        messageclass msg = new messageclass(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message ready to send.", msg.checkMessageLength());
    }
     @Test
    public void testMessageLengthFailure() {
        String longMessage = "A".repeat(255); // 255 chars
        messageclass msg = new messageclass(1, "+27718693002", longMessage);
        assertEquals("Message exceeds 250 characters by 5; please reduce the size.", msg.checkMessageLength());
    }
    @Test
    public void testRecipientSuccess() {
        messageclass msg = new messageclass(1, "+27718693002", "Test");
        assertEquals("Cell phone number successfully captured.", msg.checkRecipientCell());
    }
    @Test
    public void testRecipientFailure() {
        messageclass msg = new messageclass(2, "08575975889", "Test");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", msg.checkRecipientCell());
    }
       @Test
    public void testMessageHash() {
        messageclass msg = new messageclass(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        // Checks if the hash is generated correctly (ignoring the random first 2 digits)
        assertTrue(msg.createMessageHash().endsWith(":1:HITONIGHT"));
    }
        @Test
    public void testMessageIDCreation() {
        messageclass msg = new messageclass(1, "+27718693002", "Test message");
        
        // Force Java to treat it as a String
        String generatedID = (String) msg.getMessageID(); 
        
        System.out.println("Message ID generated: " + generatedID);
        
        assertNotNull(generatedID);
        assertTrue(generatedID.length() <= 10);
        assertTrue(generatedID.matches("\\d+"));
    }
         @Test
    public void testSentMessageOptions() {
        // Create a test message
        messageclass msg = new messageclass(1, "+27718693002", "Test");

        // Test Option 1: Send
        assertEquals("Message successfully sent.", msg.SentMessage(1));
        
        // Test Option 2: Disregard
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
        
        // Test Option 3: Store
        assertEquals("Message successfully stored.", msg.SentMessage(3));
    }
}


