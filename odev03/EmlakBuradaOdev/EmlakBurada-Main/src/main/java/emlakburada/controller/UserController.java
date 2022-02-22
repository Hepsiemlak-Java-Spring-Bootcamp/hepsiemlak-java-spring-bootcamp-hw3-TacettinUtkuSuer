package emlakburada.controller;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.saveUser(request), HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserResponse>> getAllUser() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<UserResponse> getUserByUserId(@PathVariable(required = false) int userId) {
        return new ResponseEntity<>(userService.findOne(userId), HttpStatus.OK);
    }

}
