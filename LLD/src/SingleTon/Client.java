package SingleTon;

public class Client {
    public static void main(String[] args) {
        Counter counter1 = Counter.getInstance();
        System.out.println("Initiated Counter1 => " + counter1.getCounter());
        Counter counter2 = Counter.getInstance();
        System.out.println("Initiated Counter2 => " + counter2.getCounter());

        counter1.incrementCounter();
        System.out.println("Incremented Counter1 => " + counter1.getCounter());

        counter2.incrementCounter();
        System.out.println("Incremented Counter2 => " + counter2.getCounter());

    }
}
