package proj.bhaskar.CustomerSupportTwitterApi.restapicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.UserDocument;
import proj.bhaskar.CustomerSupportTwitterApi.mongoservice.TweetUserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class TwitterUserRestController {
    @Autowired
    private TweetUserService userService;
    @GetMapping
    public List<UserDocument> getAllUsers(){
        return userService.allUsers();
    }

    @GetMapping("/{authorId}")
    public  UserDocument getUserByAuthorId(@PathVariable String authorId){
        return userService.userByAuthorId(authorId);
    }

    @PostMapping
    public UserDocument saveUser(@RequestBody UserDocument userDocument){

        return userService.saveUser(userDocument);
    }

}
