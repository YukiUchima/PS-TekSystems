package pa303103;

public class LibraryInterfaceDemo {

    public static void main(String[] args) {
        KidUser kid = new KidUser(10, "Kids");
        KidUser kid2 = new KidUser(18, "Fiction");

        AdultUser adult1 = new AdultUser(5, "Kids");
        AdultUser adult2 = new AdultUser(23, "Fiction");

        kid.registerAccount();
        kid.requestBook();
        System.out.println();
        kid2.registerAccount();
        kid2.requestBook();

        System.out.println("\n============================================================\n");

        adult1.registerAccount();
        adult1.requestBook();
        System.out.println();
        adult2.registerAccount();
        adult2.requestBook();

    }
}
