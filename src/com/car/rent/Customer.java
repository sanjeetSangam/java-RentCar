package com.car.rent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer extends Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int bill;
	
	
	public Customer() {
		super();
	}
	
	
	public Customer(int id,  String name, String aadhar, String contact, int bill) {
		super(id, aadhar, name, contact);
		
		
		if (isNameValid(name) && isAadharValid(aadhar) && isContactValid(contact) && isIDValid(id)) {
			this.bill =bill;
			this.add();
		} else {
			System.out.println("Please provide valid information");
		}
	}
	
	
	
	public static ArrayList<Customer> searchByName(String name)
	{
		ArrayList<Customer> customerList = Customer.View() ;
		
		ArrayList<Customer> result = new ArrayList<>();
		for(int i=0; i<customerList.size(); i++)
		{
			
			if(customerList.get(i).name.equalsIgnoreCase(name))
			{
				result.add(customerList.get(i));
			}
		}
		
		return result;
	}
	
	
	
	public static Customer searchByAadhar(String aadhar)
	{
		// code
	}
	
	public static Customer searchByID(int id)
	{
    ArrayList<Customer> customerList = Customer.View() ;
		
		for(int i=0; i<customerList.size(); i++)
		{
			if(customerList.get(i).id==id)
			{
				return customerList.get(i));
			}
		}
		
		return null;
	}
	
	

	@Override
	public void add() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customerList = Customer.View() ;

		
		if(customerList.isEmpty()) {
			this.id = 1;
		}
		else {
			int last_person_id = customerList.get(customerList.size()-1).id + 1;
			this.id = last_person_id;
		}
		
		customerList.add(this);
		
		
		File file = new File("Customer.txt");
		System.out.println("Created");
		
		if(file.exists() == false) {
			try {
				file.createNewFile();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		FileOutputStream fo;
		
		try {
		fo = new FileOutputStream(file);
		ObjectOutputStream outputStream = new ObjectOutputStream(fo);
		
			for(int i=0; i<customerList.size();i++)
			{
				outputStream.writeObject(customerList.get(i));
			}
			
			outputStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	
	
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
		ArrayList<Customer> customerList = Customer.View() ;
		
		for(int i=0; i<customerList.size(); i++)
		{
			if(customerList.get(i).id == this.id)
			{
				customerList.remove(i);
			}
		}
		
		
		
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
		ArrayList<Customer> customerList = Customer.View() ;
		
		for(Customer c : customerList)
		{
			System.out.println(c);
		}
		
	}
	
	
	public static ArrayList<Customer> View(){
		ArrayList<Customer> customerList = new ArrayList<>();
		
		FileInputStream fi;
		
		try {
			fi = new FileInputStream("Customer.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fi);
			
			boolean EOF = false;
			while(EOF != true)
			{
				Customer obj = (Customer) inputStream.readObject();
				customerList.add(obj);
			}
			
			inputStream.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return customerList;
	}
	

}
