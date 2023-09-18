package emaillist;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();

        while (true) {
            System.out.println("Email List");
            System.out.println("1. Add Email");
            System.out.println("2. Remove Email");
            System.out.println("3. List Emails");
            System.out.println("4. Check Email");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter email address to add: ");
                    String addEmail = scanner.nextLine();
                    emailList.addEmail(addEmail);
                    System.out.println("Email added successfully!");
                    break;

                case 2:
                    System.out.print("Enter email address to remove: ");
                    String removeEmail = scanner.nextLine();
                    if (emailList.containsEmail(removeEmail)) {
                        emailList.removeEmail(removeEmail);
                        System.out.println("Email removed successfully!");
                    } else {
                        System.out.println("Email not found in the list.");
                    }
                    break;

                case 3:
                    ArrayList<String> emails = emailList.listEmails();
                    System.out.println("Email List:");
                    for (int i = 0; i < emails.size(); i++) {
                        System.out.println((i + 1) + ". " + emails.get(i));
                    }
                    break;

                case 4:
                    System.out.print("Enter email address to check: ");
                    String checkEmail = scanner.nextLine();
                    if (emailList.containsEmail(checkEmail)) {
                        System.out.println(checkEmail + " is in the list.");
                    } else {
                        System.out.println(checkEmail + " is not in the list.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
