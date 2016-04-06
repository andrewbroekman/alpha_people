package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface ResearchGroupAssociationInterface 
{
    BigInteger getId();
    
    Group getGroup();

    Date getStartDate();
    
    Date getEndDate();

    ResearchGroupAssociationType getType();
    
}
