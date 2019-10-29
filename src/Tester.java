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
                System.out.println(review.getLabel());
                System.out.println(review.getFakenessScore());
                System.out.println(review.getReviewText());
                runAllTestsView(review);
                System.out.println("************************************************");
            }
        }
        System.out.println((double) correct / reviews.size());
    }

    public static void get50Tests() {
        ArrayList<Review> reviews = TextAnalysis.readReviews("data/amazon_reviews.txt");
        int realReviews = 0;
        int fakeReviews = 0;
        for (Review review : reviews) {
            runAllTests(review);
            if (review.getLabel().equals("__label1__") && fakeReviews < 500) {
                fakeReviews++;
                System.out.print(review.getId() + "\tFake Review\tProgram predicts: ");
                if (review.isFake()) {
                    System.out.println("fake");
                } else {
                    System.out.println("real");
                }
            } else if (review.getLabel().equals("__label2__") && realReviews < 500) {
                realReviews++;
                System.out.print(review.getId() + "\tReal Review\tProgram predicts: ");
                if (review.isFake()) {
                    System.out.println("fake");
                } else {
                    System.out.println("real");
                }
            }
        }
    }

    public static void runAllTestsView(Review review) {
        if (FakeReviewTests.containsLink(review)) {
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
            System.out.println("sponsored");
        }
        if (FakeReviewTests.failsLengthTest(review)) {
            System.out.println("length");
        }
        if (!FakeReviewTests.isAVerifiedPurchase(review)) {
            System.out.println("verified");
        }
        if (FakeReviewTests.isAThree(review)) {
            System.out.println("three");
        }
        if (FakeReviewTests.containsQuestion(review)) {
            System.out.println("question");
        }
//        if (FakeReviewTests.failsCapsTest(review)) {
//            review.addToFakeScore(1);
//        }
        if (FakeReviewTests.failsStopWordsTest(review)) {
            System.out.println("stopWords");
        }

//        if (FakeReviewTests.failsPunctuationTest(review)) {
//            review.addToFakeScore(1);
//        }
    }

    public static void runAllTests(Review review) {
        if (FakeReviewTests.containsLink(review)) {
            review.addToFakeScore(5);
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
        }
        if (FakeReviewTests.failsLengthTest(review)) {
            review.addToFakeScore(2);
        }
        if (!FakeReviewTests.isAVerifiedPurchase(review)) {
            review.addToFakeScore(4);
        }
        if (FakeReviewTests.isAThree(review)) {
            review.addToFakeScore(-1);
        }
        if (FakeReviewTests.containsQuestion(review)) {
            review.addToFakeScore(-1);
        }
//        if (FakeReviewTests.failsCapsTest(review)) {
//            review.addToFakeScore(1);
//        }
        if (FakeReviewTests.failsStopWordsTest(review)) {
            review.addToFakeScore(1);
        }

//        if (FakeReviewTests.failsPunctuationTest(review)) {
//            review.addToFakeScore(1);
//        }
    }
}
