import java.util.Scanner;
public class MainMenu {
    private String name;
    public MainMenu(String n) {
        this.name = n;
    }
    public void Menu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("-----Welcome to Fake NYT Games, " + name + "!-----\n Please select one of the following options (Type the corresponding number):\n1. Wordle\n2. Connections\n3. Cipher Wordle\n4. Help\n5. Quit\n------------------------------------");
            int temp = scan.nextInt();
            if (temp == 1) {
                Wordle wordle = new Wordle(name);
                wordle.play();
            } else if (temp == 2) {
                CipherWordle cipher = new CipherWordle(name);
            } else if (temp == 3) {
                System.out.println("Select a number from 1-4 depending on the\naction or game you would like to play.");
            } else if (temp != 4){
                System.out.println("Please select a valid option. Thank you!");
            } else {
                System.out.println("Thank you for playing!");
                break;
            }
        }
    }
}
