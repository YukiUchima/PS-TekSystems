package glab303101;

public class Girl extends Person {
    static double ageFactor = 1.3;

    public Girl(String name) {
        this.name = "Ms. " + name;
    }

    public String talk() {
        return "Hello! " + jump();
    }

    private String jump() {
        return "I am jumping!";
    }

    public static double lifeSpan() {
        return lifeSpan * ageFactor;
    }

}
