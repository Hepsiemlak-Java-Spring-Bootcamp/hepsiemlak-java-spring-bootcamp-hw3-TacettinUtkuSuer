package emlakburada.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

    @Component
    @Slf4j
    public class ActiveMqListenerService {

        @Autowired
        private EmailService emailService;

        private static final Logger LOGGER =
                LoggerFactory.getLogger(ActiveMqListenerService.class);

        @Value("${destination.status1}")
        private String status1Destination;

        @Value("${destination.status2}")
        private String status2Destination;

        @Autowired
        JmsTemplate jmsTemplate;

        @JmsListener(destination = "${destination.order}", containerFactory = "orderDefaultJmsListenerContainerFactory")
        public void receiveOrder(String order) {
            // LOGGER.info("received order='{}'", order);
            emailService.send(order);
            jmsTemplate.convertAndSend(status1Destination, order);
            jmsTemplate.convertAndSend(status2Destination, order);
        }
    }
