import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Wordle {
    private final String name;
    private String currentWord;
    private boolean isGameOver;
    public Wordle(String n) {
        this.name = n;
        this.currentWord = null;
        this.isGameOver = false;
    }
    public void play() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> fileData = getFileData("src/WordleData");
        String word = fileData.get((int)(Math.random() * 1671));
        System.out.println("Welcome to Wordle, " + name);
        while (!isGameOver) {
            System.out.println("Please guess a 5 letter word (When you enter a word,\na string will appear and show the letter if it is correct and in the right place,\na + if the letter is in the word but in the wrong place,\n or a * if the letter isn't in the word)");
            String guess = scan.nextLine();
            this.currentWord = word;

        }
    }
    public String getHint(String guess) {
        String fString = "";
        for (int i = 0; i < guess.length(); i++) {
            if (guess.substring(i, i + 1).equals(currentWord.substring(i, i + 1))) {
                fString += guess.substring(i, i + 1);
            } else if (currentWord.contains(guess.substring(i, i + 1))) {
                fString += "+";
            } else {
                fString += "*";
            }

        }
        return fString;
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
