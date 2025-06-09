package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    public HashMap<String, ArrayList<Dish>> dishesByType = new HashMap<>();
    public Random random = new Random();

    public void addDish(String type, String name) {
        Dish dish = new Dish(type, name);
        dishesByType.computeIfAbsent(type, k -> new ArrayList<>()).add(dish);
    }

    public ArrayList<ArrayList<Dish>> generateCombinations(int count, ArrayList<String> types) {
        ArrayList<ArrayList<Dish>> generatedCombinations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ArrayList<Dish> currentCombination = new ArrayList<>();
            for (String type : types) {
                ArrayList<Dish> dishesOfType = dishesByType.get(type);
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
