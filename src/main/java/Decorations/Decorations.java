package Decorations;

import Flowers.Color;

public class Decorations {
    public String name;
    public Double price;

    public Decorations(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Decoration:" +
                "Name - '" + name +
                ", Price - " + price;
    }
}
