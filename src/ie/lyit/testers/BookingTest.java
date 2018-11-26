package ie.lyit.testers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.flight.Booking;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Passenger;

public class BookingTest {
	private Passenger p1;
	private Flight iF , oF;
	private Booking b, b2, b3;
	private ArrayList<Passenger> p;
	

	@Before
	public void setUp() throws Exception {
		iF = new Flight ("BR215","Derry", "Stanstead", 25, 12, 2018, 12, 40, 16.99);
		oF = new Flight ("BR445","Stanstead", "Derry", 30, 12, 2018, 20, 15, 16.99);
		p = new ArrayList<Passenger>();
		p1 = new Passenger();
		p.add(new Passenger("Ms", "Lisa", "Simpson", 20, 12, 1992, 1, true));
		p.add(new Passenger("Mr", "Damian", "Jason", 19, 01, 1980, 1, true));
		b = new Booking (oF , iF , p);
		b2 = new Booking();
		b3 = new Booking();
		//System.out.println (b.toString());
	}

	@Test
	public void testBookingFlightFlightArrayListOfPassenger() {
		
		assertEquals(b.getOutbound(), new Flight ("BR445","Stanstead", "Derry", 30, 12, 2018, 20, 15, 16.99));
		assertEquals(b.getInbound(), new Flight ("BR215","Derry", "Stanstead", 25, 12, 2018, 12, 40, 16.99));
		assertEquals(b.getPassengers(), p);
	}

	@Test
	public void testToString() {
		assertEquals (b.toString(),"Inbound flight: FLIGHT BR215 ==> Derry to Stanstead 25/12/2018 12:40 hours\nOutbound flight: FLIGHT BR445 ==> Stanstead to Derry 30/12/2018 20:15 hours\nPassenger: [Ms Lisa Simpson,20/12/1992 ==> 1 bags, Priority Boarding is true, Mr Damian Jason,19/1/1980 ==> 1 bags, Priority Boarding is true]\nTotal: 0.0") ;
		
	}

	@Test
	public void testFindPassenger() {
		assertEquals (b.findPassenger(p1) , false );
	}


	@Test
	public void testCalculatePrice() {
		assertEquals(67.96, b.calculatePrice(), 0);
	}

	@Test
	public void testSetOutbound() {
		b2.setOutbound(oF);
		assertEquals(new Flight ("BR445","Stanstead", "Derry", 30, 12, 2018, 20, 15, 16.99), b2.getOutbound());
	}

	@Test
	public void testSetInbound() {
		b3.setInbound(iF);
		assertEquals(new Flight ("BR215","Derry", "Stanstead", 25, 12, 2018, 12, 40, 16.99), b3.getInbound());
	}

	@Test
	public void testSetPassengers() {
		b2.setPassengers(p);
		assertEquals (p, b2.getPassengers());
	}

	@Test
	public void testSetTotalPrice() {
		b2.setInbound(iF);
		b2.setOutbound(oF);
		b2.setPassengers(p);
		b2.setTotalPrice();
		assertEquals (67.96, b2.getTotalPrice(), 0);
	}

}
