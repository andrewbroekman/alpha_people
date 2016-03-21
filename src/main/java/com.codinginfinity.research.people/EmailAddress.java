/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */

/**
 * A class that defines an EmailAddress (which is valid). 
 */

public class EmailAddress {
    /**
    *  Defines the no-args constructor for an EmailAddress
    *  Protected, as it should not be used
    *  (especially not outside of the people package)
    */
    protected EmailAddress() {}
    
    /**
    * Defines the interface of the standard constructor for
    * an EmailAddress.
    * @param    address The text representation of email address
    * @throws InvalidEmailException  Will throw an error if the given string is not a valid email
    */
    public EmailAddress(String address) throws InvalidEmailException
    {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(address.matches(EMAIL_REGEX))
            this.address = address;
        else throw new InvalidEmailException(address + " is not a valid email address.");
    }
    
    /**
     * Returns the text representation of the email  address
     * @return The string representing the email address
     */
    public String getAddress() { return this.address; }
    
    /* 
    *   Member variables
    */
    
    /**
     * The actual text representation of an EmailAddress
     */
    private String address;
}
