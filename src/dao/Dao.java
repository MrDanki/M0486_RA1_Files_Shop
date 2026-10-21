package dao;

import model.Product;
import model.Employee;

import java.io.IOException;
import java.util.ArrayList;

public interface Dao {
	
	public void connect();

	public void disconnect();

	public Employee getEmployee(int employeeId, String password);

	public boolean writeInventory(ArrayList<Product> inventory) throws IOException;
}
