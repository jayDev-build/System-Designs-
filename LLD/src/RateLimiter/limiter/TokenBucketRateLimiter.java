package RateLimiter.limiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import RateLimiter.Enums.RateLimitType;
import RateLimiter.model.RateConfig;
import RateLimiter.model.User;

public class TokenBucketRateLimiter extends RateLimiter {
    private ConcurrentHashMap<String, Integer> userRequestCount;
    private ConcurrentHashMap<String, Long> lastRefillTimeStamp;

    public TokenBucketRateLimiter(RateConfig config) {
        super(config, RateLimitType.TOKEN_BUCKET);
        userRequestCount = new ConcurrentHashMap<>();
        lastRefillTimeStamp = new ConcurrentHashMap<>();
    }

    @Override
    public boolean request(User user) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        String userId = user.id;

        Long currentTime = System.currentTimeMillis();

        int currentTokens = refill(userId, currentTime);
        if (currentTokens > 0) {
            userRequestCount.put(userId, currentTokens - 1);
            allowed.set(true);
        }

        return allowed.get();
    }

    private int refill(String userId, long now) {
        double refillRate = (double) config.getWindow() / config.getCount();

        lastRefillTimeStamp.putIfAbsent(userId, now);
        long lastRefill = lastRefillTimeStamp.get(userId);

        long elapsedSeconds = (now - lastRefill) / 1000;
        int refillTokens = (int) (elapsedSeconds / refillRate);
        int currentTokens = userRequestCount.getOrDefault(userId, config.getCount());
        currentTokens = Math.min(config.getCount(), currentTokens + refillTokens);

        if (refillTokens > 0)
            lastRefillTimeStamp.put(userId, now);
        return currentTokens;
    }
}
