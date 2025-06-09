package ru.practicum.dinner;

public class Dish {
    public String type;
    public String name;

    public Dish(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}