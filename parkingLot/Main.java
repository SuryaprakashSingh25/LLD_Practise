package parkingLot;

import parkingLot.enums.VehicleType;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.service.ParkingLot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ParkingLot parkingLot=new ParkingLot(2);

        while (true){
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            int choice=sc.nextInt();

            if(choice==1){
                System.out.print("Enter number plate: ");
                String numberPlate=sc.next();

                System.out.print("Enter Vehicle Type (1: Two, 2: Four): ");
                int type=sc.nextInt();
                Vehicle vehicle=new Vehicle(numberPlate,type==1? VehicleType.TWO_WHEELER:VehicleType.FOUR_WHEELER);

                Ticket ticket=parkingLot.parkVehicle(vehicle);
                if(ticket==null){
                    System.out.println("No Parking Available");
                }
                else{
                    System.out.println("Parked at floor "+ticket.getFloorNumber()+", Spot "+ticket.getSpotId());
                }
            }else if (choice == 2) {
                System.out.print("Enter number plate: ");
                String numberPlate = sc.next();

                double cost = parkingLot.unparkVehicle(numberPlate);
                if (cost == -1) {
                    System.out.println("Invalid ticket");
                } else {
                    System.out.println("Parking charge: ₹" + cost);
                }

            } else {
                System.out.println("Exiting...");
                break;
            }
        }
        sc.close();
    }
}
