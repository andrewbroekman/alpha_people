package com.codinginfinity.research.people;

/**
 * @author Renton Mcintyre (u14312710)
 */
import java.math.BigInteger;
import java.util.Date;

public interface ResearcherCategoryAssociation {
    BigInteger getId();

    Date getEffectiveDate();

    ResearcherCategory getCategory();
}
