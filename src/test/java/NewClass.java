
import com.codinginfinity.research.people.Entity;
import com.codinginfinity.research.people.Group;
import com.codinginfinity.research.people.Person;
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
    static com.codinginfinity.research.people.Person examplePersonA, examplePersonB, examplePersonC;
    static com.codinginfinity.research.people.Group exampleGroup;
    static com.codinginfinity.research.people.ResearcherCategory exampleCategory;
    
    public static void main(String args[]) 
    {
        examplePersonA = new Person("A", "A", null);
        examplePersonB = new Person("B", "B", null);
        examplePersonC = new Person("C", "C", null);
        
        Person examplePerson = new Person(null, null, null);
        
        
        System.out.println(examplePersonA.getFirstName());
        System.out.println(examplePersonB.getFirstName());
        System.out.println(examplePersonC.getFirstName());
        
        ArrayList<Entity> peopleList = new ArrayList<Entity>();
        peopleList.add(examplePersonA);
        peopleList.add(examplePersonB);
        peopleList.add(examplePersonC);
        
        
        examplePerson = (Person) peopleList.get(2);
        System.out.println(examplePerson.getFirstName());
        
        System.out.println(peopleList.size());
        
        exampleGroup = new Group("Group", peopleList);
        
        System.out.println(exampleGroup.getMembers());
    }
    
}
