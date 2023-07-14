package proj.bhaskar.CustomerSupportTwitterApi.datamodel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document("customerTweets")
public class TweetDocument {
    @Id
    private ObjectId id;
    private Integer tweetId;
    private String authorId;
    private Boolean tweetInbound;
    private LocalDateTime createdAt;
    private List<Integer> responseTweetId;
    private Integer inResponseToTweetId;
    private String tweetText;

    @Override
    public String toString() {
        return "TweetDocument{" +
                "id=" + id +
                ", tweetId=" + tweetId +
                ", authorId='" + authorId + '\'' +
                ", tweetInbound=" + tweetInbound +
                ", createdAt=" + createdAt +
                ", responseTweetId=" + responseTweetId +
                ", inResponseToTweetId=" + inResponseToTweetId +
                ", tweetText='" + tweetText + '\'' +
                '}';
    }

    public TweetDocument(ObjectId id, Integer tweetId, String authorId, Boolean tweetInbound, LocalDateTime createdAt, List<Integer> responseTweetId, Integer inResponseToTweetId, String tweetText) {
        this.id = id;
        this.tweetId = tweetId;
        this.authorId = authorId;
        this.tweetInbound = tweetInbound;
        this.createdAt = createdAt;
        this.responseTweetId = responseTweetId;
        this.inResponseToTweetId = inResponseToTweetId;
        this.tweetText = tweetText;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getTweetId() {
        return tweetId;
    }

    public void setTweetId(Integer tweetId) {
        this.tweetId = tweetId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Boolean getTweetInbound() {
        return tweetInbound;
    }

    public void setTweetInbound(Boolean tweetInbound) {
        this.tweetInbound = tweetInbound;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Integer> getResponseTweetId() {
        return responseTweetId;
    }

    public void setResponseTweetId(List<Integer> responseTweetId) {
        this.responseTweetId = responseTweetId;
    }

    public Integer getInResponseToTweetId() {
        return inResponseToTweetId;
    }

    public void setInResponseToTweetId(Integer inResponseToTweetId) {
        this.inResponseToTweetId = inResponseToTweetId;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }
}
