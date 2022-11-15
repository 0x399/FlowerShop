package Bouquet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

import Decorations.Decorations;
import Flowers.*;
import Menu.Menu;
import SQL.SQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bouquet{
    Scanner sc = new Scanner(System.in);
    static Connection connection;
    public ArrayList<Flowers> flowersArr = new ArrayList<Flowers>();
    ArrayList<Decorations> decorArr = new ArrayList<Decorations>();
    private final Logger logger = LogManager.getLogger();

    public void AddToBouquet(Flowers flower) {
        flowersArr.add(flower);
        if (flower instanceof Rose){
            Rose.Quantity -=1;}
        if (flower instanceof Tulip){
            Tulip.Quantity-=1;}
        if(flower instanceof Chrisanthemum) {
            Chrisanthemum.Quantity-=1;}
    }

    public ArrayList<Decorations> AddDecor(Decorations dec) {
        this.decorArr.add(dec);
        return decorArr;
    }

    public void RemoveFlower(int index){
        this.flowersArr.remove(index);
    }
    public void RemoveFlower(Flowers fl){
        this.flowersArr.remove(fl);
        if (fl instanceof Rose){
            Rose.Quantity +=1;}
        if (fl instanceof Tulip){
            Tulip.Quantity+=1;}
        if(fl instanceof Chrisanthemum) {
            Chrisanthemum.Quantity+=1;}
    }

    public void RemoveDecorations(Decorations dc){this.decorArr.remove(dc);}
    public void RemoveDecorations(int index){
        this.decorArr.remove(index);
    }

    @Override
    public String toString() {
        for (int i = 0; i < flowersArr.size(); i++) {
            System.out.println(i+1);
            System.out.println(flowersArr.get(i));
        }
        for (int i = 0; i < decorArr.size(); i++) {
            System.out.println(i+1);
            System.out.println(decorArr.get(i));
        }
        return "";
    }

    public double FindPrice(){
        double TotalPrice = 0.0;
        for (int i = 0; i < this.flowersArr.size(); i++) {
            TotalPrice += this.flowersArr.get(i).getPrice();
        }
        for (int i = 0; i < this.decorArr.size(); i++){
            TotalPrice += this.decorArr.get(i).price;
        }
        return (TotalPrice);
    }

    public void FindShortestStem(){
        Comparator<Flowers> comparator = Comparator.reverseOrder();
        comparator = Comparator.comparing(obj -> obj.stem_len);
        Collections.sort(flowersArr, comparator);
        int k = 0;
        do{
            System.out.println(this.flowersArr.get(k));
            k++;
        }while (this.flowersArr.get(k).stem_len == this.flowersArr.get(k+1).stem_len);
    }

    public void FindFreshest(){
        Comparator<Flowers> comparator2 = Comparator.comparing(obj -> obj.ArrivalDate);
        Collections.sort(flowersArr, comparator2);
        Collections.reverse(flowersArr);
        int k = 0;
        do{
            System.out.println(this.flowersArr.get(k));
            k++;
        }while (this.flowersArr.get(k).ArrivalDate == this.flowersArr.get(k+1).ArrivalDate);
    }

    public void ChooseFlower() throws ParseException {
        System.out.println("1 - to add rose, 2 - to add tulip, 3 - to add chrysanthemum, 4 - to go back");
        int input = sc.nextInt();
        switch (input){
            case 1:
                try {
                    this.AddToBouquet(new Rose());
                } catch (ParseException e) {
                    logger.error("Failed to create new instance of Rose class");
                    throw new RuntimeException(e);
                }
                ChooseFlower();
                break;
            case 2:
                try {
                    this.AddToBouquet(new Tulip());
                } catch (ParseException e) {
                    logger.error("Failed to create new instance of Tulip class");
                    throw new RuntimeException(e);
                }
                ChooseFlower();
                break;
            case 3:
                try {
                    this.AddToBouquet(new Chrisanthemum());
                } catch (ParseException e) {
                    logger.error("Failed to create new instance of Chrisanthemum class");
                    throw new RuntimeException(e);
                }
                ChooseFlower();
                break;
            case 4:
                Menu menu = new Menu();
                menu.bq(this);
                break;
            default:
                logger.warn("Illegal argument entered");
                this.ChooseFlower();
                break;
        }
    }

    public void ChooseFlower(int input) throws ParseException {
        System.out.println("1 - to add rose, 2 - to add tulip, 3 - to add chrysanthemum, 4 - to go back");
        switch (input){
            case 1: this.AddToBouquet(new Rose());
                ChooseFlower();
                break;
            case 2: this.AddToBouquet(new Tulip());
                ChooseFlower();
                break;
            case 3: this.AddToBouquet(new Chrisanthemum());
                ChooseFlower();
                break;
            case 4:
                Menu menu = new Menu();
                menu.bq(this);
                break;
        }
    }

    public void ChooseDecorations() throws ParseException {
        System.out.println("1 - to add Ribbon, 15.00, 2 - to add Paper, 10.00, 3 - to add Fern, 20.00, 4 - to go back");
        int input = sc.nextInt();
        switch (input){
            case 1: Decorations dc = new Decorations("Ribbon", 15.00);
                this.AddDecor(dc);
                ChooseDecorations();
                break;
            case 2: Decorations dc1 = new Decorations("Paper", 10.00);
                this.AddDecor(dc1);
                ChooseDecorations();
                break;
            case 3: Decorations dc2 = new Decorations("Fern", 20.00);
                this.AddDecor(dc2);
                ChooseDecorations();
                break;
            case 4:
                Menu menu = new Menu();
                menu.bq(this);
                break;
        }
    }
    public void receipt() throws IOException {
        BufferedWriter myWriter = new BufferedWriter(new FileWriter("filename.txt"));
        for(int i = 0; i < flowersArr.size(); i++){
            myWriter.append(String.valueOf(flowersArr.get(i)));
            myWriter.append("\n");
        }
        for(int i = 0; i < decorArr.size(); i++){
            myWriter.append(String.valueOf(decorArr.get(i)));
            myWriter.append("\n");
        }
        myWriter.append("\nTotal price =");
        myWriter.append(String.valueOf(this.FindPrice()));
        System.out.println("\n");
        myWriter.append("Thanks for shopping at our store!");
        myWriter.close();
        SQL l1 = new SQL();
        try {
            l1.executeBouquet(String.valueOf(this.FindPrice()), String.valueOf(flowersArr.size()), String.valueOf(decorArr.size()));
            System.out.println("Receipt added to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}