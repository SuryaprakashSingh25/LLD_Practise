package ticTacToe;

import ticTacToe.enums.Move;
import ticTacToe.service.Game;
import ticTacToe.model.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter board size: ");
        int size = sc.nextInt();

        Player p1 = new Player("Player1", Move.X);
        Player p2 = new Player("Player2", Move.O);

        Game game = new Game(size, p1, p2);

        while (true) {
            game.printBoard();

            System.out.print("Enter row and column: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            try {
                game.makeMove(row, col);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again.");
            }
        }
    }
}
