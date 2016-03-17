/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import com.codinginfinity.people.ResearchGroupAssociationType;
import java.util.Date;

/**
 * A file filled with basic test functions to ensure basic functionality of the 
 * People system
 * @author Renton Mcintyre (u14312710)
 */
public class BasicPeopleTests {
    /**
     * MockCreator object to perform tests using
     */
    static com.codinginfinity.people.MockCreator mocker;
       
    /**
     * To be used to test associations
     */
    static com.codinginfinity.people.Person examplePersonA, examplePersonB, examplePersonC;
    static com.codinginfinity.people.Group exampleGroup;
    static com.codinginfinity.people.ResearcherCategory exampleCategory;
            
    
    public static void main(String args[]) {
        System.out.println("*****************************\n\n"
                         + "*******COMMENCING TESTS******\n\n"
                         + "*****************************\n\n");
         mocker = new com.codinginfinity.people.MockCreator();
        try
        {
            examplePersonA = mocker.createPerson(1);
            examplePersonB = mocker.createPerson(2);
            examplePersonC = mocker.createPerson(3);
            exampleGroup = mocker.createGroup(3);
            exampleCategory = mocker.createResearchCategory(true);
        } catch (Exception e)
        {
            System.out.println("Unexpected exception: "+e+"\n");
        }
        createEmails();
        createPeople();
        createGroups();
        createCategories();
        associatePersonWithGroup();
        associatePersonWithCategory();
    }
    

    /**
     * Tests creation of email addresses, should succeed on one attempt
     * should throw on another
     */
    private static void createEmails()
    {     
        com.codinginfinity.people.EmailAddress emailA;
        try
        {
            emailA = mocker.createEmail(true);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating emailA with valid==true");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            emailA = mocker.createEmail(false);
        } catch(Exception e)
        {
            System.out.println("Expected problem reached, successful throw on invalid email attempt");
             System.out.println("Message: "+ e+"\n");
        }
    }
    
    /**
     * Tests creation of Persons, should succeed on all attempts
     */
    private static void createPeople()
    {
        com.codinginfinity.people.Person personA, personB, personC;
        try
        {
            personA = mocker.createPerson(1);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating person A");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            personA = mocker.createPerson(2);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating person B");
             System.out.println("Message: "+ e+"\n");
        }
                
        try
        {
            personA = mocker.createPerson(3);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating person C");
             System.out.println("Message: "+ e+"\n");
        }
        
    }
    
    /**
     * Tests creation of groups, should succeed on all attempts
     */   
    private static void createGroups()
    {
        com.codinginfinity.people.Group groupA, groupB, groupC, groupD;
        try
        {
            groupA = mocker.createGroup(1);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating group A");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            groupA = mocker.createGroup(2);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating group B");
             System.out.println("Message: "+ e+"\n");
        }
                
        try
        {
            groupA = mocker.createGroup(3);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating group C");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            groupA = mocker.createGroup(4);
        } catch(Exception e)
        {
            System.out.println("There should be problem creating group D");
             System.out.println("Message: "+ e+"\n");
        }
        
    }
    
    /**
     * Tests creation of Research Categories, should succeed on one attempt
     * should throw on another
     */
    private static void createCategories()
    {
        com.codinginfinity.people.ResearcherCategory categoryA;
        try
        {
            categoryA = mocker.createResearchCategory(true);
        } catch(Exception e)
        {
            System.out.println("There should be no problem creating categoryA with valid==true");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            categoryA = mocker.createResearchCategory(false);
        } catch(Exception e)
        {
            System.out.println("Expected problem reached, successful throw on invalid research category attempt");
             System.out.println("Message: "+ e+"\n");
        }
    }
    
    /**
     * Tests associations with groups. Always uses type STUDENT, as type should cause no issues
     * Expects multiple failures and few successes
     */
    private static void associatePersonWithGroup() {
        Date currentDate = new Date();
        Date futureDate = new Date();
        futureDate.setDate(futureDate.getDate()+5000);
        try
        {
            examplePersonA.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT);
        }catch(Exception e)
        {
            System.out.println("There should be no problem creating association between PersonA and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            examplePersonB.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT, futureDate);
        }catch(Exception e)
        {
            System.out.println("Expected issue located when using invalid date to associate PersonB and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            examplePersonB.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT, currentDate);
        }catch(Exception e)
        {
            System.out.println("There should be no problem creating association between PersonB and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
        
        try
        {
            examplePersonC.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT, futureDate, futureDate);
        }catch(Exception e)
        {
            System.out.println("Expected issue located when using invalid date to associate PersonC and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            examplePersonC.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT, futureDate, currentDate);
        }catch(Exception e)
        {
            System.out.println("Expected issue located when using invalid date to associate PersonC and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            examplePersonC.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT, currentDate, futureDate);
        }catch(Exception e)
        {
            System.out.println("Expected issue located when using invalid date to associate PersonC and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            examplePersonC.addGroup(exampleGroup, ResearchGroupAssociationType.STUDENT, currentDate, currentDate);
        }catch(Exception e)
        {
            System.out.println("There should be no problem creating association between PersonC and GroupA");
             System.out.println("Message: "+ e+"\n");
        }
        
    }
    
    /**
     * Tests associations with groups. Always uses type STUDENT, as type should cause no issues
     * Expects multiple failures and few successes
     */
    private static void associatePersonWithCategory() {
        Date currentDate = new Date();
        Date futureDate = new Date();
        futureDate.setDate(futureDate.getDate()+5000);
        
        try
        {
            examplePersonA.addCategory(exampleCategory);
        }catch(Exception e)
        {
            System.out.println("There should be no problem creating association between PersonA and CategoryA");
             System.out.println("Message: "+ e+"\n");
        }
        
        
        try
        {
            examplePersonB.addCategory(exampleCategory, futureDate);
        }catch(Exception e)
        {
            System.out.println("Expected issue located when using invalid date to associate PersonB and CategoryA");
             System.out.println("Message: "+ e+"\n");
        }
        
        try
        {
            examplePersonB.addCategory(exampleCategory, currentDate);
        }catch(Exception e)
        {
            System.out.println("There should be no problem creating association between PersonB and CategoryA");
             System.out.println("Message: "+ e+"\n");
        }
    }
}
