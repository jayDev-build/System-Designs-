package RateLimiter.model;

public class RateConfig {
    private int window; // in seconds
    private int count; // max requests in window

    public RateConfig(int window, int count) {
        this.window = window;
        this.count = count;
    }

    public int getWindow() {
        return window;
    }

    public int getCount() {
        return count;
    }
}
