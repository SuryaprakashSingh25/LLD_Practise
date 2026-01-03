package TicTacToe.Game;

import TicTacToe.Board.Board;
import TicTacToe.Enums.GameStatus;
import TicTacToe.Player.Player;
import TicTacToe.Strategy.DefaultWinStrategy;
import TicTacToe.Strategy.WinStrategy;

public class Game {
    private final Board board;
    private final Player[] players;
    private final WinStrategy winStrategy;
    private int currentPlayerIndex;
    private GameStatus status;

    public Game(int boardSize, Player p1, Player p2){
        this.board=new Board(boardSize);
        this.players=new Player[]{p1,p2};
        this.winStrategy=new DefaultWinStrategy(boardSize);
        this.currentPlayerIndex=0;
        this.status=GameStatus.IN_PROGRESS;
    }

    public void makeMove(int row,int col){
        if(status!=GameStatus.IN_PROGRESS){
            throw new IllegalStateException("Game already finished");
        }
        Player currentPlayer=players[currentPlayerIndex];
        board.placeMove(row,col,currentPlayer.getMove());

        if(winStrategy.checkWin(row,col,currentPlayer.getMove())){
            status=GameStatus.WON;
            board.printBoard();
            System.out.println("Winner: "+currentPlayer.getName());
            return;
        }

        if(board.isFull()){
            status=GameStatus.DRAW;
            board.printBoard();
            System.out.println("Game is a draw");
            return;
        }

        currentPlayerIndex=1-currentPlayerIndex;
    }

    public void printBoard(){
        board.printBoard();
    }

}
