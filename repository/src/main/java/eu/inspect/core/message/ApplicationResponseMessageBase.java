package eu.inspect.core.message;

import eu.inspect.core.messages.types.ApplicationServerResponseTypes;
import java.util.UUID;

/**
 *
 * @author panos
 */
public class ApplicationResponseMessageBase
{
    private ApplicationServerResponseTypes message;
    private UUID messageID;

    public ApplicationServerResponseTypes getMessage() {
        return message;
    }

    public void setMessage(ApplicationServerResponseTypes message) {
        this.message = message;
    }
        
    public UUID getMessageID() {
        return messageID;
    }

    public void setMessageID(UUID messageID) {
        this.messageID = messageID;
    }
    
    
}
