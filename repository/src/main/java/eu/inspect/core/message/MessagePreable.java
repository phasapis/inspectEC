package eu.inspect.core.message;

import eu.inspect.core.messages.types.MessageType;
import eu.inspect.core.messages.types.OriginatingService;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author panos
 */
public class MessagePreable {
    
    private UUID userID;
    private String username;
    private Date timestap;
    private MessageType messageType;
    private OriginatingService originatingService;

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimestap() {
        return timestap;
    }

    public void setTimestap(Date timestap) {
        this.timestap = timestap;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public OriginatingService getOriginatingService() {
        return originatingService;
    }

    public void setOriginatingService(OriginatingService originatingService) {
        this.originatingService = originatingService;
    }
    
    
}
