/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

/**
 * A Basic user type with normal levels of access
 * @author Renton Mcintyre (u14312710)
 */
public class BasicUser implements User 
{
    public void addPerson(String firstName, String surname, EmailAddress primaryEmail)
    {
        Person person = new Person(firstName, surname, primaryEmail);
    }
    
    public void addPerson(String firstName, String surname, EmailAddress primaryEmail, User user)
    {
        Person person = new Person(firstName, surname, primaryEmail, user);
    }
    
}
