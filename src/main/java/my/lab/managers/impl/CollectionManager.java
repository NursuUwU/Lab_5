package my.lab.managers.impl;

import my.lab.data.*;
import my.lab.managers.GettableCollection;
import my.lab.managers.Removeable;
import my.lab.exceptions.NoSuchIdException;
import my.lab.managers.Creatable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
//TODO: перенести логику проверки в сеттеры геттеры
public class CollectionManager implements Removeable, Creatable, GettableCollection {
    private LinkedHashSet<HumanBeing> collection;
    private final Scanner scanner = new Scanner(System.in);

    public CollectionManager(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }

    /**
     * Стандартный геттер для коллекции элементов
     * @return Возвращает коллекцию элементов HumanBeing
     */
    @Override
    public LinkedHashSet<HumanBeing> getCollection() {
        return collection;
    }

    /**
     * Стандартный сеттер для коллекции элементов
     * @param collection Коллекция элементов
     */
    public void setCollection(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }

    /**
     * Удаляет элемент из коллекции
     * @param args id элемента
     */
    @Override
    public void remove(String[] args) throws NumberFormatException {
        long id = 0;
        id = Long.parseLong(args[1]);


        Iterator<HumanBeing> iterator = collection.iterator();
        HumanBeing oldElement = null;
        while (iterator.hasNext()) {
            HumanBeing human = iterator.next();
            if (human.getId() == id) {
                oldElement = human;
                iterator.remove();
                break;
            }
        }
        if (oldElement == null) {
            throw new NoSuchIdException("Элемент с данным id не найден 0~0");
        }
    }

    /**
     * Этот метод выводит все поля заданного енама
     *
     * @param enumClass Это класс енама, поля которого необходимо вывести пользователю
     */
    private <T extends Enum<T>> void printEnumValues(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        for (T value : values) {
            System.out.println(value);
        }
    }

    /**
     * Этот метод создаеёт элемент коллекции {@code LinkedHashSet<HumanBeing>} collection
     * с заданными значениями полей
     */
    @Override
    public HumanBeing createElement() {
        long id = 1;

        String name;
        while(true) {
            System.out.println("Введите имя: ");
            String nameInput = scanner.nextLine();
            if (!nameInput.isEmpty()) {
                name = nameInput;
                break;
            } else {
                System.out.println("Ой, кажется вы не ввели имя TwT");
            }
        }

        Boolean realHero;
        while (true) {
            System.out.println("Введите значение настоящего героя (true/false): ");
            String realHeroInput = scanner.nextLine().toLowerCase();
            if (!realHeroInput.isEmpty() && (realHeroInput.equals("true") || realHeroInput.equals("false"))) {
                realHero = Boolean.parseBoolean(realHeroInput);
                break;
            } else {
                System.out.println("Ой, кажется вы не ввели нужное значение OwO");
            }
        }

        boolean hasToothpick;
        while(true) {
            System.out.println("Введите наличие зубочистки (true/false): ");
            String hasToothpickInput = scanner.nextLine().toLowerCase();
            if (!hasToothpickInput.isEmpty() && (hasToothpickInput.equals("true") || hasToothpickInput.equals("false"))) {
               hasToothpick = Boolean.parseBoolean(hasToothpickInput);
               break;
            } else {
                System.out.println("Ой, кажется вы не ввели нужное значение OwO");
            }
        }

        long impactSpeed;
        while(true) {
            System.out.println("Введите скорость удара: ");
            String impactSpeedInput = scanner.nextLine();
            if (!impactSpeedInput.isEmpty()) {
                try {
                    impactSpeed = Long.parseLong(impactSpeedInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ой, кажется вы ввели не число O~O");
                }
            } else {
                System.out.println("Ой, кажется вы не ввели скорость удара TwT");
            }
        }


        double x;
        while (true) {
            System.out.println("Введите x координату (больше -12): ");
            String xInput = scanner.nextLine();
            try {
                BigDecimal temp = new BigDecimal(xInput);
                temp = temp.setScale(5, RoundingMode.DOWN);
                x = temp.doubleValue();
                if (x > -12) {
                    break;
                } else {
                    System.out.println("Дурашка, координата x должна быть больше -12 ~");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ой, кажется вы ввели не число O~O");
            }
        }

        long y;
        while (true) {
            System.out.println("Введите y координату (больше -255): ");
            String yInput = scanner.nextLine();
            try {
                BigDecimal temp = new BigDecimal(yInput);
                temp = temp.setScale(5, RoundingMode.DOWN);
                y = temp.longValue();
                if (y > -255) {
                    break;
                } else {
                    System.out.println("Дурашка, координата y должна быть больше -255 и не пустой (или введено число слишком близкое к границе) ~");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ой, кажется вы ввели не число O~O");
            }
        }

        Coordinates coordinates = new Coordinates(x, y);

        String weaponType = null;
        while (true) {
            System.out.println("Введите оружие (не обязательно). Доступные виды: ");
            printEnumValues(WeaponType.class);
            String weaponInput = scanner.nextLine();
            if (weaponInput.isEmpty()) break;
            try {
                weaponType = WeaponType.valueOf(weaponInput.toUpperCase()).toString();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, такого оружия нет o~x");
            }
        }
        String mood = null;
        while (true) {
            System.out.println("Введите настроение (не обязательно). Доступные настроения: ");
            printEnumValues(Mood.class);
            String moodInput = scanner.nextLine();
            if (moodInput.isEmpty()) break;
            try {
                mood = Mood.valueOf(moodInput.toUpperCase()).toString();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, такого настроения нет O~x");
            }
        }

        String carName;
        while (true) {
            System.out.println("Введите название машины: ");
            String carNameInput = scanner.nextLine();
            if (!carNameInput.isEmpty()) {
                carName = carNameInput;
                break;
            } else {
                System.out.println("Ой, кажется вы не ввели название машины x~U");
            }
        }
        boolean cool;
        while (true) {
            System.out.println("Введите крутость машины (true/false): ");
            try {
                String coolInput = scanner.nextLine();
                if (!coolInput.isEmpty() && (coolInput.equals("true") || coolInput.equals("false"))) {
                    cool = Boolean.parseBoolean(coolInput);
                    break;
                } else {
                    System.out.println("Ой, кажется вы не ввели значение крутости TwT");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, кажется вы ввели не то значение T~T");
            }
        }

        Car car = new Car(carName, cool);

        return new HumanBeing(id, new Date().toString(), name, realHero, hasToothpick, impactSpeed, coordinates, weaponType, mood, car);
    }
}
