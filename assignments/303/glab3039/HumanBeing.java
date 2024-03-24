package glab3039;

public class HumanBeing {
    private float height;
    private float weight;
    private float bmi;

    public HumanBeing(float height, float weight, float bmi) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    public HumanBeing() {

    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}
