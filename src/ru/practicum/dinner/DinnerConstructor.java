package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Класс для управления блюдами и генерации комбинаций
public class DinnerConstructor {
    // Хранение блюд по типам
    private Map<String, List<Dish>> dishesByType = new HashMap<>();
    private Random random = new Random(); // Для случайного выбора блюд

    // Метод для добавления нового блюда
    public void addDish(String type, String name) {
        Dish dish = new Dish(type, name);
        // Если тип блюда новый, создаем новый список для него
        dishesByType.computeIfAbsent(type, k -> new ArrayList<>()).add(dish);
    }

    // Метод для генерации комбинаций блюд
    public List<List<Dish>> generateCombinations(int count, ArrayList<String> types) {
        List<List<Dish>> generatedCombinations = new ArrayList<>();

        // Генерация заданного количества комбинаций
        for (int i = 0; i < count; i++) {
            List<Dish> currentCombination = new ArrayList<>();
            // Для каждого типа выбираем случайное блюдо
            for (String type : types) {
                List<Dish> dishesOfType = dishesByType.get(type);
                if (dishesOfType != null && !dishesOfType.isEmpty()) {
                    Dish randomDish = dishesOfType.get(random.nextInt(dishesOfType.size()));
                    currentCombination.add(randomDish);
                }
            }
            generatedCombinations.add(currentCombination);
        }

        return generatedCombinations;
    }
}
