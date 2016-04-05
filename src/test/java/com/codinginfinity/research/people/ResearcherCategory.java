/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * Defines the ResearcherCategory object
 */
@javax.persistence.Entity
public class ResearcherCategory {
    /**
    *  Defines the no-args constructor for a ResearcherCategory
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearcherCategory() {}
    
    /**
    * Defines the the interface for standard constructor 
    * for a ResearcherCategory that takes
    * a single ResearchCategoryState as a starting point
    * @param    stateID   A state to be added to the state list from the initial point
    */
    public ResearcherCategory(ResearchCategoryState stateID)
    {
        this.states = new ArrayList<ResearchCategoryState>();
        this.states.add(stateID);
    }

    public void addState(ResearchCategoryState stateID)
    {
        this.states.add(stateID);
    }
    /**
     * Returns the list of states for this ResearcherCategory
     * @return The list of states for this ResearcherCategory
     */
    public List<ResearchCategoryState> getStatIDs() { return this.states; }
    
    /**
     * memberVariables
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    BigInteger id;
    /**
     * The list of saved states of this ResearcherCategory
     */
    @OneToMany
    private List<ResearchCategoryState> states;
    
}
