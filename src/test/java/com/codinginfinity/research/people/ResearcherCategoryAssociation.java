package com.codinginfinity.research.people;

import java.math.BigInteger;
import java.util.Date;

public interface ResearcherCategoryAssociation {
    BigInteger getId();

    Date getEffectiveDate();

    ResearcherCategory getCategory();
}
