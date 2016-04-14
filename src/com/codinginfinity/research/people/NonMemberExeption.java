package com.codinginfinity.research.people;

/**
 * Defines an Exception handler that is thrown when a 
 * non-admin attempts to make changes ti a group that 
 * they are not part of
 */
public class NonMemberExeption extends Exception 
{
    public NonMemberExeption() {}
    public NonMemberExeption(String message)
    { 
        super(message); 
    }
}