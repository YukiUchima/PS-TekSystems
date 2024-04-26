package daosetup.controller;

import daosetup.DAOinterface.IReviewDaoInterface;
import daosetup.DAOinterface.ReviewConnection;
import daosetup.model.EmployeePerformanceReview;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewsImplReview extends ReviewConnection implements IReviewDaoInterface {

    public ReviewsImplReview() {
        try {
            Connection connection = ReviewConnection.connectDB();
            String connectionQuery1 = "DROP TABLE IF EXISTS employeeperformancereviews";
            String connectionQuery2 = "CREATE TABLE EmployeePerformanceReviews (\n reviewId INT AUTO_INCREMENT " +
                    "PRIMARY KEY,\n" +
                    "employeeNumber INT NOT NULL,\n" +
                    "reviewText TEXT,\n" +
                    "FOREIGN KEY (employeeNumber) REFERENCES Employees(employeeNumber))";

            Statement stmt = connection.createStatement();
            stmt.addBatch(connectionQuery1);
            stmt.addBatch(connectionQuery2);
            stmt.executeBatch();

            System.out.println("Table connected successfully...");
        } catch (ClassNotFoundException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } catch (SQLException e) {
            System.out.printf("SQL Error: %s\n", e.getMessage());
        }
    }

    @Override
    public void insertPerformanceReview(EmployeePerformanceReview review) {
        try {
            Connection conn = ReviewConnection.connectDB();
            String qry = "INSERT INTO EmployeePerformanceReviews(employeeNumber, reviewText) VALUES (?,?) ";
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setInt(1, review.getEmployeeNumber());
            ps.setString(2, review.getReviewText());
            int affectedRows = ps.executeUpdate();
            System.out.printf("Updated %d row(s)!\n", affectedRows);

        } catch (SQLException e) {
            System.out.printf("SQL exception: %s%n", e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.printf("Exception: %s%n", e.getMessage());
        }
    }

    @Override
    public List<EmployeePerformanceReview> getAllPerformanceReviews() {
        try {
            Connection conn = ReviewConnection.connectDB();
            String sqlQry = "SELECT * FROM EmployeePerformanceReviews";
            PreparedStatement ps = conn.prepareStatement(sqlQry);
            ResultSet rs = ps.executeQuery();
            List reviewList = new ArrayList();

            while (rs.next()) {
                EmployeePerformanceReview theReview = new EmployeePerformanceReview();
                theReview.setReviewId(rs.getInt("reviewid"));
                theReview.setEmployeeNumber(rs.getInt("employeenumber"));
                theReview.setReviewText(rs.getString("reviewText"));
                reviewList.add(theReview);
            }
            return reviewList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePerformanceReview(int revId) {
        try {
            Connection conn = ReviewConnection.connectDB();
            String qry = "DELETE FROM EmployeePerformanceReviews WHERE reviewId=?";
            PreparedStatement ps = conn.prepareStatement(qry);
            ps.setInt(1, revId);
            int updatedRows = ps.executeUpdate();

            if (updatedRows == 1) {
                System.out.println("Successfully DELETED!");
            } else {
                System.out.printf("Unable to delete entry at %s", revId);
            }
        } catch (SQLException e) {
            System.out.println("UNABLE TO DELETE REVIEW");
            System.out.printf("SQL Exception: %s%n", e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
