/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codinginfinity.people;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Renton Mcintyre (u14312710)
 */
@Stateless
@LocalBean
public enum ResearchGroupAssociationType {
    STUDENT, COLLABORATOR, MEMBER, GROUPLEADER
}
