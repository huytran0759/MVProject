import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TextAnalysis {

    public static ArrayList<Review> readReviews(String filename){
        Scanner scanner;
        ArrayList<Review> reviews = new ArrayList<Review>();

        try {

            scanner = new Scanner(new FileReader(filename));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();


                reviews.add(processLine(line));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found " + filename);
        }

        return reviews;
    }

    public static Review processLine(String line){
        String[]info = line.split("\t");



        int docID = Integer.parseInt(info[0].trim());
        String label = info[1].trim();
        int rating = Integer.parseInt(info[2].trim());
        String verifiedPurchase = info[3].trim();
        String productCategory = info[4].trim();
        String productID = info[5].trim();
        String productTitle = info[6].trim();
        String reviewTitle = info[7].trim();
        String reviewText = info[8].trim();



        return new Review(docID, label, rating, verifiedPurchase, productCategory, productID, productTitle, reviewTitle, reviewText);

    }

    public static ArrayList<String> splitIntoSentences(String text) {
        ArrayList<String> output = new ArrayList<>();

        Locale locale = Locale.US;
        BreakIterator breakIterator = BreakIterator.getSentenceInstance(locale);
        breakIterator.setText(text);

        int prevIndex = 0;
        int boundaryIndex = breakIterator.first();
        while (boundaryIndex != BreakIterator.DONE) {
            String sentence = text.substring(prevIndex, boundaryIndex).trim();
            if (sentence.length() > 0)
                output.add(sentence);
            prevIndex = boundaryIndex;
            boundaryIndex = breakIterator.next();
        }

        String sentence = text.substring(prevIndex).trim();
        if (sentence.length() > 0)
            output.add(sentence);

        return output;
    }

    public static ArrayList<String> splitIntoWords(String text) {
        return new ArrayList<>((Arrays.asList(text.split(" "))));
    }

    public static int countOccurrences(ArrayList<String> wordList, String target) {
        int count = 0;
        for (String word : wordList) {
            if (word.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static boolean containsLink(String text) {
        return text.contains("http://") || text.contains(".com") || text.contains(".net");
    }

    public static ArrayList<String> splitIntoVocabulary(ArrayList<String> words) {
        ArrayList<String> vocabulary = new ArrayList<>();
        for (String word : words) {
            if (!vocabulary.contains(word)) {
                vocabulary.add(word);
            }
        }
        return vocabulary;
    }

    public static int getNumCaps(String text) {
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (caps.contains(text.substring(i, i + 1))) {
                count++;
            }
        }
        return count;
    }

}
