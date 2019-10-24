import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        // run all tests and add to fakeness score if passes
        int correct = 0;
        ArrayList<Review> reviews = TextAnalysis.readReviews("data/amazon_reviews.txt");
        for (Review review : reviews) {
            runAllTests(review);
            if (review.isFake() && review.getLabel().equals("__label1__") || !review.isFake() && review.getLabel().equals("__label2__")) {
                correct++;
            } else {
                System.out.println(review.getReviewText());
                System.out.println("************************************************");
            }
        }

        System.out.println((double) correct / reviews.size());

    }

    public static void runAllTests(Review review) {
        if (FakeReviewTests.containsLink(review)) {
            review.addToFakeScore(5);
            System.out.println("link");
        }
//        if (FakeReviewTests.containsExtremeLanguage(review)) {
//            review.addToFakeScore(1);
//            System.out.println("language");
//        }
//        if (FakeReviewTests.containsThreeExclamations(review)) {
//            review.addToFakeScore(2);
//            System.out.println("exclaim");
//        }
        if (FakeReviewTests.isSponsored(review)) {
            review.addToFakeScore(7);
            System.out.println("sponsored");
        }
        if (FakeReviewTests.failsLengthTest(review)) {
            review.addToFakeScore(2);
            System.out.println("length");
        }
        if (!FakeReviewTests.isAVerifiedPurchase(review)) {
            review.addToFakeScore(4);
//            System.out.println("verified purchase");
        }
        if (FakeReviewTests.isAThree(review)) {
            review.addToFakeScore(-1);
        }
        if (FakeReviewTests.containsQuestion(review)) {
            review.addToFakeScore(-1);
        }
    }
}
