/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.projects.core.security;

import org.springframework.stereotype.Service;

/**
 *
 * @author panos
 */

@Service
public class AuthenticationMechanism 
implements IAuthenticationMechanism
{
    public boolean authenticate(String userID, String tokenID)
    {
        return true;
    }            
}
