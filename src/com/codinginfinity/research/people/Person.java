package com.codinginfinity.research.people;

import com.codinginfinity.research.people.defaultImpl.ResearcherCategoryImplementation;
import java.math.BigInteger;
import java.util.Date;

public interface Person extends Entity
{
     /**
     * Adds a new Researcher Category
     * 
     * Functionality Scope: Administrator-addResearcherCategory
     * 
     * @param researchState
     * @throws UnauthorizedUserExeption Throws an exception if the user is not an admin
     */
    void addResearcherCategory(ResearchCategoryState researchState) throws UnauthorizedUserExeption;
    
    /**
     * Adds a new Researcher Category State
     * 
     * @param researcherCategory
     * @param state
     * @throws UnauthorizedUserExeption Throws an exception if the user is not an admin
     */
    void addResearcherCategoryState(ResearcherCategory researcherCategory, ResearchCategoryState state) throws UnauthorizedUserExeption;
    
    /**
     * Removes the state from the Researcher Category
     * 
     * @param researcherCategory
     * @param state
     * @throws UnauthorizedUserExeption 
     */
    void removeResearcherCategoryState(ResearcherCategory researcherCategory, ResearchCategoryState state) throws UnauthorizedUserExeption;
    
    /**
     * Removes the specified category
     * 
     * @param category 
     */
    void removeCategory(ResearcherCategoryImplementation category);
    
    
    
    
    void addGroupAssociation(Group group, ResearchGroupAssociationType type) throws GroupSuspendedException;
    
    void addGroupAssociation(Group group, ResearchGroupAssociationType type, Date startDate) throws DateInvalidException, GroupSuspendedException;
    
    void addGroupAssociation(Group group, ResearchGroupAssociationType type, Date startDate, Date endDate) throws DateInvalidException, GroupSuspendedException;
    
    void endGroupAssociation(Group group) throws GroupSuspendedException;
    
    /**
    * Adds a new researcher category
    * 
    * @param category 
    */    
    void addCategory(ResearcherCategory category);
    
    /**
     * Adds a new researcher category
     * 
     * @param category
     * @param effectiveDate
     * @throws com.codinginfinity.research.people.DateInvalidException 
     */
    void addCategory(ResearcherCategory category, Date effectiveDate) throws DateInvalidException;
    
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
    void addMemberToGroup(Person member, Group group, ResearchGroupAssociationType type) throws GroupSuspendedException, UnauthorizedUserExeption, NonMemberExeption;
    
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
    void addMemberToGroup(Person member, Group group, ResearchGroupAssociationType type, Date startDate) throws DateInvalidException, GroupSuspendedException, UnauthorizedUserExeption, NonMemberExeption;
    
    
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
    void addMemberToGroup(Person member, Group group, ResearchGroupAssociationType type, Date startDate, Date endDate) throws DateInvalidException, GroupSuspendedException, UnauthorizedUserExeption, NonMemberExeption;
    
    
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
    void removeMemberFromGroup(Person member, Group group) throws DateInvalidException, GroupSuspendedException, UnauthorizedUserExeption, NonMemberExeption;
    
    void addGroupToGroup(Group subGroup, Group superGroup, ResearchGroupAssociationType type) throws GroupSuspendedException, UnauthorizedUserExeption;
    
    void activateGroup(Group group) throws UnauthorizedUserExeption;
    
    void suspendGroup(Group group) throws UnauthorizedUserExeption;
    
    
    String getFirstName();
    
    String getSurmame();
    
    String getPrimaryEmail();
    
    BigInteger getUserID();
    
    void setFirstName(String firstName);
    
    void setSurname(String surname);
    
    void setPrimaryEmail(String primaryEmail) throws InvalidEmailException;
    
    void setUser(BigInteger userID);
     
    void addAuxiliaryEmails(String newEmail);
    
    boolean isAdmin();
}
