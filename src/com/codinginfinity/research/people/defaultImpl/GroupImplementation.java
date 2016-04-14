package com.codinginfinity.research.people.defaultImpl;

import com.codinginfinity.research.people.GroupSuspendedException;
import com.codinginfinity.research.people.ResearchGroupAssociationType;
import javax.persistence.*;
import javax.persistence.Entity;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Research GroupImplementation type, defined as an Entity
 */
@javax.persistence.Entity
public class GroupImplementation implements com.codinginfinity.research.people.Group 
{
    /**
    *  Defines the no-args constructor for a Research GroupImplementation
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected GroupImplementation() {}
    
    /**
    * Defines the interface of the standard constructor for
    * an empty Research GroupImplementation
    * 
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
    * 
    * @param    name    The name of the research group
    * @param    members A list of the members already belonging to this group
    */
    public GroupImplementation(String name, List<com.codinginfinity.research.people.Entity> members)
    {
        this.name = name;
        this.members = members;
        isActive = true;
    }

    /**
     * Returns the ID of the group
     * 
     * @return Group's id
     */
    public BigInteger getId() 
    {
        return this.id;
    }

    /**
    * Defines a function that returns the name of this Research GroupImplementation
    * 
    * @return The name of the Research GroupImplementation
    */
    public String getName() { return this.name; }
    
    /**
    * Defines a function that returns the list of members 
    * associated with this group
    * 
    * @return The list of members in the Research GroupImplementation
    */
    public List<com.codinginfinity.research.people.Entity> getMembers()
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
        
        this.members.add(newMember);
    }
    
    /**
     * Removes the specified Entity from the group's list of members
     * 
     * @param member
     * @throws com.codinginfinity.research.people.GroupSuspendedException 
     */
    public void removeMember(com.codinginfinity.research.people.Entity member) throws com.codinginfinity.research.people.GroupSuspendedException
    {
        if(!isActive) throw new com.codinginfinity.research.people.GroupSuspendedException("The group is suspended and cannot be edited currently.");
        this.members.remove(member);
    }
    
    /**
     * Activates the group if it is inactive/suspended
     */    
    public void activateGroup()
    {
        isActive = true;
    }
    
    /**
     * Suspends the group's activities
     */
    public void suspendGroup()
    {
        isActive = false;
    }
    
    /**
     * Returns the group's active state
     * 
     * @return Group active state
     */
    public boolean getGroupState()
    {
        return isActive;
    }
    
    /**
     * Returns true if the entity is a member of the group.
     * False, otherwise.
     * 
     * @param member
     * @return If the entity is a member or not
     */
    public boolean isMember(com.codinginfinity.research.people.Entity member)
    {
        if(this.members.contains(member))
            return true;
        else
            return false;
    }
    
    /**
     * Checks if the entity is already a member of the group,
     * as multiple entries are not allowed
     * 
     * @param entity
     * @return If the person is a member of the group
     */
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
    @OneToMany
    private List<com.codinginfinity.research.people.Entity> members;
   
    
}
