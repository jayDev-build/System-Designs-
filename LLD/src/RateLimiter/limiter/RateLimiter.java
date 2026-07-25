package RateLimiter.limiter;

import RateLimiter.Enums.RateLimitType;
import RateLimiter.model.User;
import RateLimiter.model.RateConfig;

public abstract class RateLimiter {
    protected final RateConfig config;
    protected final RateLimitType type;

    RateLimiter(RateConfig config, RateLimitType type) {
        this.config = config;
        this.type = type;
    }

    public abstract boolean request(User user);
}
