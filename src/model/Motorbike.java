package model;

import java.util.ArrayList;
import java.util.Vector;


public class Motorbike {

    private int ID;
    private String licensePlate;
    private String brandName;
    private double rentPrice;
    private double Price;
    private boolean status;

    //-----------------------------
    public Motorbike(int ID, String licensePlate, String brandName, double rentPrice, double Price, boolean status) {
        this.ID = ID;
        this.licensePlate = licensePlate;
        this.brandName = brandName;
        this.rentPrice = rentPrice;
        this.Price = Price;
        this.status = status;
    }

    public Motorbike() {

    }

    //-----------------------------   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //--------------------------
    @Override
    public String toString() {
        return "ID:" + ID + " - licensePlate:" + licensePlate + " - brandName:" + brandName + " - rentPrice:" + rentPrice + " - Price:" + Price + " - status:" + (isStatus()?"Not rented yet":"Rented");
    }

    //-------------------------
    public static Vector getTitle() {
        Vector v = new Vector();
        v.add("ID");
        v.add("License Plate");
        v.add("Brand Name ");
        v.add("Rent Price");
        v.add("Price");
        v.add("Status");
        return v;

    }

    //----------------
    public Vector toVector() {
        Vector v = new Vector();
        v.add(this.ID);
        v.add(this.licensePlate);
        v.add(this.brandName);
        v.add(this.rentPrice);
        v.add(this.Price);
        v.add(this.status);
        v.add(Boolean.FALSE);
        return v;
    }
    //---------------------------
}
