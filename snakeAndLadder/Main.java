package snakeAndLadder;

import snakeAndLadder.enums.Color;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Snake> snakes=List.of(
                new Snake(99,10),
                new Snake(70,55),
                new Snake(52,42)
        );

        List<Ladder> ladders=List.of(
                new Ladder(5,25),
                new Ladder(40,89),
                new Ladder(22,58)
        );

        Board board=new Board(snakes,ladders);

        List<Player> players=List.of(
                new Player("Alice", Color.RED),
                new Player("Bob", Color.BLUE)
        );

        Game game=new Game(board,players);
        game.startGame();

    }
}
