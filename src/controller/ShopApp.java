// Class ShopApp
package controller;

import java.util.ArrayList;
import model.Customer;
import model.Motorbike;
import model.RentLog;
import model.Shop;

public class ShopApp extends Menu {

    ArrayList<Motorbike> availableMotorbikes = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<RentLog> rentLogs = new ArrayList<>();
    Shop shop = new Shop();
    Motorbike motorbike = new Motorbike();
    RentLog rentLog = new RentLog();

    public ShopApp(String title, String[] choices) {
        super(title, choices);
    }

    @Override
    public void execute(int choice) {

        switch (choice) {
            case 1:
                shop.addNewMotorbike(motorbike);
                break;
            case 2: {
                try {
                    shop.getAvailableMotorbike();
                } catch (Exception e) {
                    System.err.println("Ban chua them xe vao danh sach!!");
                }
            }
            break;
            case 3:
                shop.displayAllMotorbike();
                break;
            case 4:
                shop.rentMotorbike(motorbike);
                break;
            case 5:
                shop.giveMotorbikeback(motorbike);
                break;
            case 6:
                shop.displayRentLogs();
                break;
            case 7:
                System.out.println("Quit selected. Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void main(String[] args) {
        String[] mc = {"Add Motorbike For Rent", "Display Motorbike Available", "Display All Motorbike", "Rent Motorbike","Give Motorbike Back", "View RentLog", "Exit"};
        ShopApp m = new ShopApp("Motorbike Rental", mc);
        m.run();
    }

}
