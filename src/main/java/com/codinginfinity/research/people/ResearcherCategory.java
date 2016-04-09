package com.codinginfinity.research.people;

import java.util.List;

public interface ResearcherCategory
{
    void addState(ResearchCategoryState stateID);
    
    List<ResearchCategoryState> getStatIDs();  
}
