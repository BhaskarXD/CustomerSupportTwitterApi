package proj.bhaskar.CustomerSupportTwitterApi.mongorepository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import proj.bhaskar.CustomerSupportTwitterApi.datamodel.UserDocument;

@Repository
public interface TweetUserRepository extends MongoRepository<UserDocument, ObjectId> {
    @Query("{authorId:'?0'}")
    UserDocument findUserByAuthorId(String authorId);
}
