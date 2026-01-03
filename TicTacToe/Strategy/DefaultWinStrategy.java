package TicTacToe.Strategy;

import TicTacToe.Enums.Move;

public class DefaultWinStrategy implements WinStrategy{
    private final int[] rows;
    private final int[] cols;
    private int diag;
    private int antiDiag;
    private final int size;

    public DefaultWinStrategy(int size){
        this.size=size;
        rows=new int[size];
        cols=new int[size];
    }

    @Override
    public boolean checkWin(int row, int col, Move move) {
        int value=move==Move.X?1:-1;
        rows[row]+=value;
        cols[col]+=value;

        if(row==col){
            diag+=value;
        }
        if(row+col==size-1){
            antiDiag+=value;
        }
        return Math.abs(rows[row])==size
                || Math.abs(cols[col])==size
                || Math.abs(diag)==size
                || Math.abs(antiDiag)==size;
    }
}
