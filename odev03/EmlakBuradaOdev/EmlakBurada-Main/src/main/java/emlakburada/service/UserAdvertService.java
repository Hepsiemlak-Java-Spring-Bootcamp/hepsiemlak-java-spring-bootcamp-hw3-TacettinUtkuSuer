package emlakburada.service;

import emlakburada.dto.response.FavoriIlanlarResponse;
import emlakburada.model.User;
import emlakburada.repository.AdvertRepository;
import emlakburada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserAdvertService {
    @Autowired
    private AdvertRepository advertRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertService advertService;

    public FavoriIlanlarResponse getAdvertIdByUserId(int userId) {
        User user = userService.findUserByUserId(userId);
        return convertToFavoriIlanlarResponse(user);
    }

    private FavoriIlanlarResponse convertToFavoriIlanlarResponse(User user) {
        FavoriIlanlarResponse response = new FavoriIlanlarResponse();
        Set<String> ara = new HashSet<>();
        for (int i : user.getFavoriIlanlar()) {
                ara.add(advertRepository.findAdvertByAdvertId(i).getBaslik());
        }
        response.setBaslik(ara);
        return response;
    }


}
