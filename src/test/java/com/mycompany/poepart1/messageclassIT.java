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
        // Clear the arrays before each test to ensure they are empty
        POEpart1.sentMessages.clear();
        POEpart1.storedMessages.clear();
        POEpart1.messageHashes.clear();
        POEpart1.messageIDs.clear();

        // Populate arrays with the Test Data from your assignment sheet
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

    // 1. Test: Sent Messages array correctly populated
    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        assertEquals("Did you get the cake?", POEpart1.sentMessages.get(0).getMessageContent());
        assertEquals("It is dinner time !", POEpart1.sentMessages.get(1).getMessageContent());
    }

    // 2. Test: Display the longest Message
    @Test
    public void testDisplayLongestMessage() {
        messageclass longest = null;
        for (messageclass msg : POEpart1.storedMessages) {
            if (longest == null || msg.getMessageContent().length() > longest.getMessageContent().length()) {
                longest = msg;
            }
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest.getMessageContent());
    }

    // 3. Test: Search for messageID
    @Test
    public void testSearchForMessageID() {
        String searchId = POEpart1.sentMessages.get(1).getMessageID(); // Gets ID for "It is dinner time!"
        boolean found = false;
        for (messageclass msg : POEpart1.sentMessages) {
            if (msg.getMessageID().equals(searchId)) {
                assertEquals("It is dinner time !", msg.getMessageContent());
                found = true;
            }
        }
        assertTrue(found);
    }

    // 4. Test: Delete a message using a message hash
    @Test
    public void testDeleteMessageByHash() {
        String hashToDelete = POEpart1.storedMessages.get(0).getMessageHash(); // Hash for Message 2
        int initialSize = POEpart1.storedMessages.size();
        
        // Delete logic
        POEpart1.storedMessages.removeIf(msg -> msg.getMessageHash().equals(hashToDelete));
        
        assertEquals(initialSize - 1, POEpart1.storedMessages.size());
    }

    // 5. Test: The exact hash test requested by your lecturer
    @Test
    public void testExactHash() {
        messageclass msg = new messageclass(0, "+27834557896", "Hi tonight");
        String hash = msg.createMessageHash();
        // Based on the format: First2ID : MessageNum : FirstWordLastWord
        assertTrue(hash.endsWith("HITONIGHT"), "Hash should end with HITONIGHT in uppercase");
    }
}