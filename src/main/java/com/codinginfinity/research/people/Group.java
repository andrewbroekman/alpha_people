/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Muller
 */
public interface Group extends Entity
{
    BigInteger getId();
    
    String getName();
    
    public List<Entity> getMembers();
    
    void addMember(Entity newMember);
    
    void removeMember(Entity member);
}
