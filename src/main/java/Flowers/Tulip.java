package Flowers;

import java.text.ParseException;
import java.util.Date;

public class Tulip extends Flowers{
    public static Color color;
    public static Integer Quantity = 300;

    public Tulip(String name, double stem_len, double price, Color color, String date) throws ParseException {
        super(name, stem_len, price, color, date);
    }

    public Tulip() throws ParseException {
        super();
        this.name = "Tulip";
        this.stem_len = 12.00;
        this.setPrice(50.00);
        this.color = Color.red;
        this.ArrivalDate = sdf.format(sdf.parse("19.10.2022"));
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
    @Override
    public String toString() {
        return "Tulip{" +
                "name='" + name + '\'' +
                ", stem_len=" + stem_len +
                ", price=" + getPrice() +
                ", color=" + color +
                ", ArrivalDate=" + ArrivalDate +
                ", Quantity=" + Quantity +
                '}';
    }
}
