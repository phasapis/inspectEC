package eu.inspect.core.security;

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
