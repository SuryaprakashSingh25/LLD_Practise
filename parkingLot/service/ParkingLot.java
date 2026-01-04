package parkingLot.service;

import parkingLot.models.Floor;
import parkingLot.models.ParkingSpot;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<Floor> floors;
    private Map<String, Ticket> activeTickets;

    public ParkingLot(int numberOfFloors){
        floors=new ArrayList<>();
        activeTickets=new HashMap<>();

        for(int i=1;i<=numberOfFloors;i++){
            floors.add(new Floor(i,2,2));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle){
        for(Floor floor:floors){
            ParkingSpot spot=floor.getAvailableSpot(vehicle);
            if(spot!=null){
                spot.parkVehicle(vehicle);
                Ticket ticket=new Ticket(vehicle, floor.getFloorNumber(), spot.getSpotId());
                activeTickets.put(vehicle.getNumberPlate(),ticket);
                return ticket;
            }
        }
        return null;
    }

    public double unparkVehicle(String numberPlate){
        Ticket ticket=activeTickets.get(numberPlate);
        if(ticket==null){
            return -1;
        }

        for(Floor floor:floors){
            if(floor.getFloorNumber()== ticket.getFloorNumber()){
                for(ParkingSpot spot: floor.getSpots()){
                    if(spot.getSpotId()== ticket.getSpotId()){
                        spot.removeVehicle();
                        break;
                    }
                }
            }
        }

        activeTickets.remove(numberPlate);
        long duration=System.currentTimeMillis()- ticket.getEntryTime();
        long hours=Math.max(1,duration/(1000*60*60));
        return hours*50;
    }

}
