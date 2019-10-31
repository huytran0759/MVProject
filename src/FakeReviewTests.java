import java.util.ArrayList;

public class FakeReviewTests {

    private static final int FAKE_REVIEW_WORD_THRESHOLD = 76;
    private static final int FAKE_REVIEW_STOP_WORDS_THRESHOLD = 20;
    //    private static final int NUM_PUNCTUATION_THRESHOLD = 2;
    //    private static final int FAKE_REVIEW_CAPS_THRESHOLD = ;
    private static final String[] SPONSORED_WORDS = {"sponsored", "sponsor"};
    private static final String[] EXTREME_WORDS = {"perfect", "best"};
//    private static final String[] UNCERTAINTY_WORDS = {"might", "possibly", "maybe", "probably", "hopefully"};
    //    private static final String[] PUNCTUATION = {".", "!", ";", ":", ","};
    private static final ArrayList<String> STOP_WORDS = TextAnalysis.readWordBin("data/stopwords.txt");

    public static boolean failsLengthTest(Review review) {
        return review.getWordLength() < FAKE_REVIEW_WORD_THRESHOLD;
    }

    public static boolean isAVerifiedPurchase(Review review) {
        return review.isVerifiedPurchase();
    }

    public static boolean containsThreeQuestion(Review review) {
        int numQuestions = 0;
        for (String word : review.getWords()) {
            if (word.contains("?")) {
                numQuestions++;
            }
        }
        return numQuestions >= 3;
    }

//    public static boolean isAThree(Review review) {
//
//        return (review.getRating() == 3);
//    }

    public static boolean containsLink(Review review) {
        for (String word : review.getWords()) {
            if (word.contains("http://") || word.contains(".com") || word.contains(".net") || word.contains("goo.gl")) {
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

    public static boolean containsReturn(Review review) {
        ArrayList<String> reviewWords = review.getWords();
        for (String reviewWord : reviewWords) {
            if (reviewWord.equals("return")) {
                return true;
            }
        }
        return false;
    }

//    public static boolean containsUncertaintyWords(Review review) {
//        ArrayList<String> reviewWords = review.getWords();
//        for (String word : UNCERTAINTY_WORDS) {
//            if (reviewWords.contains(word)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static boolean categoryIsHealth(Review review) {
        return review.getProductCategory().equals("Health & Personal Care");
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

    public static boolean failsStopWordsTest(Review review) {
        int stopWordCount = 0;
        ArrayList<String> words = review.getWords();
        for (String word : words) {
            if (STOP_WORDS.contains(word)) {
                stopWordCount++;
            }
        }
        return stopWordCount < FAKE_REVIEW_STOP_WORDS_THRESHOLD;
    }

//    public static boolean failsPunctuationTest(Review review) {
//        int punctuationCount = 0;
//        String text = review.getReviewText();
//        List<String> punctuationList =  Arrays.asList(PUNCTUATION);
//        for (int i = 0; i < text.length(); i++) {
//            if (punctuationList.contains(text.substring(i, i + 1))) {
//                punctuationCount++;
//            }
//        }
//        return punctuationCount < NUM_PUNCTUATION_THRESHOLD;
//  }

//    public static boolean failsCapsTest(Review review) {
//        String text = review.getReviewText();
//        return TextAnalysis.getNumCaps(text) < FAKE_REVIEW_CAPS_THRESHOLD;
//    }

}
