package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface Person extends Entity
{
    void addGroupAssociation(Group group, ResearchGroupAssociationType type) throws GroupSuspendedException;
    
    void addGroupAssociation(Group group, ResearchGroupAssociationType type, Date startDate) throws DateInvalidException, GroupSuspendedException;
    
    void addGroupAssociation(Group group, ResearchGroupAssociationType type, Date startDate, Date endDate) throws DateInvalidException, GroupSuspendedException;
    
    void endGroupAssociation(Group group) throws GroupSuspendedException;
    
    void addCategory(ResearcherCategory category);
    
    void addCategory(ResearcherCategory category, Date effectiveDate) throws DateInvalidException;
    
    
    void addMemberToGroup(Person member, Group group, ResearchGroupAssociationType type) throws GroupSuspendedException, UnauthorizedUserExeption, NonMemberExeption;
    
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
