package snakeAndLadder;

import java.util.List;

public class Game {
    private Board board;
    private Dice dice;
    private List<Player> players;
    private int currentPlayerIndex=0;

    public Game(Board board,List<Player> players){
        this.board=board;
        this.players=players;
        this.dice=new Dice();
    }

    public void startGame(){
        while(true){
            Player currentPlayer=players.get(currentPlayerIndex);
            int roll=dice.roll();
            System.out.println(currentPlayer.getName()+" rolled "+roll);
            int newPos=currentPlayer.getPosition()+roll;
            if(newPos<=100){
                newPos= board.getFinalPosition(newPos);
                currentPlayer.setPosition(newPos);
                System.out.println(currentPlayer.getName()+" moved to "+newPos);
            }
            else{
                System.out.println("Move invalid, stays at "+currentPlayer.getPosition());
            }
            if(currentPlayer.getPosition()==100){
                System.out.println(currentPlayer.getName()+" WINS!");
                break;
            }
            if(roll!=6){
                currentPlayerIndex=(currentPlayerIndex+1)%players.size();
            }
        }
    }

}
