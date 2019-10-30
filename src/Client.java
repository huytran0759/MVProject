import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Paste in the review:");
        String reviewText = scanner.nextLine();
        Review review = new Review(reviewText);
        Tester.runAllTests(review);
        if (review.isFake()) {
            System.out.println("Fake Review");
        } else {
            System.out.println("Real Review");
        }
    }
}
