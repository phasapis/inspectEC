package eu.inspect.core.message;

import java.util.UUID;

/**
 *
 * @author panos
 */
public class ResponseMessageBase
{
    private String message;
    private UUID messageID;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getMessageID() {
        return messageID;
    }

    public void setMessageID(UUID messageID) {
        this.messageID = messageID;
    }
    
    
}
