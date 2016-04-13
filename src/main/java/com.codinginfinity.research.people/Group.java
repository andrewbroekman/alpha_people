/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.List;

public interface Group extends Entity
{
    BigInteger getId();
    
    String getName();
    
    public List<Entity> getMembers();
    
    void addMember(Entity newMember) throws GroupSuspendedException;
    
    void removeMember(Entity member) throws GroupSuspendedException;
    
    void memberQuits(Entity member) throws GroupSuspendedException;
    
    void activateGroup();
    
    void suspendGroup();
    
    boolean getGroupState();
    
    boolean isMember(Entity member);
}
