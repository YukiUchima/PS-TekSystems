package daosetup.DAOinterface;



import daosetup.model.EmployeePerformanceReview;

import java.util.List;

public interface IReviewDaoInterface {
    void insertPerformanceReview(EmployeePerformanceReview review);

    List<EmployeePerformanceReview> getAllPerformanceReviews();

    void deletePerformanceReview(int reviewId);
}
