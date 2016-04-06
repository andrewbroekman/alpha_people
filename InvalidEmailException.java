package com.codinginfinity.research.people;


/**
 * Defines an InvalidEmailException used to identify a case when an invalid
 * email has been given
 */

public class InvalidEmailException extends Exception {
    public InvalidEmailException() {}
    public InvalidEmailException(String message)
    {
        super(message);
    }
}
