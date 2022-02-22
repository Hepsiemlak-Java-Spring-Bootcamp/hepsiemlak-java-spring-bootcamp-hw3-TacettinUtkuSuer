package emlakburada.amqp.service;

import emlakburada.model.EmailMessage;

public interface QueueService {
	
	void sendMessage(EmailMessage email);

}
