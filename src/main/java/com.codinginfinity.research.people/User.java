/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * An object that has the ability to add and remove things in database
 */
public interface User {
    public void addPerson(String firstName, String surname, String primaryEmail) throws InvalidEmailException;
    public void addPerson(String firstName, String surname,String primaryEmail, BigInteger user) throws InvalidEmailException;


}
