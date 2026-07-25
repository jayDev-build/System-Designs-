package RateLimiter.limiter;


import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import RateLimiter.Enums.RateLimitType;
import RateLimiter.model.RateConfig;
import RateLimiter.model.User;

public class SlidingWindowRateLimiter extends RateLimiter {

    private Map<String, Queue<Long>> userRequestCount;
    
    public SlidingWindowRateLimiter(RateConfig config){
        super(config, RateLimitType.SLIDING_WINDOW);
        userRequestCount = new ConcurrentHashMap<>();
    }

    @Override
    public boolean request(User user) {
        AtomicBoolean allowed = new AtomicBoolean(false);

        String userId = user.id;
        
        Long currentTime = System.currentTimeMillis();
        Queue<Long> Q = userRequestCount.getOrDefault(userId, new LinkedList<>());

        while (!Q.isEmpty() && currentTime -Q.peek() >= config.getWindow()) {
            Q.poll();
        }

        if(Q.size() < config.getCount()){
            Q.add(currentTime);
            allowed.set(true);
        }

        userRequestCount.putIfAbsent(userId, Q);
        return allowed.get();
    }

}
