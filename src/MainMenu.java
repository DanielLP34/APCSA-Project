import java.util.Scanner;
public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        while (true) {
            System.out.println("-----Welcome to Fake NYT Games, " + name + "!-----\n Please select one of the following options (Type the corresponding number):\n1. Wordle\n2. Connections\n3. Cipher Wordle\n4. Help\n5. Quit\n------------------------------------");
            int temp = scan.nextInt();
            if (temp == 1) {
                Wordle wordle = new Wordle(name);
                wordle.play();
            } else if (temp == 2) {
                Connections connections =  new Connections(name);

            } else if (temp == 3) {
                CipherWordle cipher = new CipherWordle(name);

            } else if (temp == 4) {
                System.out.println("Select a number from 1-5 depending on the\naction or game you would like to play.");
            } else if (temp != 5){
                System.out.println("Please select a valid option. Thank you!");
            } else {
                System.out.println("Thank you for playing!");
                break;
            }
        }
    }
}
