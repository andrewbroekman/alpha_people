package com.codinginfinity.research.people;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * An admin user type, with higher responsibility levels
 * @author Renton Mcintyre (u14312710)
 */
@javax.persistence.Entity

public class AdminUser implements User 
{
    public void addPerson(String firstName, String surname, String primaryEmail) throws InvalidEmailException
    {
        Person person = new Person(firstName, surname, primaryEmail);
    }

    public void addPerson(String firstName, String surname,  String primaryEmail, BigInteger user) throws InvalidEmailException
    {
        Person person = new Person(firstName, surname, primaryEmail, user);
    }

    public void addResearchCategory()
    {
        ResearcherCategory rs = new ResearcherCategory();
    }
    
    public void addResearchCategory(ResearchCategoryState researchState)
    {
        ResearcherCategory rs = new ResearcherCategory(researchState);
    }
    
    public void modifyResearchCategory(BigInteger researchCategoryID)
    {
        
    }
    
    public void activateResearchGroup(Group g)
    {
        
    }
    
    public void suspendResearchGroup(Group g)
    {
        
    }
    
    public void reactivateResearchGroup(Group g)
    {
        
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
}
