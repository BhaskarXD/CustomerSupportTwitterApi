package proj.bhaskar.CustomerSupportTwitterApi.mongoservice;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.UserDocument;
import proj.bhaskar.CustomerSupportTwitterApi.mongorepository.TweetUserRepository;

import java.util.List;

@Service
public class TweetUserService {

    @Autowired
    private TweetUserRepository userRepository;

    public List<UserDocument> allUsers() {
        return userRepository.findAll();
    }

    public UserDocument userByAuthorId(String authorId) {

        return userRepository.findUserByAuthorId(authorId);
    }

    public UserDocument saveUser(UserDocument userDocument){
        return userRepository.save(userDocument);
    }

}