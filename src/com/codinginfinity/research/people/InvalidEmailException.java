package com.codinginfinity.research.people;

/**
 * Defines an Exception handler that is thrown when an
 * invalid email address has been given
 */
public class InvalidEmailException extends Exception {
    public InvalidEmailException() {}
    public InvalidEmailException(String message)
    {
        super(message);
    }
}
