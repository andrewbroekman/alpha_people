
import com.codinginfinity.research.people.Entity;
import com.codinginfinity.research.people.InvalidEmailException;
import com.codinginfinity.research.people.Person;
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
    
    public static void main(String args[]) 
    {
        PersonImplementation examplePerson;
        try {
            examplePersonA = new PersonImplementation("A", "A", "test@test.com");
            examplePersonB = new PersonImplementation("B", "B", "test@test.com");
            examplePersonC = new PersonImplementation("C", "C", "test@test.com");

        }catch(InvalidEmailException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println(examplePersonA.getFirstName());
        System.out.println(examplePersonB.getFirstName());
        System.out.println(examplePersonC.getFirstName());
        
        ArrayList<Entity> peopleList = new ArrayList<Entity>();
        peopleList.add(examplePersonA);
        peopleList.add(examplePersonB);
        peopleList.add(examplePersonC);
        
        
        examplePerson = (PersonImplementation) peopleList.get(2);
        System.out.println(examplePerson.getFirstName());
        
        System.out.println(peopleList.size());
        
        exampleGroup = new GroupImplementation("GroupImplementation", peopleList);
        
        System.out.println(exampleGroup.getMembers());
    }
    
}
