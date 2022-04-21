package com.xworkz.fileapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import static com.xworkz.fileapp.DBConstants.*;
public class Application {
	private int id;
	private String name;
	
	public void readData() {
		
		
		File file=new File("C:/Users/Ruchi Chachriya/HTML/Application.txt");
		try {
			Scanner data=new Scanner(file);
			while(data.hasNextLine()) {
				name="";
				String line=data.nextLine();
				while(data.hasNextInt()) {
					id=data.nextInt();
				}
				if(!data.hasNextInt()) {
					name=" "+data.next();	
				}	
				//System.out.println(id + " "+name);
				saveData();
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void saveData() {
		Connection con=null;
		PreparedStatement prep=null;
		
		try {
			con=DriverManager.getConnection(JDBC_URL,USERNAME, PASSWORD);
			prep=con.prepareStatement("INSERT INTO applications VALUES(?,?)");
			prep.setInt(1, id);
			prep.setString(2, name);
			prep.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

