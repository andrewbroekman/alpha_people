/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

/**
 * An admin user type, with higher responsibility levels
 * @author Renton Mcintyre (u14312710)
 */
public class AdminUser implements User 
{
    public void addResearchCategory()
    {
        ResearcherCategory rs = new ResearcherCategory();
    }
    
    public void addResearchCategory(ResearchCategoryState s)
    {
        ResearcherCategory rs = new ResearcherCategory(s);
    }
    
    public void modifyResearchCategory(ResearcherCategory s)
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
    
}
