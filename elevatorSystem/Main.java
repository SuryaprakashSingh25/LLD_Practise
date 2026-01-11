package elevatorSystem;

import elevatorSystem.enums.Direction;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system=new ElevatorSystem(4);
        system.handleRequest(new Request(10, Direction.UP));
        system.handleRequest(new Request(3,Direction.DOWN));

        for(int i=0;i<20;i++){
            system.step();
            try{
                Thread.sleep(1000);
            } catch (Exception e){}
        }
    }
}
