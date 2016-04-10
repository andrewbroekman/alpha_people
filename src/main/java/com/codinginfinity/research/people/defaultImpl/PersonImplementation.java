package com.codinginfinity.research.people.defaultImpl;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PersonImplementation type, an entity defined as being a record of a human being
 */
@javax.persistence.Entity
public class PersonImplementation implements com.codinginfinity.research.people.Entity {
    /**
    *  Defines the no-args constructor for a PersonImplementation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected PersonImplementation() {}
    
    /**
    * Defines the interface of the standard constructor for
    * a basic PersonImplementation.
    * @param    firstName   The name(s) of the PersonImplementation
    * @param    surname     The surname of the PersonImplementation
    * @param    primaryEmail The primary email address of the PersonImplementation
    * @throws   com.codinginfinity.research.people.InvalidEmailException Throws when given an invalid email format
    */
    public PersonImplementation(String firstName, String surname, String primaryEmail) throws com.codinginfinity.research.people.InvalidEmailException
    {
        this.categoryAssociations = new ArrayList<ResearcherCategoryAssociationImplementation>();
        this.groupAssociations = new ArrayList<com.codinginfinity.research.people.ResearchGroupAssociation>();
        this.auxiliaryEmails = new ArrayList<String>();
        
        this.firstName = firstName;
        this.surname = surname;

        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new com.codinginfinity.research.people.InvalidEmailException(primaryEmail + " is not a valid email address.");

        this.primaryEmail = primaryEmail;
        this.userID = null;
    }
    
    /**
    * Defines the interface of a constructor for a PersonImplementation
    * who has a user object already defined
    * @param    firstName   The name(s) of the PersonImplementation
    * @param    surname     The surname of the PersonImplementation
    * @param    primaryEmail The primary email address of the PersonImplementation
    * @param    userID        The id of the user object associated with the person
    * @throws   com.codinginfinity.research.people.InvalidEmailException Throws if the given email does not match standard email format
    */
    public PersonImplementation(String firstName, String surname, String primaryEmail, BigInteger userID) throws com.codinginfinity.research.people.InvalidEmailException
    {
        this.categoryAssociations = new ArrayList<ResearcherCategoryAssociationImplementation>();
        this.groupAssociations = new ArrayList<com.codinginfinity.research.people.ResearchGroupAssociation>();
        this.auxiliaryEmails = new ArrayList<String>();

        this.firstName = firstName;
        this.surname = surname;

        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new com.codinginfinity.research.people.InvalidEmailException(primaryEmail + " is not a valid email address.");

        this.primaryEmail = primaryEmail;
        this.userID = userID;
        
    }
    
    public void addGroupAssociation(com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type)
    {
        groupAssociations.add(new ResearchGroupAssociationImplementation(group, type));
    }
    
    public void addGroupAssociation(com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type, Date startDate)
            throws com.codinginfinity.research.people.DateInvalidException
    {
        groupAssociations.add(new ResearchGroupAssociationImplementation(group, type, startDate));
    }
    
    public void addGroupAssociation(com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type, Date startDate, Date endDate)
            throws com.codinginfinity.research.people.DateInvalidException
    {
        groupAssociations.add(new ResearchGroupAssociationImplementation(group, type, startDate, endDate));
    }
    
    public void endGroupAssociation(com.codinginfinity.research.people.Group group)
    {
        group.memberQuits(this);
        
        groupAssociations.remove(group);
    }
    
    /**
     * Called when the group removes person
     * @param group 
     */
    public void removedFromGroup(com.codinginfinity.research.people.Group group)
    {
        groupAssociations.remove(group);
    }
    
    public void addCategory(ResearcherCategoryImplementation category)
    {
        categoryAssociations.add(new ResearcherCategoryAssociationImplementation(category));
    }
    
    public void addCategory(ResearcherCategoryImplementation category, Date effectiveDate)
            throws com.codinginfinity.research.people.DateInvalidException
    {
        categoryAssociations.add(new ResearcherCategoryAssociationImplementation(category, effectiveDate));
    }
    
    public void removeCategory(ResearcherCategoryImplementation category)
    {
        categoryAssociations.remove(category);
    }
    
    /**
    * Defines a function that returns the firstName of the PersonImplementation
    * @return The first name(s) of the PersonImplementation
    */
    public String getFirstName() { return this.firstName; }
    
    /**
    * Defines a function that returns the surname of the PersonImplementation
    * @return The surname of the PersonImplementation
    */
    public String getSurmame() { return this.surname; }
    
    /**
    * Defines a function that returns the primary email address of the PersonImplementation
    * @return The primary email address of the PersonImplementation
    */
    public String getPrimaryEmail() { return this.primaryEmail; }
    
    /**
    * Defines a function that returns the list of auxiliary email addresses of the PersonImplementation
    * @return The primary email address of the PersonImplementation
    */
    public List<String> getAuxiliaryEmails() { return this.auxiliaryEmails; }
    
    /**
    * Defines a function that returns the user object
    * associated with this PersonImplementation
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
     * @throws com.codinginfinity.research.people.InvalidEmailException
     */ 
    public void setPrimaryEmail(String primaryEmail) throws com.codinginfinity.research.people.InvalidEmailException
    {
        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new com.codinginfinity.research.people.InvalidEmailException(primaryEmail + " is not a valid email address.");

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
    
    public void removeAuxiliaryEmails(String email)
    {
        this.auxiliaryEmails.remove(email);
    };
    
    public void clearAuxiliaryEmails()
    {
        this.auxiliaryEmails.clear();
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
    private List<com.codinginfinity.research.people.ResearchGroupAssociation> groupAssociations;
    
    /**
     * A list of this person's research categories (holds ID of the association)
     */
    @OneToMany
    private List<ResearcherCategoryAssociationImplementation> categoryAssociations;
}
