package dao;

import model.Employee;
import model.Product;
import main.Shop;

import java.util.ArrayList;

public class DaoFile implements Dao {

    public void connect() {System.out.println("Opening file...");}
    public void disconnect() {System.out.println("Closing file...");}
    public Employee getEmployee(int employeeId,String password) {
        System.out.println("Getting employee from file...");
        return null;
    }

    String filePathInventory = "src/data/inputInventory.txt";

    public ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        System.out.println("Getting inventory from file...");
        // Read the file and populate the inventory list
        // For now, we will just return an empty list
        return inventory;
    }
    
}
