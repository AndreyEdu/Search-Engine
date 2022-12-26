package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class PeopleSearch {

    private SearchMethod method;

    public PeopleSearch(SearchMethod method) {
        this.method = method;
    }

    public ArrayList<String> search(String searchData, ArrayList<String> dataOfPeople) {
            return this.method.search(searchData, dataOfPeople);
    }

    public int size(String searchData, ArrayList<String> dataOfPeople) {

        return this.method.search(searchData, dataOfPeople).size();
    }

    public void print(String searchData, ArrayList<String> dataOfPeople) {
        ArrayList<String> data = this.method.search(searchData, dataOfPeople);

        for (String s : data) {
            System.out.println(s);
        }
    }
}
