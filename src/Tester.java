
public class Tester {
    public static void main(String[] args) {
        // run all tests and add to fakeness score if passes
        Review r = TextAnalysis.processLine("1\t__label1__\t4\tN\tPC\tB00008NG7N\tTargus PAUK10U Ultra Mini USB Keypad, Black\tuseful\tWhen least you think so, this product will save the day. Just keep it around just in case you need it for something.");
        System.out.println(r.getProductName());
    }
}
