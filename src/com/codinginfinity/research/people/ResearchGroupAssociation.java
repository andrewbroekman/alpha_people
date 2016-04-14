package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface ResearchGroupAssociation
{
    BigInteger getId();
    
     /**
     * Returns the GroupImplementation in the association
     * @return  The GroupImplementation in the association
     */
    Group getGroup();

     /**
     * Returns the date upon which the association started
     * @return  The Start date for the association
     */
    Date getStartDate();
    
    /**
     * Returns the date upon which the association ended
     * @return  The End date of the association
     */
    Date getEndDate();

    /**
     * Returns the type of this association
     * @return The type of association this is
     */
    ResearchGroupAssociationType getType();
    
}
