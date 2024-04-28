package reviewSession0428.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passId;
    private String name;

    @ManyToMany(cascade=CascadeType.ALL, mappedBy="passengerSet")
    private Set<Flight> flightSet = new HashSet<>();

    public void addFlight(Flight flight) {
        this.flightSet.add(flight);
        flight.getPassengerSet().add(this); //bidirectional
    }

    public Passenger (String name){
        this.name = name;
    }




}
