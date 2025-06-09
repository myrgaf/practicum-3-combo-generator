package ru.practicum.dinner;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor constructor;
    static Scanner scanner;

    public static void main(String[] args) {
        constructor = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        constructor.addDish(dishType, dishName);
        System.out.println("Блюдо добавлено!");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюд, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку:");
        ArrayList<String> dishTypes = new ArrayList<>();
        String nextItem = scanner.nextLine();

        while (!nextItem.isEmpty()) {
            dishTypes.add(nextItem);
            nextItem = scanner.nextLine();
        }

        List<List<Dish>> combinations = constructor.generateCombinations(numberOfCombos, dishTypes);
        for (List<Dish> combination : combinations) {
            System.out.println(combination);
        }
    }
}
