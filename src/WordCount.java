import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
    private int totalLines = 0;
    private int totalWords = 0;
    private int totalChars = 0;

    public void countWordsInFile(String filename) {
        int lines = 0;
        int words = 0;
        int chars = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
                words += countWords(line);
                chars += line.length();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
            return;
        }

        System.out.println(lines + " " + words + " " + chars + " " + filename);
        totalLines += lines;
        totalWords += words;
        totalChars += chars;
    }

    private int countWords(String line) {
        Matcher matcher = Pattern.compile("\\w+").matcher(line);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public void printTotal() {
        System.out.println("Total: " + totalLines + " " + totalWords + " " + totalChars + " total");
    }
}