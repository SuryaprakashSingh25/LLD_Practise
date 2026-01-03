package TicTacToe.Strategy;

import TicTacToe.Enums.Move;

public interface WinStrategy {
    boolean checkWin(int row, int col, Move move);
}
