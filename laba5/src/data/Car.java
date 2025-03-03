package data;

public class Car {
    private String name; //Поле не может быть null
    private Boolean cool; //Поле не может быть null
    public Car(String name, Boolean cool) {
        this.name = name;
        this.cool = cool;
    }
    @Override
    public String toString() {
        return "Название машины: " + name + " Крутая? : " + cool;
    }
}
