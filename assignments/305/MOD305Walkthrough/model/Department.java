package model;

//❑ Using Hibernate, create a Department Model with the following attributes:
// ➢ int id
// ➢ String name
// ➢ String state
//❑ Using Hibernate, create the relevant services for this Model (create, update name/state, find, and delete).
//❑ Do not forget to add your model to the configuration file (hibernate.cfg.xml).

import jakarta.persistence.*;


@Entity
@Table(name = "Department")
public class Department {

    @Id
//  GeneratedValue generates the primary key for column 'id'
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String name;
    private String state;

    public Department() {

    }

    public Department(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
