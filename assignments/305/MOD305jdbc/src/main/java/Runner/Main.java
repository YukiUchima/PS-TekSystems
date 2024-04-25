package Runner;

import Controller.CarDao;
import Controller.GarageDao;
import Model.Cars;
import Model.Garages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        GarageDao garagesDao = new GarageDao();
        CarDao carsDao = new CarDao();

        Garages garage1 = new Garages();
        Garages garage2 = new Garages();
        Garages garage3 = new Garages();

        garage1.setLocation("5th Street / Broadway");
        garage2.setLocation("Kings / Turning Ln");
        garage3.setLocation("Hotdog on 111th");

        garagesDao.addGarage(garage1);
        garagesDao.addGarage(garage2);
        garagesDao.addGarage(garage3);

        displayGarages(garagesDao.getGarages());
        garagesDao.removeGarage(3);
        displayGarages(garagesDao.getGarages());

        Cars car1 = new Cars();
        Cars car2 = new Cars();
        Cars car3 = new Cars();

        car1.setParkingSpot("A01");
        car2.setParkingSpot("B02");
        car3.setParkingSpot("C03");

        car1.setGarageId(1);
        car2.setGarageId(2);
        car3.setGarageId(3);

        car1.setMakeModel("Honda Civic");
        car2.setMakeModel("Ford Explorer");
        car3.setMakeModel("Toyota Yaris");

        carsDao.addCar(car1);
        carsDao.addCar(car2);
        carsDao.addCar(car3);



        displayCars(carsDao.getCars());
        carsDao.removeCar(3);
        displayCars(carsDao.getCars());


    }

    static void displayCars(List<Cars> aList) {
        System.out.println("\n======================= CARS =======================");
        for (Cars thisCar : aList) {
            System.out.printf("%3d\t|\t%3d\t|\t%15s\t|\t%5s|\n", thisCar.getId(), thisCar.getGarageId(), thisCar.getMakeModel(), thisCar.getParkingSpot());
        }
    }

    static void displayGarages(List<Garages> aList) {
        System.out.println("\n====================== GARAGES ======================");
        for (Garages thisGarage : aList) {
            System.out.printf("%3d\t|\t%30s|\n", thisGarage.getId(), thisGarage.getLocation());
        }
    }
}