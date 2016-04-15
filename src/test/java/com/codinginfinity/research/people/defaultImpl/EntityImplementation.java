package com.codinginfinity.research.people.defaultImpl;

import java.math.BigInteger;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
public class EntityImplementation implements com.codinginfinity.research.people.Entity
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private BigInteger id;
}
