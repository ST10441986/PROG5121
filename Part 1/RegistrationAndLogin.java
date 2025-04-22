import java.util.Scanner;

public class RegistrationAndLogin {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] usernames = new String[5];
    private static final String[] passwords = new String[5];
    private static final String[] cellphones = new String[5];
    private static int userCount = 0;
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        createUserAccounts();
        loginUser();
        loginStatus();
    }

    public static void createUserAccounts() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Create an account:");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            // Check username format
            if (!isValidUsername(username)) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
                continue;
            } else {
                System.out.println("Username successfully captured.");
            }

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Check password complexity
            if (!isValidPassword(password)) {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
                continue;
            } else {
                System.out.println("Password successfully captured.");
            }

            System.out.print("Enter phone number: ");
            String cellphone = scanner.nextLine();

            if (!isValidCellphoneNumber(cellphone)) {
                System.out.println("Cellphone number incorrectly formatted or does not contain international code");
                continue;
            } else {
                System.out.println("Cellphone number successfully added");
            }

            usernames[userCount] = username;
            passwords[userCount] = password;
            cellphones[userCount] = cellphone;
            userCount++;
        }
    }

    public static void loginUser() {
        System.out.println("Login to your account:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter cellphone number: ");
        String cellphone = scanner.nextLine();

        // Verify login details
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password) && cellphones[i].equals(cellphone)) {
                isLoggedIn = true; // Update login status
                break;
            }
        }

        if (isLoggedIn) {
            System.out.println("Welcome back!");
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }
    
    public static void loginStatus() {
        if (isLoggedIn) {
            System.out.println("You are currently logged in.");
        } else {
            System.out.println("You are currently logged out.");
        }
    }

    public static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[@#$%^&+=].*");
    }
    
    //Reference
    //OpenAI.(2023).ChatGPT(Nov 30 version) [Large language model]. https://chat.openai.com/chat
    public static boolean isValidCellphoneNumber(String cellphone) {
        return cellphone.matches("^\\+\\d{1,4}\\d{1,10}$");
    }
}