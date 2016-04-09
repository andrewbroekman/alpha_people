/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people.defaultImpl;

import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * 
 * Research GroupImplementation type, defined as an Entity
 */
@javax.persistence.Entity
public class GroupImplementation implements com.codinginfinity.research.people.Group {
    /**
    *  Defines the no-args constructor for a Research GroupImplementation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected GroupImplementation() {}
    
    /**
    * Defines the interface of the standard constructor for
    * an empty Research GroupImplementation
    * @param    name    The name of the research group
    */
    public GroupImplementation(String name)
    {
        this.members = new ArrayList<com.codinginfinity.research.people.Entity>();
        this.name = name;
    }
    
    /**
    * Defines the interface for a constructor to make a group already 
    * containing a list of members
    * @param    name    The name of the research group
    * @param    members A list of the members already belonging to this group
    */
    public GroupImplementation(String name, List<com.codinginfinity.research.people.Entity> members)
    {
        this.name = name;
        this.members = members;
    }


    public BigInteger getId() {
        return this.id;
    }

    /**
    * Defines a function that returns the name of this Research GroupImplementation
    * @return The name of the Research GroupImplementation
    */
    public String getName() { return this.name; }
    
    /**
    * Defines a function that returns the list of members 
    * associated with this group
    * @return The list of members in the Research GroupImplementation
    */
    public List<com.codinginfinity.research.people.Entity> getMembers()
    { 
        System.out.println(members.size());
        return this.members;
    }
    
    /**
     * 
    */
    public void addMember(com.codinginfinity.research.people.Entity newMember)
    { 
        this.members.add(newMember);
        //kry dan member in db en add association
        //addGroup?
    }

    public void removeMember(com.codinginfinity.research.people.Entity member)
    { 
        this.members.remove(member);
        //kry dan member in db en add association
    }

    /*
     * Member variables:
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
    /**
     * The name of the Research GroupImplementation
     */
    @Basic
    private String name;
  
    /**
    * The list of members that belong to this group, of type Entity
    */
    @OneToMany
    private List<com.codinginfinity.research.people.Entity> members;
    
}
