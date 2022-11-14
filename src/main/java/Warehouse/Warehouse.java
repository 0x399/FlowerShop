package Warehouse;

import Decorations.Decorations;
import Flowers.Flowers;
import Flowers.Rose;
import Flowers.Tulip;
import Flowers.Chrisanthemum;
import Menu.Menu;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Warehouse {
    Scanner sc = new Scanner(System.in);
    public int capacity = 2000;
    ArrayList<Flowers> flowersArr = new ArrayList<Flowers>();
    ArrayList<Decorations> decorArr = new ArrayList<Decorations>();

    public void AddFlower(Flowers flower) {
        flowersArr.add(flower);
    }

    public Flowers TakeFlower(String fl_name) {
        for (int i = 0; i < flowersArr.size(); i++) {
            if (flowersArr.get(i).name == fl_name) {
                Flowers tmp = flowersArr.get(i);
                flowersArr.remove(flowersArr.get(i));
                return tmp;
            }
        }
        return null;
    }

    public static void display() throws ParseException {
        System.out.println("Roses:");
        Rose r1 = new Rose();
        System.out.println("Quantity:");
        System.out.println(Rose.Quantity);
        System.out.println("Color:");
        System.out.println(Rose.color);
        System.out.println("Delivered on:");
        System.out.println(r1.ArrivalDate);
        System.out.println("Price:");
        System.out.println(r1.getPrice());
        System.out.println("Tulips:");
        Tulip t1 = new Tulip();
        System.out.println("Quantity:");
        System.out.println(Tulip.Quantity);
        System.out.println("Color:");
        System.out.println(Tulip.color);
        System.out.println("Delivered on:");
        System.out.println(t1.ArrivalDate);
        System.out.println("Price:");
        System.out.println(t1.getPrice());
        System.out.println("Chrysanthemums:");
        Chrisanthemum c1 = new Chrisanthemum();
        System.out.println("Quantity:");
        System.out.println(Chrisanthemum.Quantity);
        System.out.println("Color:");
        System.out.println(Chrisanthemum.color);
        System.out.println("Delivered on:");
        System.out.println(c1.ArrivalDate);
        System.out.println("Price:");
        System.out.println(c1.getPrice());
        Menu menu = new Menu();
        menu.menu();
    }

    public void display2() throws ParseException {
        System.out.println("Roses:");
        Rose r1 = new Rose();
        System.out.println("Quantity:");
        System.out.println(Rose.Quantity);
        System.out.println("Color:");
        System.out.println(Rose.color);
        System.out.println("Delivered on:");
        System.out.println(r1.ArrivalDate);
        System.out.println("Tulips:");
        Tulip t1 = new Tulip();
        System.out.println("Quantity:");
        System.out.println(Tulip.Quantity);
        System.out.println("Color:");
        System.out.println(Tulip.color);
        System.out.println("Delivered on:");
        System.out.println(t1.ArrivalDate);
        System.out.println("Chrysanthemums:");
        Chrisanthemum c1 = new Chrisanthemum();
        System.out.println("Quantity:");
        System.out.println(Chrisanthemum.Quantity);
        System.out.println("Color:");
        System.out.println(Chrisanthemum.color);
        System.out.println("Delivered on:");
        System.out.println(c1.ArrivalDate);
        Menu menu = new Menu();
        menu.menu();
    }
}
