package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[1]);
        String[] dataOfPeopleMax = new String[100];
        int length = 0;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                dataOfPeopleMax[length] = scanner.nextLine();
                length++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + args[1]);
            exit(0);
        }

        String[] dataOfPeople = new String[length];

        for (int i = 0 ; i < length; i++) {
            dataOfPeople[i] = dataOfPeopleMax[i];
        }

        boolean run = true;

        Scanner scanner = new Scanner(System.in);

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
