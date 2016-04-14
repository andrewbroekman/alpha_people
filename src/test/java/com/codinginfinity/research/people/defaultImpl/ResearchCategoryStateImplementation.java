/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people.defaultImpl;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


/**
 * A saved state of a ResearcherCategoryImplementation
 */
@javax.persistence.Entity
public class ResearchCategoryStateImplementation {
    /**
    *  Defines the no-args constructor for a ResearchCategoryStateImplementation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearchCategoryStateImplementation() {}
    
    /**
     * Defines the standard constructor for a ResearchCategoryStateImplementation, which knows
     * the effective date and research output target
     * @param effectiveDate The effective date for this state
     * @param researchOutputTarget The research output target at the time of this state's creation
     * @throws com.codinginfinity.research.people.DateInvalidException Throws if a future date is thrown for an event that must be in the past
     */
    public ResearchCategoryStateImplementation(Date effectiveDate, float researchOutputTarget)
            throws com.codinginfinity.research.people.DateInvalidException
    {
        if(effectiveDate.after(new Date()))
            throw new com.codinginfinity.research.people.DateInvalidException("The date "+effectiveDate+" must be in the past"
            +" in order for it to be a valid date for a state to become effective");
        this.effectiveDate = effectiveDate;
        this.researchOutputTarget = researchOutputTarget;
    }

    public BigInteger getId() {
        return this.id;
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

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
    /**
     * The effective date of this saved state
     */
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;
    
    /**
     * The target status of this state
     */
    @Basic
    private float researchOutputTarget;

}
