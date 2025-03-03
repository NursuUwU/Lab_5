package commands;

import data.*;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class AddElementService {
    protected final LinkedHashSet<HumanBeing> collection;
    protected final Scanner scanner = new Scanner(System.in);

    public AddElementService(LinkedHashSet<HumanBeing> collection) {
        this.collection = collection;
    }

    /**
     * Этот метод выводит все поля заданного енама
     * @param enumClass Это класс енама, поля которого необходимо вывести пользователю
     */
    public <T extends Enum<T>> void printEnumValues(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        for (T value: values) {
            System.out.println(value);
        }
    }

    /**
     * Этот метод создаеёт элемент коллекции LinkedHashSet<HumanBeing> collection
     * с заданными значениями полей
     * @param args Поля стандартного типа данных создаваемого элемента
     * @return HumanBeing Возвращает элемент коллекции LinkedHashSet<HumanBeing> collection
     */
    public HumanBeing createElement(String[] args) {
        if (args.length != 5) {
            System.out.println("Кажется вы ввели не 4 аргумента TwT");
            return null;
        }
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



        System.out.println("Введите название машины: ");
        String carName = scanner.nextLine();

        Boolean cool;
        while (true) {
            System.out.println("Введите параметр машины cool: ");
            try {
                String coolInput = scanner.nextLine();
                if (!coolInput.isEmpty()) {
                    cool = Boolean.parseBoolean(coolInput);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ой, тут может быть только true/false T~T");
            }
        }



        Car car = new Car(carName, cool);
        return new HumanBeing(name, realHero, hasToothpick, impactSpeed, coordinates, weaponType, mood, car);
    }
}
