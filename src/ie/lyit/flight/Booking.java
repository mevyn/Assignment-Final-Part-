package ie.lyit.flight;

import java.util.ArrayList;

import ie.lyit.flight.*;

public class Booking {

	private Flight outbound;
	private Flight inbound;
	private ArrayList<Passenger> passengers;
	private double totalPrice;
	private static int count;
	
	public Booking () {
		outbound = new Flight();
		inbound = new Flight();
		passengers = new ArrayList<Passenger>();
		totalPrice = 0.00;
		count ++ ;
		}
	
	public Booking (Flight oF , Flight  iF , ArrayList<Passenger> p) {
		inbound = iF;
		outbound = oF;
		passengers = p;
		count++;	
		totalPrice = this.getTotalPrice();
		
		}
	
	public String toString(){
		   return "Inbound flight: " + inbound + "\nOutbound flight: " + outbound + "\nPassenger: " + passengers + "\nTotal: " + totalPrice;
		}
	
	public boolean equals(Object obj){
		   Booking bObject;
		   if (obj instanceof Booking)
		      bObject = (Booking)obj;
		   else
		       return false;
		 
		   return (this.count == bObject.count);
		}

	public boolean findPassenger(Passenger p) {
			boolean foundPassenger = false;
			for (Passenger passenger : passengers){
				if (p.equals(passengers.indexOf(p))) {
					foundPassenger = true;
				}
			}
			return foundPassenger;
		}
	public double calculatePrice() {
			totalPrice = (outbound.getPrice() + inbound.getPrice()) * passengers.size();
		
			return totalPrice;
		}
	

	public Flight getOutbound() {
			return outbound;
		}

	public void setOutbound(Flight outbound) {
			this.outbound = outbound;
		}

	public Flight getInbound() {
			return inbound;
		}

	public void setInbound(Flight inbound) {
			this.inbound = inbound;
		}

	public ArrayList<Passenger> getPassengers() {
			return passengers;
		}

	public void setPassengers(ArrayList<Passenger> passengers) {
			this.passengers = passengers;
		}

	public double getTotalPrice() {
			return totalPrice;
		}

	public void setTotalPrice() {
			this.totalPrice = this.calculatePrice();
		}
}
