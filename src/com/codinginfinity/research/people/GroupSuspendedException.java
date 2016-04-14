package com.codinginfinity.research.people;

/**
 * Defines an Exception handler that is thrown when an
 * attempt is made to use a group's functions, while
 * it is still being suspended
 */
public class GroupSuspendedException extends Exception 
{
    public GroupSuspendedException() {}
    public GroupSuspendedException(String message)
    { 
        super(message); 
    }
}
