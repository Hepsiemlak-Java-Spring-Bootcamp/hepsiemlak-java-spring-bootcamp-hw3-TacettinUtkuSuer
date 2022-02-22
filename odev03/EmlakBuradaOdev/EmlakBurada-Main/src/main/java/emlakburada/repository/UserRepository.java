package emlakburada.repository;

import emlakburada.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepository {

    private static List<User> userList = new ArrayList<>();

    static {
        Set<Integer> favoriIlans = new HashSet<>();
        favoriIlans.add(38164780);
        favoriIlans.add(38164781);
        userList.add(prepareUser("Ayşe", "ayse@pat.dev",1, favoriIlans));
        Set<Integer> favoriIlans2 = new HashSet<>();
        favoriIlans2.add(38164780);
        favoriIlans2.add(38164781);
        favoriIlans2.add(38164782);
        userList.add(prepareUser("Fatma", "fatma@pat.dev",2, favoriIlans2));
        Set<Integer> favoriIlans3 = new HashSet<>();
        favoriIlans3.add(38164780);
        favoriIlans3.add(38164782);
        userList.add(prepareUser("Hayriye", "hayriye@pat.dev",3, favoriIlans3));
        Set<Integer> favoriIlans4 = new HashSet<>();
        favoriIlans4.add(38164783);
        userList.add(prepareUser("Mehmet", "mehmet@pat.dev",4, favoriIlans4));
    }

    public List<User> fetchAllUsers() {
        return userList;
    }

    private static User prepareUser(String isim, String email, int userId, Set<Integer> favoriIlanlar) {
        User user = new User();
        user.setIsim(isim);
        user.setEmail(email);
        user.setUserId(userId);
        user.setFotograf("https://hecdnw01.hemlak.com/ds01/4/4/9/0/2/3/8/3/81d2e088-a551-485d-b2e9-664cc9200cdc.jpg");
        user.setBiyografi("bio");
        user.setFavoriIlanlar(favoriIlanlar);
        return user;
    }

    public User saveUser(User user) {
        userList.add(user);
        System.out.println(user.toString());
        return user;
    }


}
