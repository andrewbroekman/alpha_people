package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface PersonInterface 
{
    void addGroup(Group group, ResearchGroupAssociationType type);
    
    void addGroup(Group group, ResearchGroupAssociationType type, Date startDate) throws DateInvalidException;
    
    void addGroup(Group group, ResearchGroupAssociationType type, Date startDate, Date endDate) throws DateInvalidException;
    
    void addCategory(ResearcherCategory category);
    
    void addCategory(ResearcherCategory category, Date effectiveDate) throws DateInvalidException;
    
    String getFirstName();
    
    String getSurmame();
    
    String getPrimaryEmail();
    
    BigInteger getUserID();
    
    void setFirstName(String firstName);
    
    void setSurname(String surname);
    
    void setPrimaryEmail(String primaryEmail) throws InvalidEmailException;
    
    void setUser(BigInteger userID);
     
    void addAuxiliaryEmails(String newEmail);
}
