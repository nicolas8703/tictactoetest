import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int getIntInput(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public boolean getYesNoInput(String prompt) {
        System.out.println(prompt);
        String input = scanner.next().trim().toLowerCase();
        while (!input.equals("y") && !input.equals("n") && !input.equals("j")) {
            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            input = scanner.next().trim().toLowerCase();
        }
        return input.equals("y") || input.equals("j");
    }

    public void closeScanner() {
        scanner.close();
    }
}
