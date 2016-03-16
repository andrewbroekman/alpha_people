/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * This defines an association between a Reseacher (a type of person) and a
 * ResearcherCategory
 */
@Stateless
@LocalBean
public class ResearcherCategoryAssociation {
    /**
    *  Defines the no-args constructor for a ResearchCategoryAssociation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearcherCategoryAssociation() {}
    
    /**
     * Defines the standard constructor for a ResearchCategoryAssociation, which
     * assumes date to be NOW and is provided a ResearcherCategory
     * @param category The researcher category belonging to this association
     */
    public ResearcherCategoryAssociation(ResearcherCategory category)
    {
        this.effectiveDate = (new Date());
        this.category = category;
    }
    
    
    /**
     * Defines a second constructor for a ResearchCategoryAssociation, which
     * is given a date and a ResearcherCategory
     * @param   category    The researcher category belonging to this association
     * @param   effectiveDate The effective date of this association
     * @throws DateInvalidException Throws if a date in the future is given for a past event
     */
    public ResearcherCategoryAssociation(ResearcherCategory category, Date effectiveDate)
            throws DateInvalidException
    {
        this.category = category;
        
        if(effectiveDate.after(new Date()))
            throw new DateInvalidException("The date "+effectiveDate+" must be in the past"
            +" in order for it to be a valid date for a category association to become effective");
        this.effectiveDate = effectiveDate;

    }

    /**
     * Returns the effective date of this association
     * @return The effective date belonging to this association
     */
    public Date getEffectiveDate() { return this.effectiveDate; }
    
    /**
     * Returns the research category for this association
     * @return The research category belonging to this association
     */
    public ResearcherCategory getCategory() { return this.category; }
    /*
    * Member variables
    */
    
    /**
     * The effective date of this saved state
     */
    private Date effectiveDate;
    
    /**
     * The Researcher category belonging to this state
     */
    private ResearcherCategory category;
}
