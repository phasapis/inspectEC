/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.projects.core.security;

/**
 *
 * @author panos
 */
public interface IAuthenticationMechanism {
    boolean authenticate(String userID, String tokenID);
}
