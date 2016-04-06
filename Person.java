package com.codinginfinity.research.people;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Person type, an entity defined as being a record of a human being
 */
@javax.persistence.Entity
public class Person implements Entity,PersonInterface {
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
    * @throws   InvalidEmailException Throws when given an invalid email format
    */
    public Person(String firstName, String surname, String primaryEmail) throws InvalidEmailException
    {
        
        this.categoryAssociations = new ArrayList<ResearcherCategoryAssociation>();
        this.groupAssociations = new ArrayList<ResearchGroupAssociation>();
        this.auxiliaryEmails = new ArrayList<String>();
        
        this.firstName = firstName;
        this.surname = surname;

        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new InvalidEmailException(primaryEmail + " is not a valid email address.");

        this.primaryEmail = primaryEmail;
        this.userID = null;
    }
    
    /**
    * Defines the interface of a constructor for a Person
    * who has a user object already defined
    * @param    firstName   The name(s) of the Person
    * @param    surname     The surname of the Person
    * @param    primaryEmail The primary email address of the Person
    * @param    userID        The id of the user object associated with the person
    * @throws   InvalidEmailException Throws if the given email does not match standard email format
    */
    public Person(String firstName, String surname, String primaryEmail, BigInteger userID) throws InvalidEmailException
    {
        this.categoryAssociations = new ArrayList<ResearcherCategoryAssociation>();
        this.groupAssociations = new ArrayList<ResearchGroupAssociation>();
        this.auxiliaryEmails = new ArrayList<String>();

        this.firstName = firstName;
        this.surname = surname;

        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new InvalidEmailException(primaryEmail + " is not a valid email address.");

        this.primaryEmail = primaryEmail;
        this.userID = userID;
        
    }
    
    public void addGroup(Group group, ResearchGroupAssociationType type)
    {
        groupAssociations.add(new ResearchGroupAssociation(group, type));
    }
    
    /**
     *
     * @param group
     * @param type
     * @param startDate
     * @throws DateInvalidException
     */
    @Override
    public void addGroup(Group group, ResearchGroupAssociationType type, Date startDate)
            throws DateInvalidException
    {
        groupAssociations.add(new ResearchGroupAssociation(group, type, startDate));
    }
    
    /**
     *
     * @param group
     * @param type
     * @param startDate
     * @param endDate
     * @throws DateInvalidException
     */
    @Override
    public void addGroup(Group group, ResearchGroupAssociationType type, Date startDate, Date endDate)
            throws DateInvalidException
    {
        groupAssociations.add(new ResearchGroupAssociation(group, type, startDate, endDate));
    }
    
    public void addCategory(ResearcherCategory category)
    {
        categoryAssociations.add(new ResearcherCategoryAssociation(category));
    }
    
    public void addCategory(ResearcherCategory category, Date effectiveDate)
            throws DateInvalidException
    {
        categoryAssociations.add(new ResearcherCategoryAssociation(category, effectiveDate));
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
    public String getPrimaryEmail() { return this.primaryEmail; }
    
    /**
    * Defines a function that returns the list of auxiliary email addresses of the Person
    * @return The primary email address of the Person
    */
  //  public ArrayList<EmailAddress> getAuxiliaryEmails() { return this.auxiliaryEmails; }
    
    /**
    * Defines a function that returns the user object
    * associated with this Person
    * @return The user object associated with this person
    */ 
    public BigInteger getUserID() { return this.userID; }

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
     * @throws InvalidEmailException
     */ 
    public void setPrimaryEmail(String primaryEmail) throws InvalidEmailException
    {
        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new InvalidEmailException(primaryEmail + " is not a valid email address.");

        this.primaryEmail = primaryEmail;
    };
    
    /**
     *
     * @param userID
     */ 
    public void setUser(BigInteger userID){ this.userID = userID;};
    
    /**
     *
     * @param newEmail  Adds the new email address to the list of  auxiliary email addresses
     */ 
    public void addAuxiliaryEmails(String newEmail){
        this.auxiliaryEmails.add(newEmail);
    };

    /*
    *   Member variables
    */
    /**
     * Primary key of the person
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
    /**
     * The person's first name(s)
     */
    @Basic
    private String firstName;
    /**
     * The person's surname
     */
    @Basic
    private String surname;
    
    /**
     * The person's primary email address 
     */

    @Basic
    private String primaryEmail;
    
    /**
     * A list of secondary email addresses, 
     * to be added only after person's creation
     */
    @ElementCollection
    private List<String> auxiliaryEmails;
    
    /**
     * An object that contains this person's User
     * If it is NULL, this person is just a normal researcher
     */
    @Basic
    private BigInteger userID;
    
    /**
     * A list of this person's research groups (holds ID of the association)
     */
    @OneToMany
    private List<ResearchGroupAssociation> groupAssociations;
    
    /**
     * A list of this person's research categories (holds ID of the association)
     */
    @OneToMany
    private List<ResearcherCategoryAssociation> categoryAssociations;
}
