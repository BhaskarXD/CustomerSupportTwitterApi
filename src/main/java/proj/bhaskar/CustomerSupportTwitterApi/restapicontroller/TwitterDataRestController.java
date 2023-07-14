package proj.bhaskar.CustomerSupportTwitterApi.restapicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.TweetDocument;
import proj.bhaskar.CustomerSupportTwitterApi.mongoservice.TweetDataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweets")
public class TwitterDataRestController {
    @Autowired
    private TweetDataService tweetService;
    @GetMapping
    public ResponseEntity<List<TweetDocument>> getAllTweets(){
//        return new ResponseEntity<TweetDocumentClass>(new TweetDocumentClass(new ObjectId(),1, LocalDateTime.now(),1,1,"lol",1), HttpStatus.OK);
        List<TweetDocument> curList= tweetService.allTweets();
//        System.out.println("inside restController class : "+curList.get(0));
        return new ResponseEntity<List<TweetDocument>>(curList,HttpStatus.OK);
    }

    @GetMapping("/{tweetId}")
    ResponseEntity<TweetDocument> getTweetByTweetId(@PathVariable Integer tweetId){
        return new ResponseEntity<TweetDocument>(tweetService.tweetByTweetId(tweetId),HttpStatus.OK);
    }

    @PostMapping("/reply")
    ResponseEntity<TweetDocument> replyToTweetId(@RequestBody TweetDocument tweetDocument){
        return new ResponseEntity<TweetDocument>(tweetService.replyToTweet(tweetDocument),HttpStatus.CREATED);
    }

    @PostMapping("/tweet")
    ResponseEntity<TweetDocument> postTweetByAuthorId(@RequestBody TweetDocument tweetDocument){
        return new ResponseEntity<TweetDocument>(tweetService.addNewTweet(tweetDocument), HttpStatus.CREATED);
    }

    @GetMapping("/by-company/{companyName}")
    ResponseEntity<List<TweetDocument>> getTweetsContainingCompanyName(@PathVariable String companyName){
        return new ResponseEntity<List<TweetDocument>>(tweetService.findTweetsContainingComapnyName(companyName),HttpStatus.OK);
    }

}

//@Repository
//class myrepo{
//    @Autowired
//    TweetDocumentClass curdoc;
//    TweetDocumentClass getdoc(){
//        return curdoc;
//    }
//}
