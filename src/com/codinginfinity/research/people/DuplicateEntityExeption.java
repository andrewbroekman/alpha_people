package com.codinginfinity.research.people;

/**
 * Defines an Exception handler that is thrown when an attempt
 * is made to add a duplicate entity to a list
 */
public class DuplicateEntityExeption extends Exception 
{
    public DuplicateEntityExeption() {}
    public DuplicateEntityExeption(String message)
    { 
        super(message); 
    }
}