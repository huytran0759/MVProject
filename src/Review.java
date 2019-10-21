import java.util.ArrayList;

public class Review {

    private double fakenessScore;
    private boolean isFake;
    private int id, rating;
    private String label, productName, text, productCategory, productID, productTitle, reviewTitle, reviewText;
    private boolean verifiedPurchase;
    private ArrayList<String> sentences, words;

    public Review(int id, String label, int rating, String verifiedPurchase, String productCategory, String productID, String productTitle, String reviewTitle, String reviewText) {
        this.id = id;
        this.label = label;
        this.rating = rating;
        if (verifiedPurchase.equals("y")) {
            this.verifiedPurchase = true;
        } else {
            this.verifiedPurchase = false;
        }
        this.productCategory = productCategory;
        this.productID = productID;
        this.productTitle = productTitle;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.sentences = TextAnalysis.splitIntoSentences(reviewText);
        this.words = TextAnalysis.splitIntoWords(reviewText);
        this.fakenessScore = 0.0;
        this.isFake = false;
    }

    public ArrayList<String> getSentences() {
        return sentences;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public String getText() {
        return text;
    }

    public int getWordLength() {
        return words.size();
    }

    public void addToFakeScore(double amount) {
        fakenessScore += amount;
    }

}
