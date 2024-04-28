package bookrelationshipdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity         // persists table in database into existence
@Data           // lombok - set getter/setters, and requiredArgsConstructor
@NoArgsConstructor
public class Biography {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // sets column name to bioId
    @Column(name = "bioId")
    private Long id;
    private String bio;

    public Biography(String bio) {
        this.bio = bio;
    }

}
