package my.lab.data;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HumanBeing implements Comparable<HumanBeing> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private static long nextID = 1;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private boolean hasToothpick;
    private long impactSpeed;
    private WeaponType weaponType; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле не может быть null
    private static final Set<Long> usedID = new HashSet<>();

    public HumanBeing(Long id, String creationDate, String name, Boolean realHero, Boolean hasToothpick, long impactSpeed, Coordinates coordinates, String weaponType, String mood, Car car) {
        setId(id);
        setCreationDate(creationDate);
        setName(name);
        setRealHero(realHero);
        setHasToothpick(hasToothpick);
        setImpactSpeed(impactSpeed);
        setCoordinates(coordinates);
        setWeaponType(weaponType);
        setMood(mood);
        setCar(car);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null || id < 0 || usedID.contains(id)) {
            while (usedID.contains(nextID)) {
                nextID++;
            }
            this.id = nextID;
            usedID.add(nextID);
            nextID++;
        } else {
            this.id = id;
            usedID.add(id);
            if (id >= nextID) {
                nextID = id + 1;
            }
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        try {
            ZonedDateTime time = ZonedDateTime.parse(creationDate);
            this.creationDate = Date.from(time.toInstant());
        } catch (Exception e) {
            this.creationDate = new Date();
        }

    }

    public long getImpactSpeed() {
        return impactSpeed;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public boolean isHasToothpick() {
        return hasToothpick;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            System.out.println("Ой, в файлике было некорректный объект координат X~o");
            this.coordinates = new Coordinates(0.0, 0L);
        } else {
            this.coordinates = coordinates;
        }
    }
    public void setCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Ой, машина не может быть null OwO");
        } else {
        this.car = car;
        }
    }

    public Car getCar() {
        return car;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        if (hasToothpick == null) {
            System.out.println("Ой, в файлике было некорректное значение наличия зубочистки X~o");
            this.hasToothpick = false;
        } else {
            this.hasToothpick = hasToothpick;
        }
    }

    public void setImpactSpeed(long impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setMood(String input) {
        if (input == null) {
            this.weaponType = null;
            return;
        }
        try {
            this.mood = Mood.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Ой, в файлике было некорректное значение настроения X~o");
            this.mood = null;
        }
    }

    public Mood getMood() {
        return mood;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Jon Doe";
            System.out.println("Ой, в файлике было некорректное имя X~o");
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setRealHero(Boolean realHero) {
        if (realHero == null) {
            System.out.println("Ой, в файлике было некорректное значение истинности героя X~o");
            this.realHero = false;
        } else {
        this.realHero = realHero;
        }
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public void setWeaponType(String input) {
        if (input == null) {
            this.weaponType = null;
            return;
        }
        try {
            this.weaponType = WeaponType.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e){
            System.out.println("Ой, в файлике было некорректное значение типа оружия X~o");
            this.weaponType = null;
        }
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    /**
     * Переопределённый {@code toString()}, использующийся при выводе элементов коллекции
     *
     * @return Описание элементов коллекции
     */
    @Override
    public String toString() {
        return "Элемент " + id +
                "\n Имя: " + name +
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
                Integer.compare((int) this.id, (int) human.id) +
                Integer.compare((int) this.impactSpeed, (int) human.impactSpeed);

    }


}
