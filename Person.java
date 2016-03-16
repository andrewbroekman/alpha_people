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
 * Person type, an entity defined as being a record of a human being
 */
public class Person implements Entity {
    /**
    *  Defines the no-args constructor for a Person
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected Person() {}
    
    /**
    * Defines the interface of the standard constructor for
    * a basic Person. Adds the Role "RESEARCHER" to Person,
    * as this is always the default
    * @param    firstName   The name(s) of the Person
    * @param    surname     The surname of the Person
    * @param    primaryEmail The primary email address of the Person    
    */
    public Person(String firstName, String surname, EmailAddress primaryEmail)
    {
        
        roles = new ArrayList<Role>();
        categories = new ArrayList<ResearcherCategoryAssociation>();
        groups = new ArrayList<ResearchGroupAssociation>();
        
        this.firstName = firstName;
        this.surname = surname;
        this.primaryEmail = primaryEmail;
        this.roles.add(Role.RESEARCHER);
    }
    
    /**
    * Defines the interface of a constructor for a Person
    * whose roles are already defined
    * @param    firstName   The name(s) of the Person
    * @param    surname     The surname of the Person
    * @param    primaryEmail The primary email address of the Person
    * @param    roles       The predefined roles of the Person
    */
    public Person(String firstName, String surname, EmailAddress primaryEmail, ArrayList<Role> roles)
    {
        roles = new ArrayList<Role>();
        categories = new ArrayList<ResearcherCategoryAssociation>();
        groups = new ArrayList<ResearchGroupAssociation>();
        
        this.firstName = firstName;
        this.surname = surname;
        this.primaryEmail = primaryEmail;
        this.roles = roles;
    }
    
    public void addGroup(Group group, ResearchGroupAssociationType type)
    {
        groups.add(new ResearchGroupAssociation(group, type));
    }
    
    public void addGroup(Group group, ResearchGroupAssociationType type, Date startDate)
            throws DateInvalidException
    {
        groups.add(new ResearchGroupAssociation(group, type, startDate));
    }
    
    public void addGroup(Group group, ResearchGroupAssociationType type, Date startDate, Date endDate)
            throws DateInvalidException
    {
        groups.add(new ResearchGroupAssociation(group, type, startDate, endDate));
    }
    
    public void addCategory(ResearcherCategory category)
    {
        categories.add(new ResearcherCategoryAssociation(category));
    }
    
    public void addCategory(ResearcherCategory category, Date effectiveDate)
            throws DateInvalidException
    {
        categories.add(new ResearcherCategoryAssociation(category, effectiveDate));
    }
    
    /**
    * Defines a function that returns the firstName of the Person
    * @return The first name(s) of the Person
    */
    public String getFirstName() { return this.firstName; }
    
    /**
    * Defines a function that returns the surname of the Person
    * @return The surname of the Person
    */
    public String getSurmame() { return this.surname; }
    
    /**
    * Defines a function that returns the primary email address of the Person
    * @return The primary email address of the Person
    */
    public EmailAddress getPrimaryEmail() { return this.primaryEmail; }
    
    /**
    * Defines a function that returns the list of auxiliary email addresses of the Person
    * @return The primary email address of the Person
    */
    public ArrayList<EmailAddress> getAuxiliaryEmails() { return this.auxiliaryEmails; }

    
    /**
    * Defines a function that returns the list of roles
    * associated with this Person
    * @return The list of roles this person has
    */ 
    public ArrayList<Role> getRoles() { return this.roles; }
    
    
    /*
    *   Member variables
    */
    /**
     * The person's first name(s)
     */
    private String firstName;
    /**
     * The person's surname
     */
    private String surname;
    
    /**
     * The person's primary email address 
     */
    private EmailAddress primaryEmail;
    
    /**
     * A list of secondary email addresses, 
     * to be added only after person's creation
     */
    private ArrayList<EmailAddress> auxiliaryEmails;
    
    /**
     * A list of this person's roles in the system 
     * Currently can be: RESEARCHER, ADMIN and USER
     * More can be added later. A Person may have multiple roles.
     * Eg: Any USER is also a RESEARCHER
     */
    private ArrayList<Role> roles;
    
    /**
     * A list of this person's research groups
     */
    private ArrayList<ResearchGroupAssociation> groups;
    
    /**
     * A list of this person's research categories
     */
    private ArrayList<ResearcherCategoryAssociation> categories;
}
