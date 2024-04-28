package glab30552b.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cohortId;
    private String cohortName;
    private String duration;

    public Cohort(String cName, String duration) {
        cohortName = cName;
        this.duration = duration;
    }
}
