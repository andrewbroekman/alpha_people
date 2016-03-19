/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import java.util.Date;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * A saved state of a ResearcherCategory
 */
public class ResearchCategoryState {
    /**
    *  Defines the no-args constructor for a ResearchCategoryState
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearchCategoryState() {}
    
    /**
     * Defines the standard constructor for a ResearchCategoryState, which knows
     * the effective date and research output target
     * @param effectiveDate The effective date for this state
     * @param researchOutputTarget The research output target at the time of this state's creation
     * @throws DateInvalidException Throws if a future date is thrown for an event that must be in the past
     */
    public ResearchCategoryState(Date effectiveDate, float researchOutputTarget)
            throws DateInvalidException
    {
        if(effectiveDate.after(new Date()))
            throw new DateInvalidException("The date "+effectiveDate+" must be in the past"
            +" in order for it to be a valid date for a state to become effective");
        this.effectiveDate = effectiveDate;
        this.researchOutputTarget = researchOutputTarget;
    }
    
    /**
     * Returns the effective date of this state
     * @return The effective date belonging to this state
     */
    public Date getEffectiveDate() { return this.effectiveDate; }
    
    /**
     * Returns the research output target for this state
     * @return The research output target belonging to this state
     */
    public float getResearchOutputTarget() { return this.researchOutputTarget; }
    /*
    * Member variables
    */
    
    /**
     * The effective date of this saved state
     */
    private Date effectiveDate;
    
    /**
     * The target status of this state
     */
    private float researchOutputTarget;

}
