package ticTacToe.model;

import ticTacToe.enums.Move;

public class Board {
    private final int size;
    private final Move[][] grid;
    private int filledCells;

    public Board(int size){
        this.size=size;
        this.grid=new Move[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                grid[i][j]=Move.EMPTY;
            }
        }
        this.filledCells=0;
    }

    public boolean isMoveValid(int row,int col){
        return row>=0 && row<size && col>=0 && col<size && grid[row][col]==Move.EMPTY;
    }

    public void placeMove(int row,int col,Move move){
        if(!isMoveValid(row,col)){
            throw new IllegalArgumentException("Invalid Move");
        }
        grid[row][col]=move;
        filledCells++;
    }

    public boolean isFull(){
        return filledCells==size*size;
    }

    public Move getCell(int row,int col){
        return grid[row][col];
    }

    public int getSize(){
        return size;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(grid[i][j]==Move.EMPTY?" ":grid[i][j]);
                if(j<size-1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
