package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String find = scanner.next();
        int countWord = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals(find)) {
                countWord = i + 1;



            }
        }
        if (countWord == 0) {
            System.out.println("Not found");
        } else {
            System.out.println(countWord);
        }
    }
}
