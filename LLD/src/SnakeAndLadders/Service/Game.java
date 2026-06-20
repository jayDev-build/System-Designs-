package SnakeAndLadders.Service;

import SnakeAndLadders.Entities.Grid;
import SnakeAndLadders.Entities.Obstacle.Dice;
import SnakeAndLadders.Entities.Obstacle.LadderObstacle;
import SnakeAndLadders.Entities.Obstacle.Obstacle;
import SnakeAndLadders.Entities.Player;
import SnakeAndLadders.Enums.ObstacleType;
import SnakeAndLadders.Factory.LadderObstacleFactory;
import SnakeAndLadders.Factory.ObstacleFactory;
import SnakeAndLadders.Factory.SnakeObstacleFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Game {
    private int size;
    private int noOfSnakes;
    private int noOfLadders;
    private int noOfDice;
    private final Grid grid;
    private final Dice dice;
    private ObstacleFactory obstacleFactory;
    Queue<Player> players;

    private Random random = new Random();

    public Game(int size, int noOfSnakes, int noOfLadders, int noOfDice){
        this.size = size;
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        this.noOfDice = noOfDice;
        this.grid = new Grid(size);
        this.players = new LinkedList<>();
        this.dice = new Dice(noOfDice);
        initObstacles();
    }

    private void initObstacles(){
        addObstacle(noOfLadders, ObstacleType.LADDER);
        addObstacle(noOfSnakes, ObstacleType.SNAKE);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addObstacle(int count, ObstacleType obstacleType){

        obstacleFactory = switch (obstacleType){
            case SNAKE -> new SnakeObstacleFactory();
            case LADDER -> new LadderObstacleFactory();
        };

        while (count > 0){
            int up = random.nextInt(size) + 1;
            int down = random.nextInt(up) + 1;

            Obstacle obstacle = switch (obstacleType){
                case SNAKE -> obstacleFactory.createObstacle(up, down);
                case LADDER -> obstacleFactory.createObstacle(down, up);
            };

            if(grid.addObstacle(obstacle)) count--;
        }
    }

    public void startGame(){
        while (players.size() > 1){
            Player player = players.poll();
            int diceRoll = dice.roll();
            int finalPosition = grid.getPosition(player, diceRoll);

            player.setPosition(finalPosition);

            if(player.getPosition() == size){
                System.out.println("Congratulations Player " + player.name + " You have won the game!" );
                continue;
            }else{
                players.add(player);
            }

            grid.printGrid(players);

        }
    }


}
