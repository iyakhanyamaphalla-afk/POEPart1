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
public void testPasswordMeetsComplexity() {
    // 1. Setup the test data
    // (Assuming your class is named "Login" with a capital L. Java classes should always start with a capital letter!)
    login LoginObject = new login("Kyle", "Smith", "kyl_1", "+27838968976", "Ch&sec@ke99!");

    // 2. Define the exact expected response
    // Make sure this matches your main code EXACTLY (watch the period!)
    String expectedResponse = "Password successfully captured"; 

    // 3. Call the method (Make sure you use the right object name here!)
    String actualResponse = LoginObject.registerUser();

    // 4. Compare
    assertEquals(expectedResponse, actualResponse, "System should return the password success message.");
}
           @Test
    public void testPasswordDoesNotMeetComplexity() {
        //  Setup the test data (Valid username, INVALID Password)
        // The password "password" is invalid because it lacks a capital letter, number, and special character.
        login user = new login("Kyle", "Smith", "kyl_1", "password", "+27838968976");

        //  Defining the exact expected response from the rubric
        String expectedResponse = "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";

        // Calling the method in the code to get the actual response
        String actualResponse = user.registerUser();

        assertEquals(expectedResponse, actualResponse, "System should return the password error message.");
    } 
         
        @Test
    public void testCellPhoneValid() {
        // Test Data: Valid inputs for everything
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // Based on your current login.java, registerUser() returns this when all checks pass
        String expectedResponse = "Password successfully captured.";
        
        String actualResponse = user.registerUser();
        assertEquals(expectedResponse, actualResponse, "System should return success message.");
    }
        @Test
    public void testCellPhoneInvalid() {
        // Test Data: Invalid cellphone "08966553" (Missing +27 and too short)
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");

        String expectedResponse = "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        
        String actualResponse = user.registerUser();
        assertEquals(expectedResponse, actualResponse, "System should return cellphone error message.");
    }
        @Test
    public void LoginSuccessful() {
        // Setup a user with known credentials
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // Verify that logging in with correct details returns true
        assertTrue(user.LoginUser("kyl_1", "Ch&&sec@ke99!"), "Login should return True for correct credentials.");
    }
        @Test
    public void LoginFailed() {
        // Setup a user with known credentials
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");

        // Verify that logging in with a wrong password returns false
        assertFalse(user.LoginUser("kyl_1", "WrongPassword!"), "Login should return False for incorrect credentials.");
    }
    
    
    
    
    
    
    
}
    
    
    
    
    
    
    




