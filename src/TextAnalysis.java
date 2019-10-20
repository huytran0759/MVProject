import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class TextAnalysis {

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

}
