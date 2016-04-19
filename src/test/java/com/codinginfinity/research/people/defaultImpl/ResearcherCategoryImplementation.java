/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people.defaultImpl;

import com.codinginfinity.research.people.ResearchCategoryState;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines the ResearcherCategoryImplementation object
 */
@javax.persistence.Entity
public class ResearcherCategoryImplementation implements com.codinginfinity.research.people.ResearcherCategory {
    /**
    *  Defines the no-args constructor for a ResearcherCategoryImplementation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected ResearcherCategoryImplementation() {}
    
    /**
    * Defines the the interface for standard constructor 
    * for a ResearcherCategoryImplementation that takes
    * a single ResearchCategoryStateImplementation as a starting point
    * @param    stateID   A state to be added to the state list from the initial point
    */
    public ResearcherCategoryImplementation(com.codinginfinity.research.people.ResearchCategoryState stateID)
    {
        this.states = new ArrayList<com.codinginfinity.research.people.ResearchCategoryState>();
        this.states.add(stateID);
    }

    public void addState(com.codinginfinity.research.people.ResearchCategoryState stateID)
    {
        this.states.add(stateID);
    }
    
    public void removeState(com.codinginfinity.research.people.ResearchCategoryState stateID)
    {
        this.states.remove(stateID);
    }
    /**
     * Returns the list of states for this ResearcherCategoryImplementation
     * @return The list of states for this ResearcherCategoryImplementation
     */
    public List<com.codinginfinity.research.people.ResearchCategoryState> getStateIDs() { return this.states; }
    
    /**
     * memberVariables
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    BigInteger id;
    /**
     * The list of saved states of this ResearcherCategoryImplementation
     */
    @OneToMany(targetEntity = ResearchCategoryStateImplementation.class)
    private List<com.codinginfinity.research.people.ResearchCategoryState> states;
 }
