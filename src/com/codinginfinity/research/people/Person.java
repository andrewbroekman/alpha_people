/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

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
    * a basic Person.
    * @param    firstName   The name(s) of the Person
    * @param    surname     The surname of the Person
    * @param    primaryEmail The primary email address of the Person    
    */
    public Person(String firstName, String surname, EmailAddress primaryEmail)
    {
        
        categories = new ArrayList<ResearcherCategoryAssociation>();
        groups = new ArrayList<ResearchGroupAssociation>();
        
        this.firstName = firstName;
        this.surname = surname;
        this.primaryEmail = primaryEmail;
        this.user = null;
    }
    
    /**
    * Defines the interface of a constructor for a Person
    * who has a user object already defined
    * @param    firstName   The name(s) of the Person
    * @param    surname     The surname of the Person
    * @param    primaryEmail The primary email address of the Person
    * @param    user        The user object associated with the person
    */
    public Person(String firstName, String surname, EmailAddress primaryEmail, User user)
    {
        categories = new ArrayList<ResearcherCategoryAssociation>();
        groups = new ArrayList<ResearchGroupAssociation>();
        
        this.firstName = firstName;
        this.surname = surname;
        this.primaryEmail = primaryEmail;
        this.user = user;
        
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
    * Defines a function that returns the user object
    * associated with this Person
    * @return The user object associated with this person
    */ 
    public User getUser() { return this.user; }

    
    //--------------------------------------------------------------------------
    
    /**
     *
     * @param firstName
     */ 
    public void setFirstName(String firstName){ this.firstName = firstName; }
    
    /**
     *
     * @param surname
     */ 
    public void setSurname(String surname){ this.surname = surname;}; 
    
    /**
     *
     * @param primaryEmail
     */ 
    public void setPrimaryEmail(EmailAddress primaryEmail){ this.primaryEmail = primaryEmail;}; 
    
    /**
     *
     * @param user
     */ 
    public void setFirstName(User user){ this.user = user;}; 
    
    /**
     *
     * @param auxiliaryEmails
     */ 
    public void setAuxiliaryEmails(ArrayList<EmailAddress> auxiliaryEmails){ this.auxiliaryEmails = new ArrayList<EmailAddress>(auxiliaryEmails);}; 
    
    
    
    //--------------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
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
     * An object that contains this person's User
     * If it is NULL, this person is just a normal researcher
     */
    private User user;
    
    /**
     * A list of this person's research groups
     */
    private ArrayList<ResearchGroupAssociation> groups;
    
    /**
     * A list of this person's research categories
     */
    private ArrayList<ResearcherCategoryAssociation> categories;
}
