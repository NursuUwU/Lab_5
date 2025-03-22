package data;

import java.util.Date;

public class HumanBeing implements Comparable<HumanBeing> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private static long iteratingId = 1;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private long impactSpeed;
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null
    public HumanBeing(String name, Boolean realHero, boolean hasToothpick, long impactSpeed, Coordinates coordinates, WeaponType weaponType, Mood mood, Car car) {
        this.id = iteratingId++;
        this.creationDate = new Date();
        this.name = name;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.coordinates = coordinates;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }
    public long getId() {
        return id;
    }

    public long getImpactSpeed() {
        return impactSpeed;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    /**
     * Переопределённый {@code toString()}, использующийся при выводе элементов коллекции
     * @return Описание элементов коллекции
     */
    @Override
    public String toString() {
        return "Элемент " + id +
                "\n Имя: " +  name +
                "\n Дата создания: " + creationDate +
                "\n Настоящий герой? : " + realHero +
                "\n Есть зубочистка? : " + hasToothpick +
                "\n Скорость удара: " + impactSpeed +
                "\n Координаты: " + coordinates +
                "\n Тип оружия: " + weaponType +
                "\n Настроение: " + mood +
                "\n Машина: " + car;
    }
    @Override
    public int compareTo(HumanBeing human) {
        return Integer.compare(this.name.length(), human.name.length()) +
                Integer.compare((int)this.id,(int)human.id) +
                Integer.compare((int)this.impactSpeed, (int)human.impactSpeed);

    }
}
