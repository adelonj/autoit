package modificators;

/**
 * Created by delonj on 21/07/2019.
 */
public final class Car {

    private final String color;
    private static final int maxSpeed = 300;

    public Car(String color) {
        this.color = color;
    }


    public void run(final int speed) {
        System.out.println("go -> " + speed);
    }

    public String getColor() {return color;}

}
