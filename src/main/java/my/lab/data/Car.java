package my.lab.data;

public class Car {
    private String name; //Поле не может быть null
    private Boolean cool; //Поле не может быть null

    public Car(String name, Boolean cool) {
        setName(name);
        setCool(cool);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Jons car";
            System.out.println("Ой, в файлике было некорректное название машины X~o");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setCool(Boolean cool) {
        if (cool == null) {
            this.cool = false;
            System.out.println("Ой, в файлике было некорректное значение крутости машины X~o");
        } else {
            this.cool = cool;
        }
    }

    public Boolean getCool() {
        return cool;
    }

    @Override
    public String toString() {
        return "{" +
                "\n Название машины: " + name +
                "\n Крутая? : " + cool +
                "\n }";
    }
}
