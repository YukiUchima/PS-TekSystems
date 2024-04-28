package reviewSession0428.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
public class Airline {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY) //--> Auto - Generates Primary Key
    private int id;
    private String airlineName;

//    Default constructor (Blank)
    public Airline(){
        // blank
    };
    public Airline(String aName){
        this.airlineName = aName;
    };

  //One (Airline) to Many (Flights)
    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL) //bidirectional
    //@JoinTable(name="airline_join_flight", joinColumns = @JoinColumn(name="airline_id"), inverseJoinColumns = @JoinColumn(name="flight_id") )
    private List<Flight> flightList = new ArrayList<>();

    public void addFlight(Flight flight) {
        this.flightList.add(flight);
        flight.setAirline(this);
    }


}
