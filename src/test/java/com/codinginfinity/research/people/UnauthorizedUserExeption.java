package com.codinginfinity.research.people;

public class UnauthorizedUserExeption extends Exception {
    public UnauthorizedUserExeption() {}
    public UnauthorizedUserExeption(String message){ super(message); }
}
