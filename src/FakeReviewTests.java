import java.util.ArrayList;
import java.util.Arrays;

public class FakeReviewTests {

    private static final int FAKE_REVIEW_WORD_THRESHOLD = 6;
    private static final String[] SPONSORED_WORDS = {"free", "sponsored", "sponsor"};
    private static final String[] EXTREME_WORDS = {"perfect", "best", "worst", "absolutely"};
    private static final String[] SUGGESTIVE_WORDS = {"but", "however", "even though", "although", "think"};

    public static boolean passesLengthTest(Review review) {
        return review.getWordLength() > FAKE_REVIEW_WORD_THRESHOLD;
    }


    public static boolean isAVerifiedPurchase(Review review){

        return (review.isVerifiedPurchase());
    }

    public static boolean isAThree(Review review){

        return (review.getRating() == 3);

    }

    public static boolean containsQuestion(Review review){

        for(String word : review.getWords()){
            if(word.contains("?")){
                return true;
            }
        }

        return false;
    }

    public static boolean containsLink(Review review){
        for (String word : review.getWords()) {
            if(word.contains("http://") || word.contains(".com") || word.contains(".net")){
                return true;
            }
        }
        return false;
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

    public static boolean containsThreeExclamations(Review review) {
        String text = review.getReviewText();
        int exclamationCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.substring(i, i + 1).equals("!")) {
                exclamationCount++;
            }
        }
        return exclamationCount > 3;
    }

}
