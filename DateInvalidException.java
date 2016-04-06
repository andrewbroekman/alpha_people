package com.codinginfinity.research.people;


/**
 * Defines an Exception handler that is thrown when a given date should be
 * in a given range, yet is not
 * @author Renton Mcintyre (u14312710)
 */
public class DateInvalidException extends Exception {
    public DateInvalidException() {}
    public DateInvalidException(String message)
    {
        super(message);
    }
}
