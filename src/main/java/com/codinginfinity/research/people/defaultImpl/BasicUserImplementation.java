/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people.defaultImpl;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * A Basic user type with normal levels of access
 */
@javax.persistence.Entity
public class BasicUserImplementation implements com.codinginfinity.research.people.User
{
    public void addPerson(String firstName, String surname, String primaryEmail) throws com.codinginfinity.research.people.InvalidEmailException
    {
        PersonImplementation person = new PersonImplementation(firstName, surname, primaryEmail);
    }

    public void addPerson(String firstName, String surname, String primaryEmail, BigInteger user) throws com.codinginfinity.research.people.InvalidEmailException
    {
        PersonImplementation person = new PersonImplementation(firstName, surname, primaryEmail, user);
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
}
