package RateLimiter.Service;

import java.util.HashMap;

import RateLimiter.Enums.UserTier;
import RateLimiter.limiter.RateLimiter;
import RateLimiter.model.RateConfig;
import RateLimiter.model.User;
import RateLimiter.Factory.RateLimiterFactory;
import RateLimiter.Enums.RateLimitType;

public class RateLimitService {

    private HashMap<UserTier, RateLimiter> map;

    public RateLimitService() {
        map = new HashMap<>();
        map.put(UserTier.FREE,
                RateLimiterFactory.getRateLimiter(new RateConfig(60, 10), RateLimitType.TOKEN_BUCKET));

        map.put(UserTier.PREMIUM,
                RateLimiterFactory.getRateLimiter(new RateConfig(60, 25), RateLimitType.SLIDING_WINDOW));
    }

    public boolean request(User user) {
        return map.get(user.userTier).request(user);
    }

}
