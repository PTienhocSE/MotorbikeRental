package model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Shop {

    private ArrayList<Motorbike> MotorbikesList = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<RentLog> rentLogs = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private static int MotorbikeID = 0;
    RentLog rentLog = new RentLog();

    //-----------------------------------------
    public Shop(ArrayList<Motorbike> listMotorbikes, ArrayList<Customer> customers, ArrayList<RentLog> rentLogs) {
        this.MotorbikesList = listMotorbikes;
        this.customers = customers;
        this.rentLogs = rentLogs;
    }

    //-----------------------------------------
    public Shop() {
//        Motorbike mtb = new Motorbike(10, "03333", "sirius", 150000, 20000000, false);
//        MotorbikesList.add(mtb);
//       Customer cm = new Customer("1000", "Tran Phuc Tien");
//       customers.add(cm);
//       RentLog rl = new RentLog(cm, mtb, 123, "note");
//       rentLogs.add(rl);  
    }

    //-----------------------------------------
    public ArrayList<Motorbike> getMotorbikes() {
        return MotorbikesList;
    }

    //-----------------------------------------
    public Customer addNewCust() {
        System.out.print("Enter ID number: ");
        String id = sc.next();
        sc.nextLine();

        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                System.out.println("Customer ID already exists!!");
                return customer;
            }
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();
        Customer newCustomer = new Customer(id, name);
        customers.add(newCustomer);
        return newCustomer;
    }

    //-----------------------------------------
    public void readFile() {
        try {
            Scanner sc = new Scanner(new FileReader("motorbike.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String arr[] = line.split("-");
                int ID = Integer.parseInt(arr[0]);
                String licensePlate = arr[1];
                String brandName = arr[2];
                double rentPrice = Double.parseDouble(arr[3]);
                double Price = Double.parseDouble(arr[4]);

                Motorbike motorbike = new Motorbike(ID, licensePlate, brandName, rentPrice, Price, true);
                MotorbikesList.add(motorbike);
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void writeFile() {
    try {
        PrintWriter writer = new PrintWriter(new FileWriter("motorbike.txt"));
        
        for (Motorbike motorbike : MotorbikesList) {
            String line = motorbike.getID() + "-" + motorbike.getLicensePlate() + "-" +
                          motorbike.getBrandName() + "-" + motorbike.getRentPrice() + "-" +
                          motorbike.getPrice();
            writer.println(line);
        }
        
        writer.close();
    } catch (IOException e) {
        System.out.println(e);
    }
}

    //-----------------------------------------
    public void addNewMotorbike(Motorbike motorbike) {

    boolean validChoice = false;

    do {
        System.out.println("Choose type input:");
        System.out.println("1. File");
        System.out.println("2. From keyboard");
        System.out.println("3. Exit");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                readFile();
                validChoice = true;
                break;
            case 2:
                System.out.println("Enter Motorbike Information:");
                System.out.print("Enter License Plate: ");
                String licensePlate = sc.next();
                System.out.print("Enter Brand Name: ");
                String brandName = sc.next();
                System.out.print("Enter Rent Price: ");
                double rentPrice = sc.nextDouble();
                System.out.print("Enter Motorbike Price: ");
                double price = sc.nextDouble();
                System.out.println();

                ++MotorbikeID;

                Motorbike newMotorbike = new Motorbike(MotorbikeID, licensePlate, brandName, rentPrice, price, true);
                MotorbikesList.add(newMotorbike);
                validChoice = true;
                
                writeFile();
                break;
            case 3:
                validChoice = true;
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                break;
        }

    } while (!validChoice);
}


    //-----------------------------------------
    public void setMotorbikeList(Motorbike motorbike) {
        MotorbikesList.add(motorbike);
    }

    //-----------------------------------------
    public void setCustomer(Customer customer) {
        customers.add(customer);
    }

    //-----------------------------------------
    public void displayAllMotorbike() {
        System.out.println("All Motorbikes:");
        System.out.println("--------------------------------------");
        for (Motorbike motorbike : MotorbikesList) {
            System.out.println(motorbike.toString());
        }
    }

    //-----------------------------------------
    public void getAvailableMotorbike() {
        System.out.println("Available Motorbikes:");
        System.out.println("--------------------------------------");
        for (Motorbike motorbike : MotorbikesList) {
            if (motorbike.isStatus()) {
                System.out.println(motorbike.toString());
            }
        }
    }

    //-----------------------------------------
    public void getUnavailableMotorbike() {
        System.out.println("Unavailable Motorbikes:");
        System.out.println("--------------------------------------");
        for (Motorbike motorbike : MotorbikesList) {
            if (motorbike.isStatus() != true) {
                System.out.println(motorbike.toString());
            }
        }
    }

    //-----------------------------------------
    public Motorbike rentMotorbike(Motorbike motorbike) {
        getAvailableMotorbike();
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= MotorbikesList.size()) {
            motorbike = MotorbikesList.get(choice - 1);
            if (motorbike != null) {
                Customer newCustomer = addNewCust();
                if (newCustomer != null) {
                    motorbike.setStatus(false);
                    System.out.print("Enter descriptor: ");
                    String des = sc.nextLine();
                    RentLog rentLog = new RentLog(newCustomer, motorbike, null, des);
                    rentLogs.add(rentLog);
                    System.out.println("Rent Successful!");
                    System.out.println("");
                    rentLog.displayBillRent();
                    System.out.println("");

                } else {
                    System.out.println("Invalid information customer");
                }
            } else {
                System.out.println("No rental cars!");
            }
            return motorbike;
        } else {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }
    }

    public Motorbike rentMotorbikeforGUI(int choice, Customer customer, String descriptor) {
        if (choice >= 1 && choice <= MotorbikesList.size()) {
            Motorbike motorbike = MotorbikesList.get(choice - 1);
            if (motorbike != null && customer != null) {
                if (!motorbike.isStatus()) {
                    System.out.println("This motorbike is not available for rent.");
                    return null;
                }
                motorbike.setStatus(false);
                RentLog rentLog = new RentLog(customer, motorbike, null, descriptor);
                rentLogs.add(rentLog);
                System.out.println("Rent Successful!");
                System.out.println("");
                rentLog.displayBillRent();
                System.out.println("");
                return motorbike;
            } else {
                System.out.println("Invalid choice or customer. Please try again.");
                return null;
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
            return null;
        }

    }

    //-----------------------------------------
    public void giveMotorbikeback(Motorbike motorbike) {
        getUnavailableMotorbike();

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        if (choice >= 1 && choice <= MotorbikesList.size()) {
            motorbike = MotorbikesList.get(choice - 1);
            if (motorbike != null) {
                motorbike.setStatus(true);

                LocalDateTime returnTime = LocalDateTime.now();

                for (RentLog rentLog : rentLogs) {
                    if (rentLog.getMotorbike() == motorbike && rentLog.getEndTime() == null) {
                        rentLog.setEndTime(returnTime);
                        // rentLog.setOtherInfo(...);
                        System.out.println("Motorbike returned successfully!");
                        System.out.println("");
                        rentLog.displayBillGiveBack();
                        System.out.println("");
                        return;
                    }
                }
                System.out.println("No matching rent log found.");
            } else {
                System.out.println("Invalid motorbike choice.");
            }
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }
    
    public Motorbike giveMotorbikebackforGUI(int choice) {
    Motorbike motorbike = null;

    if (choice >= 1 && choice <= MotorbikesList.size()) {
        motorbike = MotorbikesList.get(choice - 1);
        if (motorbike != null) {
            motorbike.setStatus(true);

            LocalDateTime returnTime = LocalDateTime.now();

            for (RentLog rentLog : rentLogs) {
                if (rentLog.getMotorbike() == motorbike && rentLog.getEndTime() == null) {
                    rentLog.setEndTime(returnTime);
                    // rentLog.setOtherInfo(...);
                    System.out.println("Motorbike returned successfully!");
                    System.out.println("");
                    rentLog.displayBillGiveBack();
                    System.out.println("");
                    return motorbike;
                }
            }
            System.out.println("No matching rent log found.");
        } else {
            System.out.println("Invalid motorbike choice.");
        }
    } else {
        System.out.println("Invalid choice. Please try again.");
    }

    return motorbike; }


    //-----------------------------------------
    public Customer getCustomerByID(String id) {
        for (Customer customer : customers) {
            if (customer.getID().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    //-----------------------------------------
    public void displayRentLogs() {
        for (RentLog rentLog : rentLogs) {
            System.out.println(rentLog.toString());
            System.out.println("--------------------------------------");
        }
    }

    //-------------------------------------------
    public Vector<Vector<Object>> toVectorMotorbike() {
        Vector<Vector<Object>> v = new Vector<>();
        for (Motorbike m : MotorbikesList) {
            v.add(m.toVector());
        }
        return v;
    }

    //--------------------------------
    public Vector<Vector<Object>> toVectorAvailableMotorbike() {
        Vector<Vector<Object>> v = new Vector<>();
        for (Motorbike m : MotorbikesList) {
            if (m.isStatus() == true) {
                v.add(m.toVector());
            }
        }
        return v;
    }

    //--------------------------------
    public Vector<Vector<Object>> toVectorUnAvailableMotorbike() {
        Vector<Vector<Object>> v = new Vector<>();
        for (Motorbike m : MotorbikesList) {
            if (m.isStatus() != true) {
                v.add(m.toVector());
            }
        }
        return v;
    }
    
    //--------------------------------
    public Vector<Vector<Object>> toVectorCustomer() {
        Vector<Vector<Object>> v = new Vector<>();
        for (Customer c : customers) {
            v.add(c.toVector());
        }
        return v;
    }
    //--------------------------------
    public Vector<Vector<Object>> toVectorRentLog() {
        Vector<Vector<Object>> v = new Vector<>();
        for (RentLog r : rentLogs) {
            v.add(r.toVector());
        }
        return v;
    }

}
