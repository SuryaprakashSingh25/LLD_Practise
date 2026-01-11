package elevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;

    public ElevatorSystem(int numberOfElevators){
        elevators=new ArrayList<>();
        for(int i=1;i<=numberOfElevators;i++){
            elevators.add(new Elevator(i));
        }
    }

    public void handleRequest(Request request){
        Elevator bestElevator=findBestElevator(request);
        System.out.println("Assigning elevator to floor "+request.getFloor());
        bestElevator.addTarget(request.getFloor());
    }

    private Elevator findBestElevator(Request request){
        Elevator best=null;
        int minDistance=Integer.MAX_VALUE;
        for(Elevator e:elevators){
            int distance=Math.abs(e.getCurrentFloor()- request.getFloor());
            if(distance<minDistance){
                minDistance=distance;
                best=e;
            }
        }
        return best;
    }

    public void step(){
        for(Elevator e:elevators){
            e.move();
        }
    }
}
