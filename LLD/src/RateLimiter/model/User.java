package RateLimiter.model;

import RateLimiter.Enums.UserTier;

public class User {
    public String id;
    public UserTier userTier;

    public User(String id, UserTier userTier){
        this.id = id;
        this.userTier = userTier;
    }
}
