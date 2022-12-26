package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[1]);

        ArrayList<String> dataOfPeople = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                dataOfPeople.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: " + args[1]);
            exit(0);
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
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = scanner.nextLine();
                    System.out.println("Enter a name or email to search all suitable people.");
                    String searchData = scanner.nextLine();

                    PeopleSearch peopleSearch = null;

                    switch (strategy) {
                        case "ANY":
                            peopleSearch = new PeopleSearch(new AnySearchMethod());
                            break;
                        case "ALL":
                            peopleSearch = new PeopleSearch(new AllSearchMethod());
                            break;
                        case "NONE":
                            peopleSearch = new PeopleSearch(new NoneSearchMethod());
                            break;
                        default:
                            System.out.println("Wrong. Choose strategy from this [ALL, ANY, NONE]");
                            break;
                    }
                    if (peopleSearch == null) {
                        System.out.println("No match");
                    } else {
                        peopleSearch.print(searchData, dataOfPeople);
                    }
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

    protected static void printAllPeople(ArrayList<String> dataOfPeople) {
        System.out.println("=== List of people ===");
        for (String dataOfPerson : dataOfPeople) {
            System.out.println(dataOfPerson);
        }
    }
}
