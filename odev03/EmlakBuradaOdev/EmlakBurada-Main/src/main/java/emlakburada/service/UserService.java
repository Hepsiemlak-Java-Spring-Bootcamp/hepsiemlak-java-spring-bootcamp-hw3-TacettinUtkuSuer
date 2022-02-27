package emlakburada.service;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	private static int userId = 4;

	public UserResponse saveUser(UserRequest userRequest){
		User savedUser = userRepository.saveUser(convertToUser(userRequest));
		return convertToUserResponse(savedUser);
	}

	public List<UserResponse> findAll(){
		List<UserResponse> userList = new ArrayList<>();
		for (User user : userRepository.fetchAllUsers()) {
			userList.add(convertToUserResponse(user));
		}
		return userList;
	}

	public UserResponse findOne(int userId){
		User user = findUserByUserId(userId);
		return convertToUserResponse(user);
	}

	private UserResponse convertToUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setIsim(user.getIsim());
		response.setEmail(user.getEmail());
		response.setUserId(user.getUserId());
		return response;
	}

	private User convertToUser(UserRequest request) {
		User user = new User();
		userId++;
		user.setIsim(request.getIsim());
		user.setEmail(request.getEmail());
		user.setUserId(userId);
		return user;
	}

	public User findUserByUserId(int userId) {
		return userRepository.fetchAllUsers().stream().filter(user -> user.getUserId() == userId).findAny().orElse(new User());
	}


}
