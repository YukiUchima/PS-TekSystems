package glab3039;

public class EncapsulationExample {

    public static void main(String[] args) {
        HumanBeing human1 = new HumanBeing();

        human1.setHeight(1.65f);
        human1.setWeight(68);
        human1.setBmi(calculateBmi(human1));
        System.out.printf("Person has %.1f kgs and is %.1f meters in height, which results in BMI of %.1f",
                human1.getWeight(), human1.getHeight(), human1.getBmi());

    }

    private static float calculateBmi(HumanBeing human) {
        float wgt = human.getWeight();
        float hgt = human.getHeight();
        float res = (float) (wgt / Math.pow(hgt, 2));
        return res;
    }
}
