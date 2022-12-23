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

    protected static void searchPeople(String searchData, ArrayList<String> dataOfPeople) {
        HashMap<String, TreeSet<Integer>> invertedIndex = new HashMap<>();
        int line = 0;
        for (String data : dataOfPeople) {
            String[] words = data.split("\\s+");
            for (String word : words) {
                if (invertedIndex.containsKey(word)) {
                    invertedIndex.get(word).add(line);
                } else {
                    invertedIndex.put(word, new TreeSet<>(Set.of(line)));
                }
            }
            line++;
        }

        if (invertedIndex.containsKey(searchData)) {
            for (Integer val : invertedIndex.get(searchData)) {
                System.out.println(invertedIndex.get(searchData).size() + " persons found:");
                System.out.println(dataOfPeople.get(val));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }

    protected static void printAllPeople(ArrayList<String> dataOfPeople) {
        System.out.println("=== List of people ===");
        for (String dataOfPerson : dataOfPeople) {
            System.out.println(dataOfPerson);
        }
    }
}
