package elevatorSystem;

import elevatorSystem.enums.Direction;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private Queue<Integer> targets;

    public Elevator(int id){
        this.id=id;
        this.currentFloor=0;
        this.direction=Direction.IDLE;
        this.targets=new LinkedList<>();
    }

    public boolean isIdle(){
        return targets.isEmpty();
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public void addTarget(int floor){
        targets.add(floor);
        if(currentFloor<floor){
            direction=Direction.UP;
        }
        else if(currentFloor>floor){
            direction=Direction.DOWN;
        }
    }

    public void move(){
        if(targets.isEmpty()){
            direction=Direction.IDLE;
            return;
        }

        int target= targets.peek();
        if(currentFloor<target){
            currentFloor++;
        }
        else if(currentFloor>target){
            currentFloor--;
        }
        System.out.println("Elevator "+id+" at floor "+currentFloor);

        if(currentFloor==target){
            System.out.println("Elevator "+id+" stopped at floor "+target);
            targets.poll();
        }
    }

}
