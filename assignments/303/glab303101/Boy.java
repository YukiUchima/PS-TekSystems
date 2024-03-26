package glab303101;

public class Boy extends Person{
    static double ageFactor = 1.1;

    public String talk() {
        return (super.talk() + "... but I love Java Class.");
    }

    public String walk() {
        return "I am walking!";
    }
}
