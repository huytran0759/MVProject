import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If review text only, type 'text");
        System.out.println("If full review, type 'full'");
        String input = scanner.nextLine();
        if (input.equals("text")) {
            System.out.println("Paste in the review:");
            String reviewText = scanner.nextLine();
            Review review = new Review(reviewText);
            Tester.runAllTextOnlyTests(review);
            if (review.isFake()) {
                System.out.println("Fake Review");
            } else {
                System.out.println("Real Review");
            }
        } else if (input.equals("full")) {
            System.out.print("Rating: ");
            int rating = scanner.nextInt();
            System.out.print("Verified Purchase: ");
            String verifiedPurchase = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Product ID: ");
            String productID = scanner.nextLine();
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Review Title: ");
            String reviewTitle = scanner.nextLine();
            System.out.println("Paste in the review:");
            String reviewText = scanner.nextLine();
            Review review = new Review(0, null, rating, verifiedPurchase, category, productID, productName, reviewTitle, reviewText);
            Tester.runAllTests(review);
            if (review.isFake()) {
                System.out.println("Fake Review");
            } else {
                System.out.println("Real Review");
            }
        }
    }
}
