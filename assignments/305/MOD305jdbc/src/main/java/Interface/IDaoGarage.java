package Interface;

import Model.Garages;

import java.sql.Connection;
import java.util.List;

public interface IDaoGarage {

    List<Garages> getGarages();
    void addGarage(Garages garage);

    void removeGarage(int id);


}
