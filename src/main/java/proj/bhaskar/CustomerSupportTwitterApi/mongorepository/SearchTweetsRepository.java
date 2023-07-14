package proj.bhaskar.CustomerSupportTwitterApi.mongorepository;

import proj.bhaskar.CustomerSupportTwitterApi.datamodel.TweetDocument;

import java.util.List;

public interface SearchTweetsRepository {
    List<TweetDocument> findByCompanyName(String companyName);
}
