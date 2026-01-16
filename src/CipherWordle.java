import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class CipherWordle {
    private String name;
    private String currentWord;
    private boolean isGameOver;
    private int numGuesses;
    private String modWord;
    public CipherWordle(String n) {
        this.name = n;
        this.currentWord = null;
        this.isGameOver = false;
        this.modWord = null;
        this.numGuesses = 0;
    }
    public void play() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> fileData = getFileData("src/WordleData");
        String word = fileData.get((int)(Math.random() * 1671));
        System.out.println("Welcome to Wordle, " + name + ". In this version of wordle you will be given a starting word and have to guess a\n series of random letters that have been shifted up based on the word");
        this.currentWord = word;
        this.modWord = modify(word);
        while (!isGameOver) {
            System.out.println("Please guess a 5 letters in CAPS (You will see a series of up and down arrows and an x if the character is in the right spot. Your given word is " + word);
            String guess = scan.nextLine();
            System.out.println(getHint(guess));
            if (getHint(guess).equals(modWord)) {
                System.out.println("You won! Going back to main menu.");
                isGameOver = true;
            } else {
                System.out.println("Guess again!");
                numGuesses++;
            }
            if (numGuesses == 6 && !isGameOver) {
                System.out.println("You lose! The word was " + modWord + ". Going to main menu.");
                break;
            }
        }
    }
    public String modify(String word) {
        String fString = "";
        for (int i = 0; i < word.length(); i++) {
            int u1 = (int) word.charAt(i) - 65;
            int u2 = (int) (Math.random() * 26);
            int currChar = u1 + u2;
            if (currChar > 25) {
                currChar -= 26;
                currChar += 65;
            } else {
                currChar += 65;
            }
            fString += (char) currChar;
        }
        return fString;
    }
    public String getHint(String guess) {
        String fString = "";
        for (int i = 0; i < guess.length(); i++) {
            if (guess.substring(i, i + 1).equals(modWord.substring(i, i + 1))) {
                fString += guess.substring(i, i + 1);
            } else if ((int)(modWord.charAt(i)) > (int)(guess.charAt(i))) {
                fString += "^";
            } else {
                fString += "v";
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
