package eu.inspect.jms;

import org.springframework.stereotype.Service;

/**
 *
 * @author panos
 */
@Service
public interface IMessagingService
{
    public void publishToTopic(String topicName, String msg);
}
