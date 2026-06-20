package SnakeAndLadders.Entities.Obstacle;

import java.util.Map;
import java.util.Random;

public class Dice {
    private int count;
    private final Random random = new Random();

    public Dice(int count){
        this.count = count;
    }

    public int roll(){
        int sum = 0;
        for(int i = 0; i < count; i++){
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }
}
