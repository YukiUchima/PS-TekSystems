package pa303103;

public class KidUser implements ILibraryUser{

    private int age;
    private String bookType;

    public KidUser(int age, String bookType){
        this.setAge(age);
        this.setBookType(bookType);
    }
    @Override
    public void registerAccount() {
        if(this.getAge() <= 11){
            System.out.println("You have successfully registered under a Kid's account");
        }else {
            System.out.println("Sorry, age must be less than 12 to register as a kid");
        }
    }

    @Override
    public void requestBook() {
        if(this.getBookType().equals("Kids")){
            System.out.println("Book issued successfully, please return the book within 10 days");
        }else {
            System.out.println("Oops, you are allowed to take only kids books.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
