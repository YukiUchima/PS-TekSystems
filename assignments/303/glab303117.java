import jdk.jshell.execution.JdiInitiator;

import javax.xml.namespace.QName;
import java.util.Map;
import java.util.TreeMap;

public class glab303117 {
    //    Guided LAB - 303.11.7 - Phone Directory Using TreeMap
    public static void main(String[] args) {
        exampleOnePhoneDirectory();

    }




    private static void exampleOnePhoneDirectory() {
//        Setup - Creating treemap to store key/value information representing name and its phonenumber

        class Phonebook {
            TreeMap<String, String> data;

            Phonebook() {
                data = new TreeMap<String, String>();
            }

            void addEntry(String name, String number) {
                data.put(name, number);
            }

            String getNumber(String name) {
                return this.data.get(name);
            }

            void openBook(){
                for (Map.Entry<String, String> entry : data.entrySet()) {
                    System.out.printf("\n %s: %s", entry.getKey(), entry.getValue());
                }
            }
        }
//        Example Two
        Phonebook directory = new Phonebook();
       System.out.println("This program creates a PhoneDirectoryWithTreeMap and");
       System.out.println("adds several entries.  It then prints the contents of");
       System.out.println("directory and does a few lookups.");
       System.out.println();
       directory.addEntry("Fred","555-1234");
       directory.addEntry("Barney","555-2345");
       directory.addEntry("Wilma","555-3456");
       directory.addEntry("Wilma","555-3456");
       directory.addEntry("Wilma","555-2563");
      // directory.putNumber("James",null);
       //directory.putNumber(null,"555-2853");

       System.out.println("Contents are:");
       System.out.println();
       directory.openBook();
       System.out.println();
       System.out.println("Number for Fred is " + directory.getNumber("Fred"));
       System.out.println("Number for Wilma is " + directory.getNumber("Wilma"));
       System.out.println("Number for Tom is " + directory.getNumber("Tom"));
       System.out.println("Number for Tom is " + directory.getNumber("Alex"));
       // The output from the last line should be null.




    }
}
