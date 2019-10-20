import java.util.ArrayList;

public class FakeReviewTests {

    private static final int FAKE_REVIEW_WORD_THRESHOLD = 6;
    private static final String[] SPONSORED_WORDS = {"free", "sponsored", "sponsor"};
    private static final String[] EXTREME_WORDS = {"perfect", "best"};

    public static boolean passesLengthTest(Review review) {
        return review.getWordLength() > FAKE_REVIEW_WORD_THRESHOLD;
    }

    public static boolean isSponsored(Review review) {
        ArrayList<String> reviewWords = review.getWords();
        for (String word : SPONSORED_WORDS) {
            if (reviewWords.contains(word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsExtremeLanguage(Review review) {
        ArrayList<String> reviewWords = review.getWords();
        for (String word : EXTREME_WORDS) {
            if (reviewWords.contains(word)) {
                return true;
            }
        }
        return false;
    }

}
