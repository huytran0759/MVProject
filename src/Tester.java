import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        // run all tests and add to fakeness score if passes
        int correctFake = 0;
        int total = 0;
        ArrayList<Review> reviews = TextAnalysis.readReviews("data/amazon_reviews.txt");
        for (Review review : reviews) {
            runAllTests(review);
            if (review.getLabel().equals("__label1__")) {
                total++;
            }
            if (review.isFake() && review.getLabel().equals("__label1__")) {
                correctFake++;
            }
        }

        System.out.println((double) correctFake / total);

    }

    public static void runAllTests(Review review) {
        if (FakeReviewTests.containsLink(review)) {
            review.addToFakeScore(1);
            System.out.println("link");
        }
//        if (FakeReviewTests.containsExtremeLanguage(review)) {
//            review.addToFakeScore(1);
//            System.out.println("language");
//        }
        if (FakeReviewTests.containsThreeExclamations(review)) {
            review.addToFakeScore(1);
            System.out.println("exclaim");
        }
        if (FakeReviewTests.isSponsored(review)) {
            review.addToFakeScore(1);
            System.out.println("sponsored");
        }
//        if (FakeReviewTests.failsLengthTest(review)) {
//            review.addToFakeScore(1);
//            System.out.println("length");
//        }
    }
}
