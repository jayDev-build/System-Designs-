package SnakeAndLadders;

import SnakeAndLadders.Entities.Player;
import SnakeAndLadders.Service.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the board size : ");
        int boardSize = scanner.nextInt();

        System.out.print("Enter the number of snakes : ");
        int noOfSnakes = scanner.nextInt();

        System.out.print("Enter the number of ladders : ");
        int noOfLadders = scanner.nextInt();

        System.out.print("Enter the number of players : ");
        int noOfPlayers = scanner.nextInt();

        System.out.print("Enter the number of Dice : ");
        int noOfDice = scanner.nextInt();

        Game game = new Game(boardSize, noOfSnakes, noOfLadders, noOfDice);

        for (int i = 0; i < noOfPlayers; i++){
            System.out.print("Enter the name of player " + (i + 1) + " : ");
            String name = scanner.next();
            Player player = new Player(name);
            game.addPlayer(player);
        }

        game.startGame();
    }
}