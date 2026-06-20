package SnakeAndLadders.Entities;

import SnakeAndLadders.Entities.Obstacle.Obstacle;
import SnakeAndLadders.Enums.ObstacleType;

import java.util.Queue;

public class Grid {
    private final int size;
    private final int sideLength;
    private final Cell[][] grid;

    public Grid(int size){
        this.size = size;
        sideLength = (int)Math.sqrt(size);
        grid = new Cell[sideLength][sideLength];


        boolean leftToRight = true;
        int position = 1;
        for(int r = sideLength - 1; r >= 0; r--){
            if(leftToRight){
                for(int c = 0; c < sideLength; c++){
                    grid[r][c] = new Cell(position++);
                }
            }else{
                for(int c = sideLength - 1; c >= 0; c--){
                    grid[r][c] = new Cell(position++);
                }
            }
            leftToRight = !leftToRight;
        }
    }

    public int getRow(int position){
        int row = (position - 1) / sideLength;
        return sideLength - row - 1;
    }

    public int getCol(int position){
        int row = getRow(position);
        int col = (position - 1) % sideLength;
        if(row % 2 == 0){
            return sideLength - col - 1;
        }else{
            return col;
        }
    }

    private Cell getCell(int position){
        return grid[getRow(position)][getCol(position)];
    }

    public boolean addObstacle(Obstacle obstacle){
        Cell src = getCell(obstacle.src);
        Cell dest = getCell(obstacle.dest);

        if(src.hasObstacle() || dest.hasObstacle()){
            return false;
        }

        src.setObstacle(obstacle);

        return true;

    }

    public int getPosition(Player player, int diceRoll){
        int currPosition = player.getPosition();
        int newPosition = currPosition + diceRoll;

        if (newPosition > size) {
            System.out.println("You are going out of the board! Better luck next time!");
            return player.getPosition();
        }

        Cell cell = getCell(newPosition);

        int finalPosition = cell.getPosition();

        if(finalPosition < newPosition){
            System.out.println("Oops! Snake has bitten " + player.name);
        }else if(finalPosition > newPosition){
            System.out.println("Congratulations! " + player.name + " moved up through a ladder");
        }else{
            System.out.println(player.name + " moved from " + player.getPosition() + " to " + finalPosition);
        }

        return finalPosition;
    }

    public void printGrid(Queue<Player> players) {
        System.out.println("\nCurrent Board State:");

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                int position = grid[i][j].getPosition();
                String cellContent = String.valueOf(position);

                if (grid[i][j].hasObstacle()) {
                    Obstacle obstacle = grid[i][j].getObstacle();
                    cellContent = (obstacle.getObstacletype() == ObstacleType.SNAKE) ? "🐍" + obstacle.getFinalPosition() : "🪜" + obstacle.getFinalPosition();
                }

                for (Player player : players) {
                    if (player.getPosition() == position) {
//                        cellContent = player.getName().substring(0, 1);
                        cellContent = player.name;
                    }
                }

                System.out.printf("%-8s", cellContent);
            }
            System.out.println();
        }
        System.out.println();
    }

}
