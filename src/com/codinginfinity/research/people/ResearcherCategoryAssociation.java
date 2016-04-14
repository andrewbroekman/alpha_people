package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface ResearcherCategoryAssociation 
{
    BigInteger getId();
    
    /**
     * Returns the effective date of this association
     * @return The effective date belonging to this association
     */
    Date getEffectiveDate();

    /**
     * Returns the research category for this association
     * @return The research category belonging to this association
     */
    ResearcherCategory getCategory();

}
