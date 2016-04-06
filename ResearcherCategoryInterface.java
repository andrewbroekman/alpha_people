package com.codinginfinity.research.people;

import java.util.List;

public interface ResearcherCategoryInterface 
{
    void addState(ResearchCategoryState stateID);
    
    List<ResearchCategoryState> getStatIDs();  
}
