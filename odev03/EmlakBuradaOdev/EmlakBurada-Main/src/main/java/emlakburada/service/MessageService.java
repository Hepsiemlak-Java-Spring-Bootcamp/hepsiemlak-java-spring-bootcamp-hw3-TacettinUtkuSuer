package emlakburada.service;


import emlakburada.dto.request.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {


    @Autowired
    private MessageRepository messageRepository;

    private static int messageId = 4;

    public MessageResponse saveMessage(MessageRequest messageRequest){
        Message savedMessage = messageRepository.saveMessage(convertToMessage(messageRequest));
        return convertToMessageResponse(savedMessage);
    }

    public List<MessageResponse> findAll(){
        List<MessageResponse> messageList = new ArrayList<>();
        for (Message message : messageRepository.fetchAllMessages()) {
            messageList.add(convertToMessageResponse(message));
        }
        return messageList;
    }

    public MessageResponse findOne(int messageId){
        Message message = findMessageByMessageId(messageId);
        return convertToMessageResponse(message);
    }

        // -----------------------------------------------------------------------------------------------------------------------------
    private MessageResponse convertToMessageResponse(Message message) {
        MessageResponse response = new MessageResponse();
        response.setBaslik(message.getBaslik());
        response.setIcerigi(message.getIcerigi());
        response.setAliciId(message.getAliciId());
        response.setGondericiId(message.getGondericiId());
        response.setMessageId(message.getMessageId());
        return response;
    }

    private Message convertToMessage(MessageRequest request) {
        Message message = new Message();
        messageId++;
        message.setBaslik(request.getBaslik());
        message.setIcerigi(request.getIcerigi());
        message.setAliciId(request.getAliciId());
        message.setGondericiId(request.getGondericiId());
        message.setMessageId(messageId);
        return message;
    }

    public Message findMessageByMessageId(int messageId) {
        return messageRepository.fetchAllMessages().stream().filter(message -> message.getMessageId() == messageId).findAny().orElse(new Message());
    }

}
