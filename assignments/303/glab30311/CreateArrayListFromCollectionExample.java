package glab30311;

import java.util.ArrayList;
import java.util.List;

public class CreateArrayListFromCollectionExample {
    //        Example 3: Accessing Elements from an ArrayList

    public static void main(String[] args) {
        List<String> topCompanies = new ArrayList<>();

        System.out.println("Is top companies empty?: " + topCompanies.isEmpty());

        topCompanies.add("Google");
        topCompanies.add("Netflix");
        topCompanies.add("Facebook");
        topCompanies.add("Meta");
        topCompanies.add("Microsoft");

        System.out.printf("Top %d companies in the world.", topCompanies.size());
        for (String company : topCompanies) {
            System.out.printf("%n\t%s ", company);
        }

        String bestCompany = topCompanies.get(0);
        String secondBestCompany = topCompanies.get(1);
//        String lastCompany = topCompanies.get(topCompanies.size() - 1);
        String lastCompany = topCompanies.getLast();


        System.out.println("Best Company: " + bestCompany);
        System.out.println("Second Best Company: " + secondBestCompany);
        System.out.println("Last Company in the list: " + lastCompany);

        topCompanies.set(4, "Walmart");
        System.out.println("Modified top companies list: " + topCompanies);

    }
}
