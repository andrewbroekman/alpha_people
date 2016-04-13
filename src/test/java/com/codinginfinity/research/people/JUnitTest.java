/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import com.codinginfinity.research.people.defaultImpl.GroupImplementation;
import com.codinginfinity.research.people.defaultImpl.PersonImplementation;
import com.codinginfinity.research.people.defaultImpl.ResearcherCategoryImplementation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lethabo 
 */
public class JUnitTest {
    
    static PersonImplementation examplePersonA, examplePersonB, examplePersonC;
    static GroupImplementation exampleGroup;
    static ResearcherCategoryImplementation exampleCategory;
    public JUnitTest() {
    }
    
    @Before
    public void initialization() {
        
        
        PersonImplementation examplePerson;
        
        try {
            examplePersonA = new PersonImplementation("A", "A", "test@test.com");
            examplePersonB = new PersonImplementation("B", "B", "test@test.com");
            examplePersonC = new PersonImplementation("C", "C", "test@test.com");

        }
        
        catch(InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
