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
        
        // Setup: Create a user with a valid username
        login user = new login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        
        // Action & Assertion: Check if the method returns true
        assertTrue(user.CheckUserName(), "CheckUserName() should return TRUE for 'kyl_1'");
    }
        
    }




