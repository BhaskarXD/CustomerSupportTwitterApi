package proj.bhaskar.CustomerSupportTwitterApi.mongoservice;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.TweetDocument;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.UserDocument;
import proj.bhaskar.CustomerSupportTwitterApi.mongorepository.SearchTweetsRepository;
import proj.bhaskar.CustomerSupportTwitterApi.mongorepository.TweetDataRepository;
import proj.bhaskar.CustomerSupportTwitterApi.mongorepository.TweetUserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TweetDataService {
    private TweetDataRepository tweetRepository;
    private TweetUserRepository tweetUserRepository;

    private SearchTweetsRepository searchTweetsRepository;
    private static int topTweetId;

    public TweetDataService(TweetDataRepository tweetRepository, TweetUserRepository tweetUserRepository, SearchTweetsRepository searchTweetsRepository) {
        this.tweetRepository = tweetRepository;
        this.tweetUserRepository = tweetUserRepository;
        this.searchTweetsRepository=searchTweetsRepository;
        topTweetId=tweetRepository.findTopByOrderByTweetIdDesc().getTweetId()+1;
        System.out.println("current top tweet id : "+topTweetId);
    }

    public List<TweetDocument> allTweets(){
        List<TweetDocument> curReq= tweetRepository.findAll();
//        System.out.println("inside service class :"+ curReq.get(0));
        return curReq;
    }

    public TweetDocument tweetByTweetId(int tweetId){
        return tweetRepository.findTweetByTweetId(tweetId);
    }

    public TweetDocument replyToTweet(TweetDocument tweetDocument){
        Integer curTweetId=++topTweetId;
        TweetDocument responseToTweetDocument= tweetRepository.findTweetByTweetId(tweetDocument.getInResponseToTweetId());
        if(responseToTweetDocument!=null){
            responseToTweetDocument.getResponseTweetId().add(curTweetId);
            tweetRepository.save(responseToTweetDocument);
        }
        UserDocument authorUserDocument = tweetUserRepository.findUserByAuthorId(tweetDocument.getAuthorId());
        if(authorUserDocument!=null){
            authorUserDocument.getAuthorTweets().add(curTweetId);
            tweetUserRepository.save(authorUserDocument);
        }

        tweetDocument.setTweetId(curTweetId);
        return tweetRepository.save(tweetDocument);
    }

    public TweetDocument addNewTweet(TweetDocument tweetDocument) {
        Integer curTweetId=++topTweetId;
        UserDocument authorUserDocument=tweetUserRepository.findUserByAuthorId(tweetDocument.getAuthorId());
        if(authorUserDocument!=null){
            authorUserDocument.getAuthorTweets().add(curTweetId);
            tweetUserRepository.save(authorUserDocument);
        }
        tweetDocument.setTweetId(curTweetId);
        return tweetRepository.save(tweetDocument);
    }

    public List<TweetDocument> findTweetsContainingComapnyName(String companyName){
        return searchTweetsRepository.findByCompanyName(companyName);
    }
}
