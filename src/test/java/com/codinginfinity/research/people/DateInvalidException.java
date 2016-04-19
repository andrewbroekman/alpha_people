/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.research.people;


/**
 * Defines an Exception handler that is thrown when a given date should be
 * in a given range, yet is not
 */
public class DateInvalidException extends Exception {
    public DateInvalidException() {}
    public DateInvalidException(String message)
    {
        super(message);
    }
}
