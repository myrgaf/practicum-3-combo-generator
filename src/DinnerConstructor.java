import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    public HashMap<String, ArrayList<Dish>> dishesByType = new HashMap<>();
    public Random random = new Random();

    public boolean checkType(String type) {
        return dishesByType.containsKey(type);
    }

    public void addDish(String type, String name) {
        Dish dish = new Dish(type, name);
        dishesByType.computeIfAbsent(type, k -> new ArrayList<>()).add(dish);
    }

    public ArrayList<ArrayList<Dish>> generateCombinations(int count, ArrayList<String> types) {
        ArrayList<ArrayList<Dish>> generatedCombinations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ArrayList<Dish> currentCombination = new ArrayList<>();
            for (String type : types) {
                if (checkType(type)) {
                    ArrayList<Dish> dishesOfType = dishesByType.get(type);
                    if (!dishesOfType.isEmpty()) {
                        Dish randomDish = dishesOfType.get(random.nextInt(dishesOfType.size()));
                        currentCombination.add(randomDish);
                    }
                } else {
                    System.out.printf("Тип блюда %s не существует.%n", type);
                }
            }
            generatedCombinations.add(currentCombination);
        }
        return generatedCombinations;
    }
}
