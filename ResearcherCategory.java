/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import java.util.ArrayList;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * Defines the ResearcherCategory object
 */
public class ResearcherCategory {
    /**
    *  Defines the no-args constructor for a RsearcherCategory
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearcherCategory() {}
    
    /**
    * Defines the the interface for standard constructor 
    * for a ResearcherCategory that takes
    * a single ResearchCategoryState as a starting point
    * @param    start   A state to be added to the state list from the initial point
    */
    public ResearcherCategory(ResearchCategoryState start) 
    {
        states = new ArrayList<ResearchCategoryState>();
        this.states.add(start);
    }
    
    
    /**
     * Returns the list of states for this ResearcherCategory
     * @return The list of states for this ResearcherCategory
     */
    public ArrayList<ResearchCategoryState> getStates() { return this.states; }
    
    /**
     * memberVariables
     */
    
    /**
     * The list of saved states of this ResearcherCategory
     */
    private ArrayList<ResearchCategoryState> states;
    
}
