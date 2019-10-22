import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        // run all tests and add to fakeness score if passes
        ArrayList<Review> reviews = TextAnalysis.readReviews("data/amazon_reviews.txt");
        for (Review review : reviews) {
            if (FakeReviewTests.containsLink(review)) {

            }
        }

    }
}
