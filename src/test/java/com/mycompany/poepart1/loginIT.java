/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepart1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 /*
 * @author Student
 */

public class loginIT {
  
@Test
    public void testUsernameCorrectlyFormatted() {
        
        //  Create a user with a valid username
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        // Action & Assertion: Check if the method returns true
        assertTrue(user.CheckUserName(), "CheckUserName() should return TRUE for 'kyl_1'");
    }
       @Test
    public void testUsernameIncorrectlyFormatted_AssertFalse() {
        // 1. Setup the test data (Invalid username: no underscore, too long)
        login user = new login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");

        // 2. Call the method that validates the username
        // This method returns 'true' if valid, and 'false' if invalid
        boolean isUsernameValid = user.CheckUserName();

        // 3. Assert that the result is FALSE (because the username is invalid)
        assertFalse(isUsernameValid, "CheckUserName() should return FALSE for 'kyle!!!!!!!' because it has no underscore and is too long.");
    }
    
    
    
   
}
    
    
    
    
    
    
    




