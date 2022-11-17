package org.example;

import Bouquet.Bouquet;
import Flowers.Color;
import Flowers.Flowers;
import Flowers.Tulip;
import Interface.HelloApplication;
import Menu.Menu;
import SQL.SQL;
import javafx.application.Application;

import java.text.ParseException;
import java.util.Scanner;

public class Main{
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws ParseException {
        Menu menu = new Menu();
        SQL.execute();
        menu.menu();
    }
}
