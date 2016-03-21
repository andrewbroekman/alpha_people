/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * A Basic user type with normal levels of access
 * @author Renton Mcintyre (u14312710)
 */
@javax.persistence.Entity
public class BasicUser implements User 
{
    public void addPerson(String firstName, String surname, String primaryEmail) throws InvalidEmailException
    {
        Person person = new Person(firstName, surname, primaryEmail);
    }

    public void addPerson(String firstName, String surname, String primaryEmail, BigInteger user) throws InvalidEmailException
    {
        Person person = new Person(firstName, surname, primaryEmail, user);
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
}
