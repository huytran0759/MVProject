import java.util.ArrayList;

public class Review {

    private double fakenessScore;
    private boolean isFake;
    private int rating;
    private String productName, text;
    private ArrayList<String> sentences, words;

    public Review(String productName, String text, int rating) {
        this.productName = productName;
        this.text = text;
        this.rating = rating;
        this.sentences = TextAnalysis.splitIntoSentences(text);
        this.words = TextAnalysis.splitIntoWords(text);
        this.fakenessScore = 0.0;
        this.isFake = false;
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
