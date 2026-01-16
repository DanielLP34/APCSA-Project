import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scan.nextLine();
        MainMenu menu1 = new MainMenu(name);
        menu1.Menu();
    }
}