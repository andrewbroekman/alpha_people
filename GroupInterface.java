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
public interface GroupInterface 
{
    BigInteger getId();
    
    String getName();
    
    List<Person> getMembers();
    
    void addMember(Person newMember);
    
    void removeMember(Person member);
}
