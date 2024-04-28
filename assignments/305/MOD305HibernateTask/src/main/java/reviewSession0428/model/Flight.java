package reviewSession0428.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fdId;
    private int flightNum;

//  Default constructor - Accounted for with @NoArgsConstructor
//    public Flight(){};

    public Flight(int flightNum){
        this.flightNum = flightNum;
        this.passengerSet = new HashSet<>();
    };

//  Many (Flights) To One (Airline)
    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "airline_id")         // foreign key: airline_id
    private Airline airline;

    @ManyToMany(cascade=CascadeType.ALL)  //bidirectional
    @JoinTable(name = "Flight_Join_Passengers", joinColumns = @JoinColumn(name="flight_id"), inverseJoinColumns = @JoinColumn(name="pid"))
    private Set<Passenger> passengerSet;

    public void addPassenger(Passenger passenger) {
        this.passengerSet.add(passenger);
        passenger.getFlightSet().add(this); //bidirectional
    }






}
