/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * This class creates examples of the various objects in the People system
 * Association objects can be made using the generated Objects
 */
public class MockCreator {
    /**
     * Generates a valid mock EmailAddress and should throw an exception if an invalid
     * one is requested
     * @param   valid   Specifies whether you would like to create an invalid or a valid email
     * @return  A valid email address object, assuming a valid email was requested
     * @throws InvalidEmailException
     */
    public EmailAddress createEmail(boolean valid) throws InvalidEmailException
    {
        if(valid)
            return new EmailAddress("test@mail.com");
        else return new EmailAddress("test^mail");
    }
    
    /**
     * Generates a valid person object, to be used for testing
     * @param   level    1 - Normal Researcher.  2 - Researcher and User. 3+ - Researcher, User and Admin
     * @return A valid person object
     * @throws InvalidEmailException 
     */
    public Person createPerson(int level) throws InvalidEmailException
    {
        switch (level) {
            case 1:
                return new Person("Testing A", "Person", createEmail(true));
            case 2:
            {
                ArrayList<Role> roles = new ArrayList<Role>();
                roles.add(Role.RESEARCHER);
                roles.add(Role.USER);
                return new Person("Testing B", "PersonB", createEmail(true), roles);
            }
            default:
            {
                ArrayList<Role> roles = new ArrayList<Role>();
                roles.add(Role.RESEARCHER);
                roles.add(Role.USER);
                roles.add(Role.ADMIN);
                return new Person("Testing C", "PersonC", createEmail(true), roles);
            }
        }
        
    }
    
    /**
     * Create a valid Group object to be used for testing.
     * @param type  1 - Empty Group. 2 - Group with some added Persons. 3 - Group with empty Groups.
     *  4+ - Group with mix of Persons and Groups with Persons.
     * @return A valid group object
     * @throws InvalidEmailException
     */
    public Group createGroup(int type) throws InvalidEmailException
    {
        ArrayList<Entity> members = new ArrayList<Entity>();
        switch (type) {
            case 1:
                return new Group("Research Group A");
            case 2:
                members.add(createPerson(1));
                members.add(createPerson(1));
                return new Group("Research Group B", members);
            case 3:                
                members.add(createGroup(1));
                members.add(createGroup(1));
                members.add(createGroup(1));
                return new Group("Research Group C", members);
            default:
                members.add(createGroup(2));
                members.add(createGroup(2));
                members.add(createPerson(1));
                members.add(createGroup(2));
                return new Group("Research Group D", members);
        }
    }
    
    /**
     * Creates an exemplar Researcher Category for testing use
     * All use states with effectiveDate being now and output target being 3
     * @param   valid   if set to false, will give invalid date
     * @return A researcher category exemplar object for testing
     * @throws DateInvalidException Throws if the specified date is in the future, when
     * this kind of association must begin in the past
     */
    public ResearcherCategory createResearchCategory(boolean valid)
            throws DateInvalidException
    {
        Date currentDate = new Date();
        if(valid)
            return new ResearcherCategory(new ResearchCategoryState(currentDate, 3));
        else
        {
            currentDate.setDate(currentDate.getDate()+5000);
            return new ResearcherCategory(new ResearchCategoryState(currentDate, 3));
        }
    }
}
