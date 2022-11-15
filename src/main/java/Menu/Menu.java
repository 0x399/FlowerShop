package Menu;

import Bouquet.Bouquet;
import Command.CommandDemo;
import Warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import Email.Email;
import Email.EmailService;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private final Logger logger = LogManager.getLogger();
    private final Email email = new Email(new EmailService());

    public void menu() throws ParseException {
        System.out.println("Flower shop:");
        System.out.println("1 to check available flowers:");
        System.out.println("2 to create a new bouquet");
        System.out.println("3 to enter a command manually");
        System.out.println("4 to exit");
        int input = sc.nextInt();
        if(input < 0 || input > 4){
            logger.error("Invalid input");
            //email.run();
        }
        switch (input){
            case 1: Warehouse.display();
                break;
            case 2: bq();
                break;
            case 3:
                CommandDemo cd = new CommandDemo();
                cd.command(new String[]{"display"});
                break;
            case 4: return;

        }
    }

    public void bq() throws ParseException {
        System.out.println("Creating a bouquet:");
        Bouquet bq = new Bouquet();
        System.out.println("1 - to add new flower, 2 - to add decorations, 3 - to change flower, 4 - to write a receipt");
        System.out.println("5 - to remove flower, 6 - to remove decorations, 7 - to go back, 8 - to find the shortest stem.");
        System.out.println("9 - to sort by freshness.");
        int input = sc.nextInt();
        if(input < 0 || input > 9){
            logger.warn("Invalid input");
            bq(bq);
        }
        switch (input){
            case 1:
                try {
                    bq.ChooseFlower();
                } catch (ParseException e) {
                    logger.error("Error in flowers choice");
                    //email.run();
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    bq.ChooseDecorations();
                } catch (ParseException e) {
                    logger.error("Error in decorations choice.");
                    //email.run();
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                System.out.println(bq);
                System.out.println("Choose flower to change");
                int choice = sc.nextInt();
                try {
                    bq.flowersArr.get(choice - 1).changeFlower();
                } catch (ParseException e) {
                    logger.error("Error in flower alteration window.");
                    throw new RuntimeException(e);
                }
                this.bq();
                break;
            case 4:
                try {
                    bq.receipt();
                    logger.info("User has created a receipt.");
                } catch (IOException e) {
                    logger.error("Failed to create receipt.");
                    //email.run();
                    throw new RuntimeException(e);
                }
                break;
            case 5:System.out.println(bq);
                System.out.println("Choose flower to delete");
                int choice2 = sc.nextInt();
                bq.RemoveFlower(choice2 - 1);
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Error in bouquet creation screen.");
                    throw new RuntimeException(e);
                }
                break;
            case 6:System.out.println(bq);
                System.out.println("Choose decoration to delete");
                int choice3 = sc.nextInt();
                bq.RemoveDecorations(choice3 - 1);
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Error in bouquet creation screen.");
                    throw new RuntimeException(e);
                }
                break;
            case 7:
                try {
                    menu();
                } catch (ParseException e) {
                    logger.info("Failed to return to main menu.");
                    throw new RuntimeException(e);
                }
                break;
            case 8: bq.FindShortestStem();
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Error in bouquet creation screen.");
                    throw new RuntimeException(e);
                }
                break;
            case 9: bq.FindFreshest();
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Failed to sort by date.");
                    throw new RuntimeException(e);
                }
                break;

        }


    }


    public void bq(Bouquet bq) throws ParseException {
        System.out.println(bq);
        System.out.println("1 - to add new flower, 2 - to add decorations, 3 - to change flower, 4 - to write a receipt");
        System.out.println("5 - to remove flower, 6 - to remove decorations, 7 - to go back, 8 - to find the shortest stem.");
        int input = sc.nextInt();
        if(input < 0 || input > 9){
            logger.warn("Invalid input");
            bq(bq);
        }
        switch (input){
            case 1: bq.ChooseFlower();
                break;
            case 2: bq.ChooseDecorations();
                break;
            case 3:
                System.out.println(bq);
                System.out.println("Choose flower to change");
                int choice = sc.nextInt();
                bq.flowersArr.get(choice - 1).changeFlower();
                bq(bq);
                break;
            case 4:
                try {
                    bq.receipt();
                    logger.info("User has created a receipt.");
                } catch (IOException e) {
                    logger.error("Failed to create receipt.");
                    //email.run();
                    throw new RuntimeException(e);
                }
                break;
            case 5:System.out.println(bq);
                System.out.println("Choose flower to delete");
                int choice2 = sc.nextInt();
                bq.RemoveFlower(choice2 - 1);
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Error in bouquet creation screen.");
                    throw new RuntimeException(e);
                }
                break;
            case 6:System.out.println(bq);
                System.out.println("Choose decoration to delete");
                int choice3 = sc.nextInt();
                bq.RemoveDecorations(choice3 - 1);
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Error in bouquet creation screen.");
                    throw new RuntimeException(e);
                }
                break;
            case 7:
                try {
                    menu();
                } catch (ParseException e) {
                    logger.info("Failed to return to main menu.");
                    throw new RuntimeException(e);
                }
                break;
            case 8: bq.FindShortestStem();
                try {
                    bq(bq);
                } catch (ParseException e) {
                    logger.error("Error in bouquet creation screen.");
                    throw new RuntimeException(e);
                }
                break;
            case 9: bq.FindFreshest();
                bq(bq);
                break;

        }


    }
}
