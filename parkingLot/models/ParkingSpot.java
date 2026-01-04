package parkingLot.models;

import parkingLot.enums.VehicleType;

public class ParkingSpot {
    private int spotId;
    private VehicleType allowedType;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, VehicleType allowedType){
        this.spotId=spotId;
        this.allowedType=allowedType;
        this.vehicle=null;
    }

    public boolean isOccupied(){
        return vehicle!=null;
    }

    public boolean canPark(Vehicle vehicle){
        return !isOccupied() && allowedType==vehicle.getType();
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
    }

    public void removeVehicle(){
        this.vehicle=null;
    }

    public int getSpotId(){
        return spotId;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

}
