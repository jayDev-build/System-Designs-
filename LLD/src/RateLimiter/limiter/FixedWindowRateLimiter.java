package RateLimiter.limiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import RateLimiter.Enums.RateLimitType;
import RateLimiter.model.User;
import RateLimiter.model.RateConfig;

public class FixedWindowRateLimiter extends RateLimiter {
    ConcurrentHashMap<String, Integer> userMap;
    ConcurrentHashMap<String, Long> timestampMap;

    public FixedWindowRateLimiter(RateConfig config) {
        super(config, RateLimitType.FIXED_WINDOW);
        userMap = new ConcurrentHashMap<>();
        timestampMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean request(User user) {
        AtomicBoolean allowed = new AtomicBoolean(false);

        String userId = user.id;
        long currentTime = System.currentTimeMillis();
        long timeWindow = currentTime / 1000 / config.getWindow();

        if (timeWindow != timestampMap.get(user.id)) {
            userMap.put(userId, 0);
            timestampMap.put(userId, timeWindow);
        }

        if (userMap.get(user.id) < config.getCount()) {
            userMap.put(userId, userMap.get(userId) + 1);
            allowed.set(true);
        }

        return allowed.get();
    }

}
