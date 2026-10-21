package dao;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;

import model.Amount;
import model.Employee;
import model.Product;
import main.Shop;

import java.util.ArrayList;

public class DaoImpFile implements Dao {
    public void connect() {System.out.println("Opening file...");}
    public void disconnect() {System.out.println("Closing file...");}
    public Employee getEmployee(int employeeId,String password) {
        System.out.println("Getting employee from file...");
        return null;
    }

    String filePathInventory = "src/data/inputInventory.txt";

    public ArrayList<Product> getInventory() throws IOException {
		File f = new File(System.getProperty("user.dir") + File.separator + "files/inputInventory.txt");
		ArrayList<Product> extract_inventory = new ArrayList<>();
		try {			
			FileReader fr;
			fr = new FileReader(f);				
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				String[] sections = line.split(";");
				String name = "";
				double wholesalerPrice=0.0;
				
				int stock = 0;
				for (int i = 0; i < sections.length; i++) {
					String[] data = sections[i].split(":");
					
					switch (i) {
					case 0:
						name = data[1];
						break;
						
					case 1:
						wholesalerPrice = Double.parseDouble(data[1]);
						break;
						
					case 2:
						stock = Integer.parseInt(data[1]);
						break;
						
					default:
						break;
					}
				}
				
				extract_inventory.add(new Product(name, new Amount(wholesalerPrice), true, stock));
				
				// read next line
				line = br.readLine();
			}
			fr.close();
			br.close();
			return extract_inventory;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return extract_inventory;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return extract_inventory;
		}
    }
    
    public boolean writeInventory(ArrayList<Product> inventory) throws IOException {
		// Nombre: inventory_yyyy-MM-dd.txt dentro de la carpeta "files"
		String fileName = "inventory_" + LocalDate.now() + ".txt"; // LocalDate.now() ya da yyyy-MM-dd
		File folder = new File(System.getProperty("user.dir") + File.separator + "files");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File f = new File(folder, fileName);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
			int id = 1;
			for (Product product : inventory) {
				bw.write(id + ";Product:" + product.getName() + ";Stock:" + product.getStock() + ";");
				bw.newLine();
				id++;
			}
			bw.write("Total number of products:" + inventory.size() + ";");
			bw.newLine();
			return true;
		} 
		catch (FileNotFoundException e){return false;} 
		catch (IOException e){return false;}
	}
}
