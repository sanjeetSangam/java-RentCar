package com.car.rent;

import java.util.ArrayList;

public class RentCarRunner {
	
	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	public static void main(String[] args) {
		
		Customer c = new Customer(0,"Sanjeet","12354567891234567","919006079833",1);
		c.print();
	}

}
