package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of people:");

        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String[] dataOfPeople = new String[numberOfPeople];
        boolean run = true;

        System.out.println("Enter all people:");

        for (int i = 0; i < numberOfPeople; i++) {
            dataOfPeople[i] = scanner.nextLine();
        }

        do {
            System.out.println("""
                === Menu ===
                1. Find a person
                2. Print all people
                0. Exit
                    """);

            int chooseMenu = Integer.parseInt(scanner.nextLine());

            switch (chooseMenu) {
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    String searchData = scanner.nextLine();
                    searchPeople(searchData, dataOfPeople);
                    break;
                case 2:
                    printAllPeople(dataOfPeople);
                    break;
                case 0:
                    run = false;
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        } while (run);
    }

    protected static void searchPeople(String searchData, String[] dataOfPeople) {
        int noMatch = 0;
        for (String dataOfPerson : dataOfPeople) {
            if (dataOfPerson.toLowerCase().contains(searchData.toLowerCase())) {
                System.out.println(dataOfPerson);
                noMatch++;
            }
        }

        if (noMatch == 0) {
            System.out.println("No matching people found.");
        }
    }

    protected static void printAllPeople(String[] dataOfPeople) {
        System.out.println("=== List of people ===");
        for (String dataOfPerson : dataOfPeople) {
            System.out.println(dataOfPerson);
        }
    }
}
