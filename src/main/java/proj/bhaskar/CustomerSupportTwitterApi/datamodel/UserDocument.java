package proj.bhaskar.CustomerSupportTwitterApi.datamodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("customerData")
public class UserDocument {

    @Id
    private ObjectId id;
    private String authorId;
    private List<Integer> authorTweets;

    public UserDocument(ObjectId id, String authorId, List<Integer> authorTweets) {
        this.id = id;
        this.authorId = authorId;
        this.authorTweets = authorTweets;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public List<Integer> getAuthorTweets() {
        return authorTweets;
    }

    public void setAuthorTweets(List<Integer> authorTweets) {
        this.authorTweets = authorTweets;
    }

    @Override
    public String toString() {
        return "UserDocument{" +
                "id=" + id +
                ", authorId='" + authorId + '\'' +
                ", authorTweets=" + authorTweets +
                '}';
    }
}

