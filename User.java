package com.codinginfinity.research.people;

import javax.persistence.*;
import java.math.BigInteger;

public interface User {
    public void addPerson(String firstName, String surname, String primaryEmail) throws InvalidEmailException;
    public void addPerson(String firstName, String surname,String primaryEmail, BigInteger user) throws InvalidEmailException;


}
