import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Wordle {
    private String name;
    public Wordle(String n) {
        this.name = n;
    }
    public void Play() {
        ArrayList<String> fileData = getFileData("src/WordleData");
        String word = fileData.get((int)(Math.random() * 1671));
        System.out.println("Welcome to Wordle, " + name + ".\nPlease pick one of these options:\n1. Play Game\n2. Help\n3.Main Menu\n--------------------");

    }
    public String getHint(String guess) {
        String fString = "";
        for (int i = 0; i < guess.length(); i++) {
            if (guess.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                fString += guess.substring(i, i + 1);
            } else if (word.contains(guess.substring(i, i + 1))) {
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
