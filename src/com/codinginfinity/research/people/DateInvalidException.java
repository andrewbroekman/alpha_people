package com.codinginfinity.research.people;

/**
 * Defines an Exception handler that is thrown when a given date is
 * outside a given range
 */
public class DateInvalidException extends Exception {
    public DateInvalidException() {}
    public DateInvalidException(String message)
    {
        super(message);
    }
}
