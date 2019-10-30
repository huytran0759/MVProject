import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Paste in the review:");
        String reviewText = scanner.nextLine();
        Review review = new Review(reviewText);
        Tester.runAllTests(review);
        System.out.println(review.isFake());
    }
}
