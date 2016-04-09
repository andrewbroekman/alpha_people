package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface ResearchGroupAssociation
{
    BigInteger getId();
    
    Group getGroup();

    Date getStartDate();
    
    Date getEndDate();

    ResearchGroupAssociationType getType();
    
}
