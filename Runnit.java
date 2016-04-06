package com.codinginfinity.research.people;

public class Runnit 
{
    public static void main (String args[]) throws InvalidEmailException
	{
            EmailAddress ea = new EmailAddress("2@1.com");
            
            EmailAddressInterface  em = (EmailAddressInterface) ea; 
            
            System.out.println(em.getAddress());
            
            Group g = new Group("Group1");
            GroupInterface gi = (GroupInterface) g;
            
            System.out.println(gi.getName());
            
            Group g2 = new Group("Group2");
            GroupInterface gi2 = (GroupInterface) g2;
            
            System.out.println(gi2.getName());

	}
    
}
