package com.car.rent;

import java.util.ArrayList;

public class RentCarRunner {
	
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) {
		
		Customer c = new Customer(0,"shyamu","Ramu","Z",1);
		c.add();
		c.print();
		
	}

}
