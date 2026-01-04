package parkingLot.models;

import parkingLot.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    public Floor(int floorNumber, int twoWheelerSpot, int fourWheelerSpot){
        this.floorNumber=floorNumber;
        this.spots=new ArrayList<>();

        int id=1;
        for(int i=0;i<twoWheelerSpot;i++){
            spots.add(new ParkingSpot(id++, VehicleType.TWO_WHEELER));
        }
        for(int i=0;i<fourWheelerSpot;i++){
            spots.add(new ParkingSpot(id++, VehicleType.FOUR_WHEELER));
        }
    }

    public ParkingSpot getAvailableSpot(Vehicle vehicle){
        for(ParkingSpot spot:spots){
            if(spot.canPark(vehicle)){
                return spot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getSpots(){
        return spots;
    }

    public int getFloorNumber(){
        return floorNumber;
    }

}
