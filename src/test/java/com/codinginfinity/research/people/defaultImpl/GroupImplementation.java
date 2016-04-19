/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people.defaultImpl;

import com.codinginfinity.research.people.Entity;
import com.codinginfinity.research.people.GroupSuspendedException;
import com.codinginfinity.research.people.Person;
import com.codinginfinity.research.people.ResearchGroupAssociationType;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
        isActive = true;
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
        isActive = true;
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
    public List<Entity> getMembers()
    { 
        return this.members;
    }
    
    /**
     * Adds an Entity to the group's members list. This can be used for Group entities
     * 
     * @param newMember
     * @throws com.codinginfinity.research.people.GroupSuspendedException
     */
    public void addMember(com.codinginfinity.research.people.Entity newMember) throws com.codinginfinity.research.people.GroupSuspendedException
    {
        if(!isActive) 
            throw new com.codinginfinity.research.people.GroupSuspendedException("The group is suspended and cannot be edited currently.");
        
        this.members.add((Person) newMember);
    }
    
    public void removeMember(com.codinginfinity.research.people.Entity member) throws com.codinginfinity.research.people.GroupSuspendedException
    {
        if(!isActive) throw new com.codinginfinity.research.people.GroupSuspendedException("The group is suspended and cannot be edited currently.");
        this.members.remove(member);
    }
    
    public void memberQuits(com.codinginfinity.research.people.Entity member) throws com.codinginfinity.research.people.GroupSuspendedException
    {
        if(!isActive) throw new com.codinginfinity.research.people.GroupSuspendedException("The group is suspended and cannot be edited currently.");
        this.members.remove(member);
    }
    
    public void activateGroup()
    {
        isActive = true;
    }
    
    public void suspendGroup()
    {
        isActive = false;
    }
    
    public boolean getGroupState()
    {
        return isActive;
    }
    
    public boolean isMember(com.codinginfinity.research.people.Entity member)
    {
        if(this.members.contains(member))
            return true;
        else
            return false;
    }
    
    public boolean containsDuplicate(com.codinginfinity.research.people.Entity entity)
    {
        if(members.contains(entity))
            return true;
        else        
            return false;
    }

    /*
     * Member variables:
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
    /**
     * The name of the Research Group
    */
    @Basic
    private String name;
    
    /**
    * The current status of the Research Group (active/inactive)
    */
    @Basic
    private Boolean isActive;
  
    /**
    * The list of members that belong to this group, of type Entity
    */
    @OneToMany(targetEntity = EntityImplementation.class)
    private List<com.codinginfinity.research.people.Entity> members;
   
    
}
