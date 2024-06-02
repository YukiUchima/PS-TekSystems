package Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AddressId;
    private String street;
    private String city;
    private String state;
    private int zipcode;

    public Address(String street, String city, String state, int zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zip;
    }
}
