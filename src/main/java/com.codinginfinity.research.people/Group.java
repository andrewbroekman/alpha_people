/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import java.util.ArrayList;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * 
 * Research Group type, defined as an Entity
 */
public class Group implements Entity {
    /**
    *  Defines the no-args constructor for a Research Group
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected Group() {}
    
    /**
    * Defines the interface of the standard constructor for
    * an empty Research Group
    * @param    name    The name of the research group
    */
    public Group(String name)
    {
        members = new ArrayList<Entity>();
        this.name = name;
    }
    
    /**
    * Defines the interface for a constructor to make a group already 
    * containing a list of members
    * @param    name    The name of the research group
    * @param    members A list of the members already belonging to this group
    */
    public Group(String name, ArrayList<Entity> members)
    {
        members = new ArrayList<Entity>();
        this.name = name;
        this.members = members;
    }
    
    /**
    * Defines a function that returns the name of this Research Group
    * @return The name of the Research Group
    */
    public String getName() { return this.name; }
    
    /**
    * Defines a function that returns the list of members 
    * associated with this group
    * @return The list of members in the Research Group
    */
    public ArrayList<Entity> getMembers() { return this.members; }
    



    /*
     * Member variables:
     */
    
    /**
     * The name of the Research Group
     */
    private String name;
  
    /**
    * The list of members that belong to this group, of type Entity
    */
    private ArrayList<Entity> members;
    
}
