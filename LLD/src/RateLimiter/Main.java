package RateLimiter;

import RateLimiter.Enums.UserTier;
import RateLimiter.Service.RateLimitService;
import RateLimiter.model.User;

public class Main {
    public static void main(String[] args) {
        RateLimitService rateLimitService = new RateLimitService();

        User user1 = new User("1", UserTier.FREE);
        User user2 = new User("2", UserTier.PREMIUM);

        for (int i = 0; i < 30; i++) {
            System.out.println("Request by user1 " + (i + 1) + ": " + (rateLimitService.request(user1) ? "Allowed" : "Denied"));
        }

        for (int i = 0; i < 30; i++) {
            System.out.println("Request by user2 " + (i + 1) + ": " + (rateLimitService.request(user2) ? "Allowed" : "Denied"));
        }
    }
}
