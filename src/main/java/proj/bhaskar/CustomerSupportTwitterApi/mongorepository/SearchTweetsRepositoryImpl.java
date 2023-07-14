package proj.bhaskar.CustomerSupportTwitterApi.mongorepository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.TweetDocument;
import proj.bhaskar.CustomerSupportTwitterApi.mongorepository.SearchTweetsRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SearchTweetsRepositoryImpl implements SearchTweetsRepository {

    @Autowired
    private MongoClient mongoClient;

    @Autowired
    private MongoConverter mongoConverter;
    @Override
    public List<TweetDocument> findByCompanyName(String companyName) {
        List<TweetDocument> posts=new ArrayList<>();
        /*
         * Requires the MongoDB Java Driver.
         * https://mongodb.github.io/mongo-java-driver
         */

//        MongoClient mongoClient = new MongoClient(
//                new MongoClientURI(
//                        ""
//                )
//        );
        MongoDatabase database = mongoClient.getDatabase("customerSupportDb");
        MongoCollection<Document> collection = database.getCollection("customerTweets");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", companyName)
                                .append("path", "tweetText"))),
                                new Document("$addFields",
                                new Document("tweetTextLenght",
                                new Document("$strLenCP", "$tweetText"))),
                                new Document("$sort",
                                new Document("tweetTextLenght", -1L))));
        result.forEach(doc->posts.add(mongoConverter.read(TweetDocument.class,doc)));
        return posts;
    }
}
