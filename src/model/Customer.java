package model;

import java.util.Vector;

public class Customer {

    private String ID;
    private String Name;

    //-----------------------
    public Customer(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public Customer() {
    }

    //-----------------------
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    //------------------------
    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", Name=" + Name + '}';
    }

    //------------------------
    public static Vector getTitle() {
        Vector v = new Vector();
        v.add("ID Number");
        v.add("Name");
        return v;

    }

    //----------------
    public Vector toVector() {
        Vector v = new Vector();
        v.add(this.ID);
        v.add(this.Name);
        return v;
    }
}
