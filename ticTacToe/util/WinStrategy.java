package ticTacToe.util;

import ticTacToe.enums.Move;

public interface WinStrategy {
    boolean checkWin(int row, int col, Move move);
}
