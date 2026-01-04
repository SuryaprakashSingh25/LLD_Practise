package parkingLot.models;

public class Ticket {
    private Vehicle vehicle;
    private long entryTime;
    private int floorNumber;
    private int spotId;

    public Ticket(Vehicle vehicle,int floorNumber,int spotId){
        this.vehicle=vehicle;
        this.floorNumber=floorNumber;
        this.spotId=spotId;
        this.entryTime=System.currentTimeMillis();
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSpotId() {
        return spotId;
    }

}
