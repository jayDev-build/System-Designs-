package DesignPatterns.SingleTon;

public class Counter {
    private int count;
    private static Counter instance;

    private Counter(){}

    public static Counter getInstance(){
        if(instance == null) {
            synchronized (Counter.class) {
                if (instance == null) {
                    instance = new Counter();
                }
            }
        }
        return instance;
    }

    public int getCounter(){
        return count;
    }

    public int incrementCounter(){
        return ++count;
    }
}
