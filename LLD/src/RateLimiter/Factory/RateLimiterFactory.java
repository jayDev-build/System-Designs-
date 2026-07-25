package RateLimiter.Factory;

import RateLimiter.Enums.RateLimitType;
import RateLimiter.model.RateConfig;
import RateLimiter.model.User;
import RateLimiter.limiter.RateLimiter;
import RateLimiter.limiter.FixedWindowRateLimiter;
import RateLimiter.limiter.SlidingWindowRateLimiter;
import RateLimiter.limiter.TokenBucketRateLimiter;

public class RateLimiterFactory {
    
    public static RateLimiter getRateLimiter(RateConfig rateConfig, RateLimitType type){
        switch(type){
            case FIXED_WINDOW:
                return new FixedWindowRateLimiter(rateConfig);
            case SLIDING_WINDOW:
                return new SlidingWindowRateLimiter(rateConfig);
            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter(rateConfig);
            default:
                throw new IllegalArgumentException("Invalid RateLimitType");
        }
    }
}
