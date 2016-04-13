package com.codinginfinity.research.people;


import com.codinginfinity.research.people.defaultImpl.GroupImplementation;
import com.codinginfinity.research.people.defaultImpl.PersonImplementation;
import com.codinginfinity.research.people.defaultImpl.ResearcherCategoryImplementation;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Muller
 */


public class NewClass
{
    static PersonImplementation examplePersonA, examplePersonB, examplePersonC;
    static GroupImplementation exampleGroup;
    static ResearcherCategoryImplementation exampleCategory;
    
    public static void main(String args[]) throws InvalidEmailException, GroupSuspendedException, UnauthorizedUserExeption, NonMemberExeption 
    {
        examplePersonA = new PersonImplementation("firstName", "surname", "primaryEmail@x.com");
        examplePersonB = new PersonImplementation("b", "b", "b@x.com");
        examplePersonC = new PersonImplementation("c", "c", "c@x.com");
        examplePersonA.setAsAdmin();
        
        exampleGroup = new GroupImplementation("group");
        
        examplePersonA.addMemberToGroup(examplePersonB, exampleGroup, ResearchGroupAssociationType.GROUPLEADER);
        
        examplePersonB.addMemberToGroup(examplePersonC, exampleGroup, ResearchGroupAssociationType.STUDENT);
        
        //examplePersonA.addMemberToGroup(examplePersonB, exampleGroup, ResearchGroupAssociationType.STUDENT);
        
        System.out.println(examplePersonC);
        System.out.println(exampleGroup.getMembers());
        
        
        
    }
    
}
