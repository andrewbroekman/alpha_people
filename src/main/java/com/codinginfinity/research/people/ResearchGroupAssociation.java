/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import java.util.Date;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * This class represents an association between a Person has with a Group object
 * and defines its type
 */
public class ResearchGroupAssociation {
    /**
    *  Defines the no-args constructor for a Person
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearchGroupAssociation(){}
    
    
    /**
    * Defines the interface of the standard constructor for
    * a basic ResearchGroupAssociation. Assumes that starting date is NOW.
    * Also assumes association has not ended
    * @param    group   The Group in the association
    * @param    type    The type of association this is    
    */
    public ResearchGroupAssociation(Group group, ResearchGroupAssociationType type)
    {
        this.group = group;
        this.type = type;
        this.startDate = (new Date());        
    }
    
    /**
    * Defines the interface for a constructor for a ResearchGroupAssociation wherein
    * a start date has been specified. Assumes association has not ended.
    * @param    group   The Group in the association
    * @param    type    The type of association this is
    * @param    startDate   The date upon which the association started
    * @throws   DateInvalidException    Throws an exception if the date provided for
    *  a start date is in the future
    */
    public ResearchGroupAssociation(Group group, ResearchGroupAssociationType type, Date startDate) 
            throws DateInvalidException
    {
        this.group = group;
        if(startDate.after(new Date())) 
            throw new DateInvalidException("Date "+startDate+" is in the future,"
                    + " but a research group association must start in the past");
        this.startDate = startDate;
    }
    
    /**
    * Defines the interface for a constructor for a ResearchGroupAssociation wherein
    * a start date has been specified as well as an end date (thus we know this association is over)
    * @param    group   The Group in the association
    * @param    type    The type of association this is
    * @param    startDate   The date upon which the association started
    * @param    endDate The date upon which this association ended
    * @throws   DateInvalidException    Throws an exception if the date provided for
    *  a start date is in the future or if provided end date is in the past
    */
    public ResearchGroupAssociation(Group group, ResearchGroupAssociationType type, Date startDate, Date endDate)
            throws DateInvalidException 
    {
        this.group = group;
        if(startDate.after(new Date()))
            throw new DateInvalidException("Date "+startDate+" is in the future,"
                    + " but a research group association must start in the past");
        this.startDate = startDate;
        
        
        if(endDate.after(new Date()))
            throw new DateInvalidException("Date "+endDate+" is in the future,"
            +" but a research group association cannot have an end date if that"
            +" date has yet to come to pass");
        this.endDate = endDate;
    }
    
    /**
     * Returns the Group in the association
     * @return  The Group in the association
     */
    public Group getGroup() { return this.group; }


    /**
     * Returns the date upon which the association started
     * @return  The Start date for the association
     */
    public Date getStartDate() { return this.startDate; }
    
    /**
     * Returns the date upon which the association ended
     * @return  The End date of the association
     */
    public Date getEndDate() { return this.endDate; }

    /**
     * Returns the type of this association
     * @return The type of association this is
     */
    public ResearchGroupAssociationType getType() { return this.type; }
    
    /*
    * Member variables
    */
    
    /**
     * The Group in the association
     */
    private Group group;
    
    /**
     * The date upon which the association started
     */
    private Date startDate;
    
    /**
     * The date upon which the association ended
     */
    Date endDate;
    
    /**
     * The type of the association
     */
    ResearchGroupAssociationType type;
}
