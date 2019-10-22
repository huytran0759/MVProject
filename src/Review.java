import java.util.ArrayList;

public class Review {

    private double fakenessScore;
    private boolean isFake;
    private int id, rating;
    private String label, productName, productCategory, productID, reviewTitle, reviewText;
    private boolean verifiedPurchase;
    private ArrayList<String> sentences, words;

    public Review(int id, String label, int rating, String verifiedPurchase, String productCategory, String productID, String productName, String reviewTitle, String reviewText) {
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
        this.productName = productName;
        this.reviewTitle = reviewTitle;
        this.reviewText = reviewText;
        this.sentences = TextAnalysis.splitIntoSentences(reviewText);
        this.words = TextAnalysis.splitIntoWords(reviewText);
        this.fakenessScore = 0.0;
        this.isFake = false;
    }

    public double getFakenessScore() {
        return fakenessScore;
    }

    public boolean isFake() {
        return isFake;
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getLabel() {
        return label;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductID() {
        return productID;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewText() {
        return reviewText;
    }

    public boolean isVerifiedPurchase() {
        return verifiedPurchase;
    }

    public ArrayList<String> getSentences() {
        return sentences;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public int getWordLength() {
        return words.size();
    }

    public void addToFakeScore(double amount) {
        fakenessScore += amount;
    }

}
