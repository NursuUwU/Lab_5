package managers.realisations;

import data.*;
import managers.ints.Creatable;
import managers.ints.GettableCollection;
import managers.ints.Removeable;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CollectionManager implements Removeable, Creatable, GettableCollection {
    private LinkedHashSet<HumanBeing> collection;
    private Scanner scanner = new Scanner(System.in);
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
    public void remove(String[] args) {
        long id = 0;
        if (args.length < 2) {
            System.out.println("Ой, введите, пожалуйста, id Ono");
            return;
        }
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Ой, id должен быть числом x~O");
            return;
        }

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
            System.out.println("Элемент с данным id не найден 0~0");
        }
    }

    /**
     * Этот метод выводит все поля заданного енама
     * @param enumClass Это класс енама, поля которого необходимо вывести пользователю
     */
    private <T extends Enum<T>> void printEnumValues(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        for (T value: values) {
            System.out.println(value);
        }
    }

    /**
     * Этот метод создаеёт элемент коллекции {@code LinkedHashSet<HumanBeing>} collection
     * с заданными значениями полей
     * @param args Поля стандартного типа данных создаваемого элемента
     */
    @Override
    public HumanBeing createElement(String[] args) {
        String name = null;
        try {
            String nameInput = args[1];
            if (!nameInput.isEmpty()) {
                name = nameInput;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ой, имя не может быть пустым *~x");
            return null;
        }
        Boolean realHero = Boolean.parseBoolean(args[2]);
        boolean hasToothpick = Boolean.parseBoolean(args[3]);
        long impactSpeed = 0;
        try {
            String impactSpeedInput = args[4];
            if (!impactSpeedInput.isEmpty()) {
                impactSpeed = Long.parseLong(args[4]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ой, кажется вы ввели не число O~O");
            return null;
        }


        double x;
        while (true) {
            System.out.println("Введите x координату (больше -12) : ");
            String xInput = scanner.nextLine();
            try {
                x = Double.parseDouble(xInput);
                if (x > -12) {
                    break;
                } else {
                    System.out.println("Дурашка, координата x должна быть больше -12 ~");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ой, кажется вы ввели не число O~O");
            }
        }
        Long y;
        while (true) {
            System.out.println("Введите y координату (больше -255) : ");
            String yInput = scanner.nextLine();
            try {
                y = Long.parseLong(yInput);
                if (y > -255) {
                    break;
                } else {
                    System.out.println("Дурашка, координата y должна быть больше -255 и не пустой ~");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ой, кажется вы ввели не число O~O");
            }
        }
        Coordinates coordinates = new Coordinates(x, y);

        WeaponType weaponType = null;
        while (true) {
            System.out.println("Введите оружие (не обязательно). Доступные виды: ");
            printEnumValues(WeaponType.class);
            String weaponInput = scanner.nextLine();
            if (weaponInput.isEmpty()) break;
            try {
                weaponType = WeaponType.valueOf(weaponInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, такого оружия нет o~x");
            }
        }
        Mood mood = null;
        while (true) {
            System.out.println("Введите настроение (не обязательно). Доступные настроения: ");
            printEnumValues(Mood.class);
            String moodInput = scanner.nextLine();
            if (moodInput.isEmpty()) break;
            try {
                mood = Mood.valueOf(moodInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, такого настроения нет O~x");
            }
        }

        String carName;
        while(true) {
            System.out.println("Введите название машины: ");
            String carNameInput = scanner.nextLine();
            if(!carNameInput.isEmpty()) {
                carName = carNameInput;
                break;
            } else {
                System.out.println("Ой, кажется вы не ввели название машины x~U");
            }
        }
        Boolean cool;
        while (true) {
            System.out.println("Введите параметр машины cool: ");
            try {
                String coolInput = scanner.nextLine();
                if (!coolInput.isEmpty()) {
                    cool = Boolean.parseBoolean(coolInput);
                    break;
                } else {
                    System.out.println("Ой, кажется вы не ввели значение крутости TwT");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, тут может быть только true/false T~T");
            }
        }

        Car car = new Car(carName, cool);
        return new HumanBeing(name, realHero, hasToothpick, impactSpeed, coordinates, weaponType, mood, car);
    }
}
