package glab30552b.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data       // automatically creates getter and setters
@NoArgsConstructor
//@RequiredArgsConstructor
//@NamedQuery(name="get_address_by_id", query = "FROM Address WHERE id = :pid ")
//@NamedQuery(name="get_all_address", query = "FROM Address ")
//@NamedQuery(name ="addAddress", query = "INSERT INTO ADDRESS(street) VALUES(?)")
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
