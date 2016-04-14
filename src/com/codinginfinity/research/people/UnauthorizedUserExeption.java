package com.codinginfinity.research.people;

/**
 * Defines an Exception handler that is thrown when an
 * attempt is made to use a group's functions, by a non-Admin
 * or a member who is not the group leader
 */
public class UnauthorizedUserExeption extends Exception {
    public UnauthorizedUserExeption() {}
    public UnauthorizedUserExeption(String message)
    { 
        super(message); 
    }
}
