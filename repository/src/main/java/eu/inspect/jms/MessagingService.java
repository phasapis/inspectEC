package eu.inspect.jms;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.util.FileSystemUtils;

/**
 *
 * @author panos
 */
@Component
@EnableJms
public class MessagingService
implements IMessagingService
{
    @Autowired
    private ApplicationContext ctx;

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        factory.setReplyPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("intl-89890");
        return factory;
    }
        
    @Override
    public void publishToTopic(String topicName, String msg)
    {
        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        MessageCreator messageCreator = new MessageCreator() {
        @Override
        public Message createMessage(Session session) throws JMSException {
            return session.createTextMessage(msg);
            }
        };

        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);
        Logger.getLogger(MessagingService.class.getName()).log(Level.INFO, "Sending message down the topic");
        jmsTemplate.send(topicName, messageCreator);        
    }    
}
