package Controller;

import Interface.DBConnector;
import Interface.IDaoGarage;
import Model.Garages;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GarageDao extends DBConnector implements IDaoGarage {

    public GarageDao(){
        try (Connection conn = DBConnector.setConnection()) {
            String qry1 = "DROP TABLE IF EXISTS garages;";
            String qry2 = "CREATE TABLE garages(" +
                    "id int PRIMARY KEY auto_increment," +
                    "location VARCHAR(50)" +
                    ");";

            Statement stmt = conn.createStatement();
            stmt.addBatch(qry1);
            stmt.addBatch(qry2);
            stmt.executeBatch();
            System.out.println("Successfully Connected to Garage Table!");
        } catch (SQLException e) {
            System.out.printf("Issue Connecting in garage while instantiating... %s\n", e.getMessage());
        }
    }
    @Override
    public List<Garages> getGarages() {
        List<Garages> garageList = new ArrayList<>();
        try (Connection conn = DBConnector.setConnection()){
            String qry = "SELECT * FROM garages";
            PreparedStatement ps = conn.prepareStatement(qry);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Garages currentGarage = new Garages();

                currentGarage.setId(rs.getInt("id"));
                currentGarage.setLocation(rs.getString("location"));

                garageList.add(currentGarage);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.printf("Issue Connecting in garage... %s\n", e.getMessage());
        }
        return garageList;
    }

    @Override
    public void addGarage(Garages garage) {
        try (Connection conn = DBConnector.setConnection()) {
            String qry = "INSERT INTO garages(location) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(qry);

            ps.setString(1, garage.getLocation());

            int rows = ps.executeUpdate();
            System.out.printf("Inserted %d row(s) into Garage Table!\n", rows);
        } catch (SQLException e) {
            System.out.printf("Issue Connecting in garage... %s\n", e.getMessage());
        }
    }

    @Override
    public void removeGarage(int id) {
        try (Connection conn = DBConnector.setConnection()) {
            String qry = "DELETE FROM garages WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(qry);

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            System.out.printf("Removed %d row(s) from Garage Table!\n", rows);
        } catch (SQLException e) {
            System.out.printf("Issue Connecting in garage... %s\n", e.getMessage());
        }
    }
}
