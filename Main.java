package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number of people:");

        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String[] dataOfPeople = new String[numberOfPeople];

        System.out.println("Enter all people:");

        for (int i = 0; i < numberOfPeople; i++) {
            dataOfPeople[i] = scanner.nextLine();
        }

        System.out.println("Enter the number of search queries:");
        int numberOfSearch = scanner.nextInt();

        do {
            System.out.println("Enter data to search people:");

            String searchData = scanner.next();
            searchPeople(searchData, dataOfPeople);

            numberOfSearch--;

        } while (numberOfSearch != 0);
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
}
