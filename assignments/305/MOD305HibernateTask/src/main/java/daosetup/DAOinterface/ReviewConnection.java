package daosetup.DAOinterface;

import java.sql.*;

public class ReviewConnection {

    static Connection conn = null;

    protected PreparedStatement ps = null;

    protected ResultSet rs = null;

    public static Connection connectDB() throws ClassNotFoundException{
        final String dburl = "jdbc:mysql://localhost:3306/classicmodels?createDatabaseIfNotExist=true";
        final String user = "root";
        final String pass = "admin";
        try {
            conn = DriverManager.getConnection(dburl, user, pass);
//            System.out.println("Connected to DB successfully!");

        } catch (SQLException e) {
            System.out.printf("SQL Error: %s\n", e.getMessage());
        }

        return conn;
    }

    public void disconnect() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
