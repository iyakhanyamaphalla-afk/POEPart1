/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class messageclassIT {

    @BeforeEach
    public void setUp() {
        // 1. Clear arrays to prevent test pollution
        POEpart1.sentMessages.clear();
        POEpart1.storedMessages.clear();
        POEpart1.disregardedMessages.clear();
        POEpart1.messageHashes.clear();
        POEpart1.messageIDs.clear();

        // 2. Populate with Test Data from the assignment sheet
        messageclass m1 = new messageclass(1, "+27834557896", "Did you get the cake?");
        m1.createMessageHash();
        POEpart1.sentMessages.add(m1);
        POEpart1.messageHashes.add(m1.getMessageHash());
        POEpart1.messageIDs.add(m1.getMessageID());

        messageclass m2 = new messageclass(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.");
        m2.createMessageHash();
        POEpart1.storedMessages.add(m2);
        POEpart1.messageHashes.add(m2.getMessageHash());
        POEpart1.messageIDs.add(m2.getMessageID());

        messageclass m4 = new messageclass(4, "0838884567", "It is dinner time !");
        m4.createMessageHash();
        POEpart1.sentMessages.add(m4);
        POEpart1.messageHashes.add(m4.getMessageHash());
        POEpart1.messageIDs.add(m4.getMessageID());

        messageclass m5 = new messageclass(5, "+27838884567", "Ok, I am leaving without you.");
        m5.createMessageHash();
        POEpart1.storedMessages.add(m5);
        POEpart1.messageHashes.add(m5.getMessageHash());
        POEpart1.messageIDs.add(m5.getMessageID());
    }

    // ==========================================
    // PART 2 TESTS (From the Feedback)
    // ==========================================
    
    @Test
    public void testCheckMessageID() {
        messageclass msg = new messageclass(1, "+27834557896", "Test");
        // Verifies the ID is <= 10 characer the feedbackters as p
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testExactHash() {
       
        messageclass msg = new messageclass(0, "+27834557896", "Hi tonight");
        String hash = msg.createMessageHash();
        assertTrue(hash.endsWith("HITONIGHT"), "Hash should end with HITONIGHT");
    }

    @Test
    public void testCheckRecipientCell() {
        messageclass validMsg = new messageclass(1, "+27834557896", "Test");
        assertEquals("Cell phone number successfully captured.", validMsg.checkRecipientCell());

        messageclass invalidMsg = new messageclass(2, "0838884567", "Test"); // Missing +
        assertNotEquals("Cell phone number successfully captured.", invalidMsg.checkRecipientCell());
    }

    // ==========================================
    // PART 3 TESTS (From the Assignment Sheet)
    // ==========================================

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        // Test: Sent Messages array correctly populated (Message 1 and 4)
        assertEquals("Did you get the cake?", POEpart1.sentMessages.get(0).getMessageContent());
        assertEquals("It is dinner time !", POEpart1.sentMessages.get(1).getMessageContent());
    }

    @Test
    public void testDisplayLongestMessage() {
        // Test: Display the longest Message (Message 2)
        messageclass longest = null;
        for (messageclass msg : POEpart1.storedMessages) {
            if (longest == null || msg.getMessageContent().length() > longest.getMessageContent().length()) {
                longest = msg;
            }
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest.getMessageContent());
    }

    @Test
    public void testSearchForMessageID() {
        // Test: Search for messageID (Message 4)
        String searchId = POEpart1.sentMessages.get(1).getMessageID();
        boolean found = false;
        for (messageclass msg : POEpart1.sentMessages) {
            if (msg.getMessageID().equals(searchId)) {
                assertEquals("It is dinner time !", msg.getMessageContent());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testDeleteMessageByHash() {
        // Test: Delete a message using a message hash (Test Message 2)
        String hashToDelete = POEpart1.storedMessages.get(0).getMessageHash();
        int initialSize = POEpart1.storedMessages.size();
        
     
        POEpart1.storedMessages.removeIf(msg -> msg.getMessageHash().equals(hashToDelete));
        
        assertEquals(initialSize - 1, POEpart1.storedMessages.size());
    }
    
    @Test
    public void testSearchByRecipient() {
        // Test: Search all messages stored for a particular recipient (+27838884567)
        String targetRecipient = "+27838884567";
        int count = 0;
        for (messageclass msg : POEpart1.storedMessages) {
            if (msg.getRecipient().equals(targetRecipient)) {
                count++;
            }
        }
        // Should find Message 2 and Message 5
        assertEquals(2, count, "Should find 2 messages for this recipient");
    }
}