package search;

import java.util.*;

public class AnySearchMethod implements SearchMethod {
    @Override
    public ArrayList<String> search(String searchData, ArrayList<String> dataOfPeople) {
        HashMap<String, TreeSet<Integer>> invertedIndex = new HashMap<>();
        ArrayList<String> people = new ArrayList<>();
        int line = 0;
        for (String data : dataOfPeople) {
            String[] words = data.split("\\s+");
            for (String word : words) {
                String key = word.toLowerCase();
                if (invertedIndex.containsKey(key)) {
                    invertedIndex.get(key).add(line);
                } else {
                    invertedIndex.put(key.toLowerCase(), new TreeSet<>(Set.of(line)));
                }
            }
            line++;
        }

        String[] wordsForSearch = searchData.split(" ");

        for (String forSearch : wordsForSearch) {
            if (invertedIndex.containsKey(forSearch.toLowerCase())) {
                for (Integer val : invertedIndex.get(forSearch)) {
                    people.add(dataOfPeople.get(val));
                }
            }
        }
        return people;
    }
}