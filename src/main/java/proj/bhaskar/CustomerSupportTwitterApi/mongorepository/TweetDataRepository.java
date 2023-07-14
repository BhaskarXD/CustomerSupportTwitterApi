package proj.bhaskar.CustomerSupportTwitterApi.mongorepository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.TweetDocument;

import java.util.Optional;

@Repository
public interface TweetDataRepository extends MongoRepository<TweetDocument, ObjectId> {
    TweetDocument findTweetByTweetId(Integer tweetId);
    TweetDocument findTopByOrderByTweetIdDesc();
}
