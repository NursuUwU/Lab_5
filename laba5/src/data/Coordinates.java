package data;

public class Coordinates {
    private double x; //Значение поля должно быть больше -12
    private Long y; //Значение поля должно быть больше -255, Поле не может быть null
    public Coordinates(double x, Long y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "x: " + x + " y: " + y;
    }
}
