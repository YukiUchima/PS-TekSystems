package glab303113;

import java.util.ArrayList;

public class showData {

    public static void main(String[] args) {

        AddDataToArrayList bookData = new AddDataToArrayList();
        ArrayList<Book> myBookList = bookData.bookDetails();

        for (Book book : myBookList) {
            System.out.printf("\'%s\'\n", book.getName());
            System.out.printf("\t[%s : %s] by %s\n", book.getNumber(),book.getCategory(), book.getAuthor());
        }

    }
}
