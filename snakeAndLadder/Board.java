package snakeAndLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private Map<Integer,Integer> snakeMap=new HashMap<>();
    private Map<Integer,Integer> ladderMap=new HashMap<>();

    public Board(List<Snake> snakes,List<Ladder> ladders){
        for(Snake s:snakes){
            snakeMap.put(s.getHead(),s.getTail());
        }
        for(Ladder l:ladders){
            ladderMap.put(l.getStart(),l.getEnd());
        }
    }

    public int getFinalPosition(int pos){
        if(snakeMap.containsKey(pos)){
            return snakeMap.get(pos);
        }
        if(ladderMap.containsKey(pos)){
            return ladderMap.get(pos);
        }
        return pos;
    }

}
