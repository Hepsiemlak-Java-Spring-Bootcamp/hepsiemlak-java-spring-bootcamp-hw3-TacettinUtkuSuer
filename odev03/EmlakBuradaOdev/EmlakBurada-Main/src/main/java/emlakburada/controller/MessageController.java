package emlakburada.controller;


import emlakburada.dto.request.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping(value = "/messages")
    public ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest request) {
        return new ResponseEntity<>(messageService.saveMessage(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/messages")
    public ResponseEntity<List<MessageResponse>> getAllMessage() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/messages/{messageId}")
    public ResponseEntity<MessageResponse> getUserByMessageId(@PathVariable(required = false) int messageId) {
        return new ResponseEntity<>(messageService.findOne(messageId), HttpStatus.OK);
    }

}
