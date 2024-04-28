package reviewSession0428;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import reviewSession0428.model.Airline;
import reviewSession0428.model.Flight;
import reviewSession0428.model.Passenger;

import javax.swing.text.html.parser.Entity;



public class MainRunner {

    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure("flightdb.cfg.xml").buildSessionFactory();
        Session session = sf.openSession();

        try {
            start(session);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
            sf.close();
        }
    }

    static void start(Session session){
//      Airline, flight
        Airline airline1 = new Airline();
        Airline airline2 = new Airline();

        airline1.setAirlineName("American Airlines");
        airline2.setAirlineName("Delta Airlines");

        Flight aa01 = new Flight(1);
        Flight aa02 = new Flight(2);
        Flight aa03 = new Flight(3);
        Flight delta10 = new Flight(10);
        Flight delta11 = new Flight(11);

        aa01.setAirline(airline1);
        aa02.setAirline(airline1);
        aa03.setAirline(airline1);
        delta10.setAirline(airline2);
        delta11.setAirline(airline2);
        
//      Adding the FLIGHTS to the airline's list
        airline1.addFlight(aa01);
        airline1.addFlight(aa02);
        airline1.addFlight(aa03);

        airline2.addFlight(delta10);
        airline2.addFlight(delta11);
        
//      Add Passengers to flights
        Passenger passenger1 = new Passenger("Bob Smith");
        Passenger passenger2 = new Passenger("Suzie Jones");
        Passenger passenger3 = new Passenger("Albert Einstein");

        passenger1.addFlight(aa01);
        passenger1.addFlight(delta10);
        passenger2.addFlight(aa02);
        passenger3.addFlight(aa01);
        passenger3.addFlight(aa02);
        passenger3.addFlight(aa03);
        passenger3.addFlight(delta11);




//      Use when persisting and Updating/Deleting
        Transaction t = session.beginTransaction();

        try {
//            session.persist(airline1);
//            session.persist(airline2);

            session.persist(aa01);      // Persisting the flight will also persist the airline due to cascade.all
            session.persist(aa02);
            session.persist(aa03);

            session.persist(delta10);
            session.persist(delta11);

            session.persist(passenger1);
            session.persist(passenger2);
            session.persist(passenger3);

            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (t != null) {
                t.rollback();
            }
        }
    };
}
