
public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java WordCount <file1> [<file2> ...]");
            return;
        }

        WordCount wordCount = new WordCount();

        for (String filename : args) {
            wordCount.countWordsInFile(filename);
        }
        // Print summary if more than 2 files are specified
        if (args.length > 1) {
            wordCount.printTotal();
        }
    }
}