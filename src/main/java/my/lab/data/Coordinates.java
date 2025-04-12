package my.lab.data;

public class Coordinates {
    private double x; //Значение поля должно быть больше -12
    private Long y; //Значение поля должно быть больше -255, Поле не может быть null

    public Coordinates(Double x, Long y) {
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return "{" +
                "\n x: " + x +
                "\n y: " + y +
                "\n }";
    }



    public Long getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setX(Double x) {
        if (x == null || x <= -12) {
            System.out.println("Ой, такая координата x недопустима! Она была заменена на минимальную возможную OwO");
            this.x = -11.999;
        } else {
            this.x = x;
        }
    }
    public void setY(Long y) {
        if (y == null || y <= -255) {
            System.out.println("Ой, такая координата y недопустима! Она была заменена на минимальную возможную OwO");
            this.y = -254L;
        } else {
            this.y = y;
        }
    }
}
