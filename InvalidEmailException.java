/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 * Defines an InvalidEmailException used to identify a case when an invalid
 * email has been given
 * @author Renton Mcintyre (u14312710)
 */
@Stateless
@LocalBean
public class InvalidEmailException extends Exception {
    public InvalidEmailException() {}
    public InvalidEmailException(String message)
    {
        super(message);
    }
}
