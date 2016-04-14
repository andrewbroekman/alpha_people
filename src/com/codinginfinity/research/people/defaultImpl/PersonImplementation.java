package com.codinginfinity.research.people.defaultImpl;

import com.codinginfinity.research.people.GroupSuspendedException;
import com.codinginfinity.research.people.NonMemberExeption;
import com.codinginfinity.research.people.UnauthorizedUserExeption;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PersonImplementation type, an entity defined as being a record of a human being
 */
@javax.persistence.Entity
public class PersonImplementation implements com.codinginfinity.research.people.Person 
{
    /**
    *  Defines the no-args constructor for a PersonImplementation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected PersonImplementation() {}

    /**
     * Defines the interface of the standard constructor for
     * a basic PersonImplementation.
     * 
     * @param firstName     The name(s) of the PersonImplementation
     * @param surname       The surname of the PersonImplementation
     * @param primaryEmail  The primary email address of the PersonImplementation
     * @param isAdmin       Specifies if the user is to be an admin or not
     * @throws com.codinginfinity.research.people.InvalidEmailException 
     */
    public PersonImplementation(String firstName, String surname, String primaryEmail, boolean isAdmin) throws com.codinginfinity.research.people.InvalidEmailException
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
        
        this.isAdmin = isAdmin;
    }
    
    /**
    * Defines the interface of a constructor for a PersonImplementation
    * who has a user object already defined
    * 
    * Functionality Scope: Person-addPersons
    * 
    * @param    firstName   The name(s) of the PersonImplementation
    * @param    surname     The surname of the PersonImplementation
    * @param    primaryEmail The primary email address of the PersonImplementation
    * @param    userID        The id of the user object associated with the person
    * @param    isAdmin       Specifies if the user is to be an admin or not
    * @throws   com.codinginfinity.research.people.InvalidEmailException Throws if the given email does not match standard email format
    */
    public PersonImplementation(String firstName, String surname, String primaryEmail, BigInteger userID, boolean isAdmin) throws com.codinginfinity.research.people.InvalidEmailException
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
        this.isAdmin = isAdmin;
        
    }
    
    /**
     * Adds a new Researcher Category
     * 
     * Functionality Scope: Administrator-addResearcherCategory
     * 
     * @param researchState
     * @throws UnauthorizedUserExeption Throws an exception if the user is not an admin
     */
    public void addResearcherCategory(com.codinginfinity.research.people.ResearchCategoryState researchState) 
            throws UnauthorizedUserExeption
    {
        ResearcherCategoryImplementation rs;
        
        if(this.isAdmin)
            rs = new ResearcherCategoryImplementation(researchState);
        else
            throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not an admin"); 
    }

    /**
     * Adds a new Researcher Category State
     * 
     * @param researcherCategory
     * @param state
     * @throws UnauthorizedUserExeption Throws an exception if the user is not an admin
     */
    public void addResearcherCategoryState(com.codinginfinity.research.people.ResearcherCategory researcherCategory, com.codinginfinity.research.people.ResearchCategoryState state) 
            throws UnauthorizedUserExeption
    {
        if(this.isAdmin)
            researcherCategory.addState(state);
        else
            throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not an admin");
    }
        
    /**
     * Removes the state from the Researcher Category
     * 
     * @param researcherCategory
     * @param state
     * @throws UnauthorizedUserExeption 
     */
    public void removeResearcherCategoryState(com.codinginfinity.research.people.ResearcherCategory researcherCategory, com.codinginfinity.research.people.ResearchCategoryState state) 
            throws UnauthorizedUserExeption
    {
        if(this.isAdmin)
            researcherCategory.removeState(state);
        else
            throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not an admin");
    }
        
   /**
    * Adds a new researcher category
    * 
    * @param category 
    */     
    @Override
    public void addCategory(com.codinginfinity.research.people.ResearcherCategory category)
    {
        categoryAssociations.add(new ResearcherCategoryAssociationImplementation(category));
    }
    
    /**
     * Adds a new researcher category
     * 
     * @param category
     * @param effectiveDate
     * @throws com.codinginfinity.research.people.DateInvalidException 
     */
    @Override
    public void addCategory(com.codinginfinity.research.people.ResearcherCategory category, Date effectiveDate)
            throws com.codinginfinity.research.people.DateInvalidException
    {
        categoryAssociations.add(new ResearcherCategoryAssociationImplementation(category, effectiveDate));
    }
    
    /**
     * Removes the specified category
     * 
     * @param category 
     */
    public void removeCategory(ResearcherCategoryImplementation category)
    {
        categoryAssociations.remove(category);
    }

    /**
     * Admins and group leaders can add people to a specified group.
     * Admins can add any person to any group.
     * Group leaders can only add members to their own group.
     * 
     * Functionality Scope: Person-addResearchGroupAssociations
     * 
     * @param member
     * @param group
     * @param type
     * @throws com.codinginfinity.research.people.GroupSuspendedException
     * @throws com.codinginfinity.research.people.UnauthorizedUserExeption
     * @throws NonMemberExeption 
     */
    @Override
    public void addMemberToGroup(com.codinginfinity.research.people.Person member, com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type)
            throws com.codinginfinity.research.people.GroupSuspendedException, com.codinginfinity.research.people.UnauthorizedUserExeption, NonMemberExeption
    {
        int index = -1;
        com.codinginfinity.research.people.ResearchGroupAssociationType association;
        
        if(this.isAdmin)
            member.addGroupAssociation(group, type);
        else
        {
            for(int i = 0; i < this.groupAssociations.size(); i++)
            {
                if(this.groupAssociations.get(i).getGroup().equals(group))
                    index = i;
            }

            if(index == -1)
                throw new com.codinginfinity.research.people.NonMemberExeption("This user is not a member of this group");

            association = this.groupAssociations.get(index).getType();

            if(association.equals(com.codinginfinity.research.people.ResearchGroupAssociationType.GROUPLEADER))
                member.addGroupAssociation(group, type);
            else
                throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not the group leader of this group");
        }
    }

    /**
     * Admins and group leaders can add people to a specified group.
     * Admins can add any person to any group.
     * Group leaders can only add members to their own group.
     * 
     * Functionality Scope: ResearchGroupLeader-addResearchGroupAssociations
     * 
     * @param member
     * @param group
     * @param type
     * @param startDate
     * @throws com.codinginfinity.research.people.DateInvalidException
     * @throws com.codinginfinity.research.people.GroupSuspendedException
     * @throws com.codinginfinity.research.people.UnauthorizedUserExeption
     * @throws NonMemberExeption 
     */
    public void addMemberToGroup(com.codinginfinity.research.people.Person member, com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type, Date startDate)
            throws com.codinginfinity.research.people.DateInvalidException, com.codinginfinity.research.people.GroupSuspendedException, com.codinginfinity.research.people.UnauthorizedUserExeption, NonMemberExeption
    {
        int index = -1;
        com.codinginfinity.research.people.ResearchGroupAssociationType association;
        
        if(this.isAdmin)
            member.addGroupAssociation(group, type, startDate);
        else
        {
            for(int i = 0; i < this.groupAssociations.size(); i++)
            {
                if(this.groupAssociations.get(i).getGroup().equals(group))
                    index = i;
            }

            if(index == -1)
                throw new com.codinginfinity.research.people.NonMemberExeption("This user is not a member of this group");

            association = this.groupAssociations.get(index).getType();

            if(association.equals(com.codinginfinity.research.people.ResearchGroupAssociationType.GROUPLEADER))
                member.addGroupAssociation(group, type, startDate);
            else
                throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not the group leader of this group");
        }
    }
    
    /**
     * Admins and group leaders can add people to a specified group.
     * Admins can add any person to any group.
     * Group leaders can only add members to their own group.
     * 
     * Functionality Scope: ResearchGroupLeader-addResearchGroupAssociations
     * 
     * @param member
     * @param group
     * @param type
     * @param startDate
     * @param endDate
     * @throws com.codinginfinity.research.people.DateInvalidException
     * @throws GroupSuspendedException
     * @throws com.codinginfinity.research.people.UnauthorizedUserExeption
     * @throws NonMemberExeption 
     */
    public void addMemberToGroup(com.codinginfinity.research.people.Person member, com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type, Date startDate, Date endDate)
            throws com.codinginfinity.research.people.DateInvalidException, GroupSuspendedException, com.codinginfinity.research.people.UnauthorizedUserExeption, NonMemberExeption
    {
        int index = -1;
        com.codinginfinity.research.people.ResearchGroupAssociationType association;
        
        if(this.isAdmin)
            member.addGroupAssociation(group, type, startDate, endDate);
        else
        {
            for(int i = 0; i < this.groupAssociations.size(); i++)
            {
                if(this.groupAssociations.get(i).getGroup().equals(group))
                    index = i;
            }

            if(index == -1)
                throw new com.codinginfinity.research.people.NonMemberExeption("This user is not a member of this group");

            association = this.groupAssociations.get(index).getType();

            if(association.equals(com.codinginfinity.research.people.ResearchGroupAssociationType.GROUPLEADER))
                member.addGroupAssociation(group, type, startDate);
            else
                throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not the group leader of this group");
        }
    }
    
    /**
     * Admins and group leaders can remove people from a specified group.
     * Admins can add remove any person from any group.
     * Group leaders can only remove members from their own group.
     * 
     * Functionality Scope: ResearchGroupLeader-endResearchGroupAssociations
     * 
     * @param member
     * @param group
     * @throws com.codinginfinity.research.people.DateInvalidException
     * @throws com.codinginfinity.research.people.GroupSuspendedException
     * @throws com.codinginfinity.research.people.UnauthorizedUserExeption
     * @throws NonMemberExeption 
     */
    public void removeMemberFromGroup(com.codinginfinity.research.people.Person member, com.codinginfinity.research.people.Group group) 
            throws com.codinginfinity.research.people.DateInvalidException, com.codinginfinity.research.people.GroupSuspendedException, com.codinginfinity.research.people.UnauthorizedUserExeption, NonMemberExeption
    {
        int index = -1;
        com.codinginfinity.research.people.ResearchGroupAssociationType association;
        
        if(this.isAdmin)
        {
            group.removeMember(member);
            member.endGroupAssociation(group);
        }
        else
        {
            for(int i = 0; i < this.groupAssociations.size(); i++)
            {
                if(this.groupAssociations.get(i).getGroup().equals(group))
                    index = i;
            }

            if(index == -1)
                throw new com.codinginfinity.research.people.NonMemberExeption("This user is not a member of this group");

            association = this.groupAssociations.get(index).getType();

            if(association.equals(com.codinginfinity.research.people.ResearchGroupAssociationType.GROUPLEADER))
            {
                group.removeMember(member);
                member.endGroupAssociation(group);
            }
            else
                throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not the group leader of this group");
        }
    }
    
    /**
     * Admins are able to add groups to super groups
     * 
     * Functionality Scope: ResearchGroupLeader-addResearchGroupAssociations
     * 
     * @param subGroup
     * @param superGroup
     * @param type
     * @throws com.codinginfinity.research.people.GroupSuspendedException
     * @throws com.codinginfinity.research.people.UnauthorizedUserExeption 
     */
    public void addGroupToGroup(com.codinginfinity.research.people.Group subGroup, com.codinginfinity.research.people.Group superGroup, com.codinginfinity.research.people.ResearchGroupAssociationType type)
            throws com.codinginfinity.research.people.GroupSuspendedException, com.codinginfinity.research.people.UnauthorizedUserExeption
    {
        if(this.isAdmin())
            superGroup.addMember(subGroup);
        else
            throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not an admin");       
    }
    
    /**
     * Called by addMemberToGroup to make changes to the specified person and group
     * 
     * @param group
     * @param type
     * @throws com.codinginfinity.research.people.GroupSuspendedException 
     */
    @Override
    public void addGroupAssociation(com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type)
            throws com.codinginfinity.research.people.GroupSuspendedException
    {
        groupAssociations.add(new ResearchGroupAssociationImplementation(group, type));
        group.addMember(this);
    }

    /**
     * Called by addMemberToGroup to make changes to the specified person and group
     * 
     * @param group
     * @param type
     * @param startDate
     * @throws com.codinginfinity.research.people.DateInvalidException
     * @throws com.codinginfinity.research.people.GroupSuspendedException 
     */
    @Override
    public void addGroupAssociation(com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type, Date startDate)
            throws com.codinginfinity.research.people.DateInvalidException,com.codinginfinity.research.people.GroupSuspendedException
    {
        groupAssociations.add(new ResearchGroupAssociationImplementation(group, type, startDate));
        group.addMember(this);
    }
    
    /**
     * Called by addMemberToGroup to make changes to the specified person and group
     * 
     * @param group
     * @param type
     * @param startDate
     * @param endDate
     * @throws com.codinginfinity.research.people.DateInvalidException
     * @throws GroupSuspendedException 
     */
    @Override
    public void addGroupAssociation(com.codinginfinity.research.people.Group group, com.codinginfinity.research.people.ResearchGroupAssociationType type, Date startDate, Date endDate)
            throws com.codinginfinity.research.people.DateInvalidException, GroupSuspendedException
    {
        groupAssociations.add(new ResearchGroupAssociationImplementation(group, type, startDate, endDate));
        group.addMember(this);
    }
    
    /**
     * Called by removeMemberFromGroup to make changes to the specified person and group
     * @param group
     * @throws com.codinginfinity.research.people.GroupSuspendedException 
     */
    @Override
    public void endGroupAssociation(com.codinginfinity.research.people.Group group) 
            throws com.codinginfinity.research.people.GroupSuspendedException
    {
        groupAssociations.remove(group);
    }

    /**
     * Called by an admin user to suspend a group's activities
     * 
     * Functionality Scope: Administrator-suspendResearcherGroup
     * 
     * @param group
     * @throws UnauthorizedUserExeption 
     */
    public void suspendGroup(com.codinginfinity.research.people.Group group) 
            throws UnauthorizedUserExeption
    {
        if(this.isAdmin)
                group.suspendGroup();
            else
                throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not an admin");
    }
    
    /**
     * Called by an admin user to activate a group's activities
     * 
     * Functionality Scope: Administrator-activateResearcherGroup
     * 
     * @param group
     * @throws UnauthorizedUserExeption 
     */
    public void activateGroup(com.codinginfinity.research.people.Group group) 
            throws UnauthorizedUserExeption
    {
        if(this.isAdmin)
                group.suspendGroup();
            else
                throw new com.codinginfinity.research.people.UnauthorizedUserExeption("This user is not an admin");
    }
    
    /**
    * Defines a function that returns the firstName of the PersonImplementation
    * @return The first name(s) of the PersonImplementation
    */
    @Override
    public String getFirstName() { return this.firstName; }
    
    /**
    * Defines a function that returns the surname of the PersonImplementation
    * @return The surname of the PersonImplementation
    */
    @Override
    public String getSurmame() { return this.surname; }
    
    /**
    * Defines a function that returns the primary email address of the PersonImplementation
    * @return The primary email address of the PersonImplementation
    */
    @Override
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
    @Override
    public BigInteger getUserID() { return this.userID; }

    /**
     * Allows a person's first name to be changed
     * 
     * Functionality Scope: Person-editPersonDetails
     * 
     * @param firstName 
     */
    @Override
    public void setFirstName(String firstName){ this.firstName = firstName; }
    
    /**
     * Allows a person's surname to be changed
     * 
     * Functionality Scope: Person-editPersonDetails
     * 
     * @param surname 
     */
    @Override
    public void setSurname(String surname){ this.surname = surname;}; 
    
    /**
     * Allows a person's primary e-mail to be changed
     * 
     * Functionality Scope: Person-editPersonDetails
     * 
     * @param primaryEmail
     * @throws com.codinginfinity.research.people.InvalidEmailException 
     */
    @Override
    public void setPrimaryEmail(String primaryEmail) throws com.codinginfinity.research.people.InvalidEmailException
    {
        String EMAIL_REGEX = "^[-\\w_\\.+]*[-\\w_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(primaryEmail.matches(EMAIL_REGEX))
            this.primaryEmail = primaryEmail;
        else throw new com.codinginfinity.research.people.InvalidEmailException(primaryEmail + " is not a valid email address.");

        this.primaryEmail = primaryEmail;
    };
    
    /**
     * Allows a person's ID to be changed
     * 
     * Functionality Scope: Person-editPersonDetails
     * 
     * @param userID 
     */
    @Override
    public void setUser(BigInteger userID){ this.userID = userID;};
    
    /**
     * Adds a new email address to a person's list of auxiliary e-mail address
     * 
     * Functionality Scope: Person-editPersonDetails
     * 
     * @param newEmail 
     */
    @Override
    public void addAuxiliaryEmails(String newEmail){
        this.auxiliaryEmails.add(newEmail);
    };
    
    /**
     * Removes the specified e-mail address from a 
     * person's list of auxiliaryEmails
     * 
     * Functionality Scope: Person-editPersonDetails
     * 
     * @param email 
     */
    public void removeAuxiliaryEmails(String email)
    {
        this.auxiliaryEmails.remove(email);
    };
    
    /**
     * Removes all E-mail addresses from a list of auxiliary e-mail address
     * 
     * Functionality Scope: Person-editPersonDetails
     */
    public void clearAuxiliaryEmails()
    {
        this.auxiliaryEmails.clear();
    };
    
    /**
     * 
     * @return if the person is an Admin
     */
    @Override
    public boolean isAdmin()
    {
        return this.isAdmin;
    };

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
     * A list of this person's research categories
     */
    @OneToMany
    private List<ResearcherCategoryAssociationImplementation> categoryAssociations;
    
    @Basic
    private boolean isAdmin;
}
