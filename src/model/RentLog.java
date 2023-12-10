package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Vector;
import model.Customer;
import model.Motorbike;

public class RentLog {

    private Customer customer;
    private Motorbike motorbike;
    private Date startTime;
    private Date endTime;
    private Double total;
    private String descriptor;

    public RentLog(Customer customer, Motorbike motorbike, Double total, String descriptor) {
        this.customer = customer;
        this.motorbike = motorbike;
        this.total = total;
        this.descriptor = descriptor;
        this.startTime = new Date();
        this.endTime = null;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Motorbike getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Motorbike motorbike) {
        this.motorbike = motorbike;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public RentLog() {

    }

    public void endRental() {
        this.endTime = new Date();
    }

    //-----------------------------------------
    public void displayBillRent() {
    System.out.println("Rent Bill");
    System.out.println("------------------------------");
    
    if (customer != null) {
        System.out.println("ID Customer: " + customer.getID());
        System.out.println("Name: " + customer.getName());
    } else {
        System.out.println("Customer information missing.");
    }
    
    if (motorbike != null) {
        System.out.println("Motorbike name: " + motorbike.getBrandName());
        System.out.println("License plate: " + motorbike.getLicensePlate());
    } else {
        System.out.println("Motorbike information missing.");
    }
    
    if (startTime != null) {
        System.out.println("Rental start time: " + startTime.toString());
    } else {
        System.out.println("Rental start time missing.");
    }
    
    if (descriptor != null) {
        System.out.println("Describe: " + descriptor);
    } else {
        System.out.println("Descriptor information missing.");
    }
        System.out.println("**Note: If you lose motorbike, you must pay "+motorbike.getPrice()+" for it");
}

    //FOR GUI
    public String displayBillRentforGUI() {
    StringBuilder billMessage = new StringBuilder();
    billMessage.append("Rent Bill\n");
    billMessage.append("------------------------------\n");

    if (customer != null) {
        billMessage.append("ID Customer: ").append(customer.getID()).append("\n");
        billMessage.append("Name: ").append(customer.getName()).append("\n");
    } else {
        billMessage.append("Customer information missing.\n");
    }

    if (motorbike != null) {
        billMessage.append("Motorbike name: ").append(motorbike.getBrandName()).append("\n");
        billMessage.append("License plate: ").append(motorbike.getLicensePlate()).append("\n");
    } else {
        billMessage.append("Motorbike information missing.\n");
    }

    if (startTime != null) {
        billMessage.append("Rental start time: ").append(startTime.toString()).append("\n");
    } else {
        billMessage.append("Rental start time missing.\n");
    }

    if (descriptor != null) {
        billMessage.append("Describe: ").append(descriptor).append("\n");
    } else {
        billMessage.append("Descriptor information missing.\n");
    }

//    if (motorbike != null && motorbike.getPrice() != null) {
//        billMessage.append("**Note: If you lose motorbike, you must pay ").append(motorbike.getPrice()).append(" for it\n");
//    } else {
//        billMessage.append("Motorbike price information missing.\n");
//    }

    return billMessage.toString();
}


    //-----------------------------------------
    public void displayBillGiveBack() {
    if (startTime != null && endTime != null) {
        long diffInMillies = Math.abs(endTime.getTime() - startTime.getTime());
        double diffInDays = Math.ceil(diffInMillies / (24.0 * 60 * 60 * 1000)); 

        double rentPrice = motorbike.getRentPrice(); 

        System.out.println("Give Back Bill");
        System.out.println("------------------------------");
        System.out.println("ID Customer: " + customer.getID());
        System.out.println("Name: " + customer.getName());
        System.out.println("Motorbike name: " + motorbike.getBrandName());
        System.out.println("License plate: " + motorbike.getLicensePlate());
        System.out.println("Describe: " + descriptor);
        System.out.println("Rental start time: " + startTime.toString());
        System.out.println("Rental end time: " + endTime.toString());
        System.out.println("Rental duration (days): " + diffInDays);
        System.out.println("Rent price per day: " + rentPrice); 
        System.out.println("------------------------------");
        System.out.println("Total amount: " + (diffInDays * rentPrice)); 
        
    } else {
        System.out.println("Cannot generate bill. Rental information incomplete.");
    }
}




    @Override
    public String toString() {
        String totalString = (total != null) ? total.toString() : "Not paid";
        String endTimeString = (endTime != null) ? endTime.toString() : "No return";

        return "Rent Logs"
                + "\nName: " + customer.getName()
                + "\nCustomer ID number: " + customer.getID()
                + "\nLicense plate: " + motorbike.getLicensePlate()
                + "\nMotorbike ID: " + motorbike.getID()
                + "\nRental start time: " + startTime.toString()
                + "\nLease end time: " + endTimeString
                + "\nTotal amount: " + (total != null ? total.toString() : "Not pay")
                + "\nDescribe: " + descriptor;
    }

    public void setEndTime(LocalDateTime returnTime) {
        this.endTime = java.sql.Timestamp.valueOf(returnTime);
    }
//-------------------------
    public static Vector getTitle() {
        Vector v = new Vector();
        v.add("Name");
        v.add("ID Number");
        v.add("License Plate");
        v.add("Motorbike ID");
        v.add("Rental start time");
        v.add("Lease end time");
        v.add("Total amount");
        v.add("Describe");
        return v;

    }

    //----------------
    public Vector toVector() {
    Vector v = new Vector();
    v.add(customer.getName());
    v.add(customer.getID());
    v.add(motorbike.getLicensePlate());
    v.add(motorbike.getID());
    v.add(startTime.toString());

    if (endTime != null) {
        v.add(endTime.toString());
    } else {
        v.add("No return"); // Provide a default value or handle it as needed
    }

    v.add((total != null ? total.toString() : "Not pay"));
    v.add(descriptor);
    return v;
}

    //---------------------------
}

