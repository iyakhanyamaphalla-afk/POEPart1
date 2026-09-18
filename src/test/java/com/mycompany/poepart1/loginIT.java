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
        //  Setup the test data (Invalid username: no underscore, too long)
        login user = new login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");

        // Calling the method that validates the username
        // This method returns 'true' if valid, and 'false' if invalid
        boolean isUsernameValid = user.CheckUserName();

        //Assert that the result is FALSE (because the username is invalid)
        assertFalse(isUsernameValid, "CheckUserName() should return FALSE for 'kyle!!!!!!!' because it has no underscore and is too long.");
    }
     @Test  
    public void testPasswordMeetsComplexity_AssertEquals() {
        // 1. Setup the test data (Valid username, Valid Password)
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // 2. Define the exact expected response from the rubric
        String expectedResponse = "Password successfully captured.";

        // 3. Call the method in your code to get the actual response
        String actualResponse = user.registerUser();

        // 4. Compare the expected response with the actual response
        assertEquals(expectedResponse, actualResponse, "System should return the password success message.");
    }
           @Test
    public void testPasswordDoesNotMeetComplexity_AssertEquals() {
        //  Setup the test data (Valid username, INVALID Password)
        // The password "password" is invalid because it lacks a capital letter, number, and special character.
        login user = new login("Kyle", "Smith", "kyl_1", "password", "+27838968976");

        //  Defining the exact expected response from the rubric
        String expectedResponse = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        // Calling the method in the code to get the actual response
        String actualResponse = user.registerUser();

        // Comparing the expected response with the actual response
        assertEquals(expectedResponse, actualResponse, "System should return the password error message.");
    } 
         
    
    
    
    
}
    
    
    
    
    
    
    




