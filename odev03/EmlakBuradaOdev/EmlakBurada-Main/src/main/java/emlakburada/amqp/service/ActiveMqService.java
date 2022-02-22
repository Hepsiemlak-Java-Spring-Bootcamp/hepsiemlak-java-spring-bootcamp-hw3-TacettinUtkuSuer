package emlakburada.amqp.service;

import emlakburada.model.EmailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class ActiveMqService implements QueueService {

	@Autowired
	private JmsTemplate activeTemplate;


	@Override
	public void sendMessage(EmailMessage message) {
			activeTemplate.convertAndSend("emlakburada.queue", message.getEmail());

	}

}
