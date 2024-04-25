package Controller;

import Interface.DBConnector;
import Interface.IDaoCar;
import Model.Cars;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao extends DBConnector implements IDaoCar {
    public CarDao() {
        try (Connection conn = DBConnector.setConnection()) {
            String qry1 = "DROP TABLE IF EXISTS cars;";
            String qry2 = "CREATE TABLE cars(id int PRIMARY KEY auto_increment," +
                    "parkingSpot VARCHAR(3)," +
                    "makeModel VARCHAR(20)," +
                    "garageId int" +
//                    "FOREIGN KEY (garageid) REFERENCES garages(id)" +
//                    "ON DELETE CASCADE" +
                    ");";

            Statement stmt = conn.createStatement();
            stmt.addBatch(qry1);
            stmt.addBatch(qry2);
            stmt.executeBatch();

            System.out.println("Connected Successfully to Cars Table!");
        } catch (SQLException e) {
            System.out.printf("Issue Connecting in cars... %s\n", e.getMessage());
        }
    }


    @Override
    public List<Cars> getCars() {
        try (Connection conn = DBConnector.setConnection()) {
            String qry = "SELECT * FROM cars";
            PreparedStatement ps = conn.prepareStatement(qry);

            ResultSet rs = ps.executeQuery();

            List<Cars> carList = new ArrayList<>();
            while (rs.next()) {
                Cars currentCar = new Cars();
                currentCar.setId(rs.getInt("id"));
                currentCar.setParkingSpot(rs.getString("parkingspot"));
                currentCar.setMakeModel(rs.getString("makemodel"));
                currentCar.setGarageId(rs.getInt("garageid"));

                carList.add(currentCar);
            }
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCar(Cars car) {
        try (Connection conn = DBConnector.setConnection()) {
            String qry = "INSERT INTO cars(parkingspot, makemodel, garageid) VALUES(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(qry);

            ps.setString(1, car.getParkingSpot());
            ps.setString(2, car.getMakeModel());
            ps.setInt(3, car.getGarageId());

            int rows = ps.executeUpdate();
            System.out.printf("Added %d rows into Cars TABLE!\n", rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCar(int id) {
        try (Connection conn = DBConnector.setConnection()) {
            String qry = "DELETE FROM cars WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(qry);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.printf("Removed %d rows from Cars TABLE!\n", rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
