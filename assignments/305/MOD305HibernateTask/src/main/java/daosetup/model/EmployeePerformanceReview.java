package daosetup.model;

public class EmployeePerformanceReview {
    private int reviewId;
    private int employeeNumber;
    private String reviewText;

    public EmployeePerformanceReview() {

    }

    public EmployeePerformanceReview(int employeeNumber, String reviewText) {
        this.employeeNumber = employeeNumber;
        this.reviewText = reviewText;
    }

    public EmployeePerformanceReview(int reviewId, int employeeNumber, String reviewText) {
        this.reviewId = reviewId;
        this.employeeNumber = employeeNumber;
        this.reviewText = reviewText;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
