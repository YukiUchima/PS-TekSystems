package Interface;


import java.sql.*;

public class DBConnector {
    static Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    public static Connection setConnection() {
        final String dburl = "jdbc:mysql://localhost:3306/GarageDemo?createDatabaseIfNotExist=true";
        final String user = "root";
        final String password = "admin";

        try {
            Connection conn = DriverManager.getConnection(dburl, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.printf("Issue when connecting to DB: %s\n", e.getMessage());

        }
        return conn;
    }

    public void disconnect(){
        try {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.printf("Issue when disconnecting and closing: %s\n", e.getMessage());
        }
    }
}
