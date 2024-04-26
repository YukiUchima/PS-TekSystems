package daosetup;

import daosetup.controller.ReviewsImplReview;
import daosetup.model.EmployeePerformanceReview;

public class AccessReview {

// Create JDBC-ORM example for Employee Performance Review's:
// 1.Create the model "EmployeePerformanceReview" with the following fields
//      private int reviewId;(PK)
//      private int employeeNumber;(FK will map to employees table)
//      private String reviewText;
// 2. Create the DAO interface with the following method's:
//      void insertPerformanceReview(EmployeePerformanceReview review);
//      List<EmployeePerformanceReview> getAllPerformanceReviews();
//      void deletePerformanceReview(int reviewId);
// 3. Create the DAO implementation that implements the DAO interface
// 4. In the you MainRunner(entry point) class create two different reviews of two different employees

//SCHEMA
//CREATE TABLE IF NOT EXISTS EmployeePerformanceReviews (
//        reviewId INT AUTO_INCREMENT PRIMARY KEY,
//        employeeNumber INT NOT NULL,
//        reviewText TEXT,
//        FOREIGN KEY (employeeNumber) REFERENCES Employees(employeeNumber));

    public static void main(String[] args) {
        ReviewsImplReview myReview = new ReviewsImplReview();

        System.out.println("----------------- INSERTING REVIEWS -----------------");

        EmployeePerformanceReview review1 = new EmployeePerformanceReview();
        String reviewTxt = "Amazing Employee, spends hours on projects, without requesting a raise!";
        review1.setReviewText(reviewTxt);
        review1.setEmployeeNumber(1002);

        EmployeePerformanceReview review2 = new EmployeePerformanceReview();
        reviewTxt = "Employee wants a raise...";
        review2.setReviewText(reviewTxt);
        review2.setEmployeeNumber(1056);

        EmployeePerformanceReview review3 = new EmployeePerformanceReview();
        reviewTxt = "Let's delete this review...";
        review3.setReviewText(reviewTxt);
        review3.setEmployeeNumber(1076);


//        myReview.insertPerformanceReview(review1);
//        myReview.insertPerformanceReview(review2);
//        myReview.insertPerformanceReview(review3);


        System.out.println("=========== Display All Reviews ===========");
        try{
            for (EmployeePerformanceReview rev : myReview.getAllPerformanceReviews()) {
                int employeeNumber = rev.getEmployeeNumber();
                String revTxt = rev.getReviewText();
                System.out.printf("Employee ID: %d\n\tReview: %s\n", employeeNumber, revTxt);
            }
        }catch(Exception e){
            e.getMessage();
        }

        System.out.println("=========== Display All Reviews After Deletion===========");
        myReview.deletePerformanceReview(3);
        try{
            for (EmployeePerformanceReview rev : myReview.getAllPerformanceReviews()) {
                int employeeNumber = rev.getEmployeeNumber();
                String revTxt = rev.getReviewText();
                System.out.printf("Employee ID: %d\n\tReview: %s\n", employeeNumber, revTxt);
            }
        }catch(Exception e){
            e.getMessage();
        }

        myReview.disconnect();
    }
}
