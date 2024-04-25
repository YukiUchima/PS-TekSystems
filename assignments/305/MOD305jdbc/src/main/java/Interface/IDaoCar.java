package Interface;

import Model.Cars;

import java.util.List;

public interface IDaoCar {

    List<Cars> getCars();
    void addCar(Cars car);

    void removeCar(int id);
}
