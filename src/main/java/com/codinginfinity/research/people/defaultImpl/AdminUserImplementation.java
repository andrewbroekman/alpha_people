/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people.defaultImpl;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * An admin user type, with higher responsibility levels
 * @author Renton Mcintyre (u14312710)
 */
@javax.persistence.Entity

public class AdminUserImplementation implements com.codinginfinity.research.people.User
{
    public void addPerson(String firstName, String surname, String primaryEmail) throws com.codinginfinity.research.people.InvalidEmailException
    {
        PersonImplementation person = new PersonImplementation(firstName, surname, primaryEmail);
    }

    public void addPerson(String firstName, String surname,  String primaryEmail, BigInteger user) throws com.codinginfinity.research.people.InvalidEmailException
    {
        PersonImplementation person = new PersonImplementation(firstName, surname, primaryEmail, user);
    }

    public void addResearchCategory()
    {
        ResearcherCategoryImplementation rs = new ResearcherCategoryImplementation();
    }
    
    public void addResearchCategory(com.codinginfinity.research.people.ResearchCategoryState researchState)
    {
        ResearcherCategoryImplementation rs = new ResearcherCategoryImplementation(researchState);
    }
    
    public void modifyResearchCategory(BigInteger researchCategoryID)
    {
        
    }
    
    public void activateResearchGroup(GroupImplementation g)
    {
        g.activateGroup();
    }
    
    public void suspendResearchGroup(GroupImplementation g)
    {
        g.suspendGroup();
    }
    
    public void reactivateResearchGroup(GroupImplementation g)
    {
        g.activateGroup();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
}
