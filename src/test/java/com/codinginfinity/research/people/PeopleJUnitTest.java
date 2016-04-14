/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import com.codinginfinity.research.people.DateInvalidException;
import com.codinginfinity.research.people.GroupSuspendedException;
import com.codinginfinity.research.people.defaultImpl.GroupImplementation;
import com.codinginfinity.research.people.defaultImpl.PersonImplementation;
import com.codinginfinity.research.people.defaultImpl.ResearcherCategoryImplementation;
import com.codinginfinity.research.people.InvalidEmailException;
import com.codinginfinity.research.people.InvalidEmailException;
import com.codinginfinity.research.people.defaultImpl.ResearchGroupAssociationImplementation;
import java.util.Date;

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
public class PeopleJUnitTest {
    
    static PersonImplementation examplePersonA, examplePersonB, examplePersonC;
    static GroupImplementation exampleGroup;
    static ResearcherCategoryImplementation exampleCategory;
    public PeopleJUnitTest() {
    }
    
    
    @Before
    public void initialization() throws InvalidEmailException, com.codinginfinity.research.people.InvalidEmailException {
        
        examplePersonA = new PersonImplementation("A", "A", "test@test.com",false);
        examplePersonB = new PersonImplementation("B", "B", "test@test.com",false);
        examplePersonC = new PersonImplementation("C", "C", "test@test.com",false);
    }
    
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = InvalidEmailException.class)
    public void test_Email() throws InvalidEmailException, com.codinginfinity.research.people.InvalidEmailException {
        
        new PersonImplementation("D", "D", "test@test",false);
    
    }

    GroupImplementation t = new GroupImplementation("one");
    
   @Test
   public void test_getGroupState() {
       
       assertEquals(t.getGroupState(), true); 
   }
   
   @Test
   public void test_suspendGroup() {
       
       t.suspendGroup();
       assertEquals(t.getGroupState(), false);
   }
   
   @Test
   public void test_activateGroup() {
       
       t.activateGroup();
       assertEquals(t.getGroupState(), true);
   }
   
  
   @Test(expected = GroupSuspendedException.class)
    public void test_groupException() throws GroupSuspendedException , com.codinginfinity.research.people.GroupSuspendedException{
       
       t.addMember(examplePersonA); 
       t.suspendGroup();
       t.addMember(examplePersonB);
  }
    
    @Test
    public void test_isMemebr(){
        
        assertEquals(t.isMember(examplePersonB), false);  
    }
   
   private GroupImplementation test; 
   private Date day; 
}
