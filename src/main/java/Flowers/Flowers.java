package Flowers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public abstract class Flowers implements Comparable<Flowers>{
    Scanner sc = new Scanner(System.in);
    static Scanner sc2 = new Scanner(System.in);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    public String name;
    public Double stem_len;
    private Double price;
    public Color color;
    public String ArrivalDate;
    public static Integer Quantity;

    public Flowers(String name, double stem_len, double price, Color color, String date) throws ParseException {
        this.name = name;
        this.stem_len = stem_len;
        this.price = price;
        this.color = color;
        this.ArrivalDate = sdf.format(sdf.parse(String.valueOf(date)));
    }

    public Flowers() {

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static Integer getQuantity() {
        return Quantity;
    }

    public static void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public void setPrice(){
        System.out.println("Current price = " + this.getPrice());
        System.out.println("Enter the new price:");
        price = sc.nextDouble();
    }

    public void setPrice(double np){
        System.out.println("Current price = " + this.getPrice());
        this.price = np;
    }


    public void ChangeStem() {
        System.out.println(this.stem_len);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new stem length:");
        Double len = null;
        if (sc.hasNextLine()) {
            len = sc.nextDouble();
        }
        System.out.println("New stem length -" + len);
        this.stem_len = len;
    }

    public void ChangeStem(double len) {
        System.out.println("New stem length -" + len);
        this.stem_len = len;
    }
    public void changeColor(){
        {
            System.out.println("Change flower color to:");
            System.out.println("1 - white, 2 - black, 3 - red, 4 - yellow, 5 - purple, 6 - blue, 7 - beige");
            int input = sc.nextInt();
            switch (input){
                case 1 -> {
                    this.color = Color.white;
                    break;
                }
                case 2 -> {
                    this.color = Color.black;
                    break;
                }
                case 3 -> {
                    this.color = Color.red;
                    break;
                }
                case 4 -> {
                    this.color = Color.yellow;
                    break;
                }
                case 5 -> {
                    this.color = Color.purple;
                    break;
                }
                case 6 -> {
                    this.color = Color.blue;
                    break;
                }
                case 7 -> {
                    this.color = Color.beige;
                    break;
                }
            }
        }
    }

    public void changeColor(int num){
        int input = num;
        switch (input){
            case 1 -> {
                this.color = Color.white;
                break;
            }
            case 2 -> {
                this.color = Color.black;
                break;
            }
            case 3 -> {
                this.color = Color.red;
                break;
            }
            case 4 -> {
                this.color = Color.yellow;
                break;
            }
            case 5 -> {
                this.color = Color.purple;
                break;
            }
            case 6 -> {
                this.color = Color.blue;
                break;
            }
            case 7 -> {
                this.color = Color.beige;
                break;
            }
        }
    }


    public void changeDate() throws ParseException {
        System.out.println("Enter the arrival date:");
        System.out.println("(dd.mm.yyyy)");
        String date = sc.next();
        if (date.equals("back")){
            this.changeFlower();
        }
        this.ArrivalDate = sdf.format(sdf.parse(String.valueOf(date)));
    }

    public void changeDate(String date) throws ParseException {
        if (date.equals("back")){
            this.changeFlower();
        }
        this.ArrivalDate = sdf.format(sdf.parse(String.valueOf(date)));
    }
    public void changeFlower() throws ParseException {
        System.out.println(this);
        System.out.println("1 - change color, 2 - change stem length, 3 - change date, 4 - change price");
        int choice = sc2.nextInt();
        switch (choice) {
            case 1: this.changeColor();
                break;
            case 2: this.ChangeStem();
                break;
            case 3: this.changeDate();
                break;
            case 4:
                System.out.println("Enter a new price");
                this.setPrice(sc.nextDouble());
                break;

        }
    }

    @Override
    public int compareTo(Flowers fl){
        this.stem_len = this.stem_len;
        fl.stem_len = fl.stem_len;
        return this.stem_len.compareTo(fl.stem_len);
    }
    @Override
    public String toString() {
        return name + ":" +
                " Stem Length: " + stem_len +
                ", Price: " + price +
                ", Color: " + color + ", Delivered on: " + sdf.format(ArrivalDate);
    }
}
