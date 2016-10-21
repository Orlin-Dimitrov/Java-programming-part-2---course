
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dmitry
 */
public class UserPanel {
    private Airport airport;
    private Scanner reader;

    public UserPanel(Airport airport, Scanner reader) {
        this.airport = airport;
        this.reader = reader;
    }
    
    public void start() {
        System.out.println("Airport panel\n" +
            "--------------------\n");
        while(true) {
            System.out.print("Choose operation:\n" +
                "[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit\n" + "> ");
            String command = reader.nextLine();
            if(command.equals("x")) {
                break;
            }
            else if (command.equals("1")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                System.out.print("Give plane capacity: ");
                int capacity = Integer.parseInt(reader.nextLine());
                airport.addPlane(id, capacity);
            }
            else if (command.equals("2")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                System.out.print("Give departure airport code: ");
                String depart = reader.nextLine();
                System.out.print("Give destination airport code: ");
                String dest = reader.nextLine();
                airport.addFlight(id, depart, dest);
            }
        }
        
        System.out.println("Flight service\n" +
            "------------\n");
        while(true) {
            System.out.print("Choose operation:\n" +
                "[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit\n" +
                "> ");
            String command = reader.nextLine();
            if(command.equals("x")) {
                break;
            }
            else if (command.equals("1")) {
                airport.printPlanes();
            }
            else if (command.equals("2")) {
                airport.printFlights();
            }
            else if (command.equals("3")) {
                System.out.print("Give plane ID: ");
                String id = reader.nextLine();
                airport.printPlaneInfo(id);
            }
        }
    }
}
