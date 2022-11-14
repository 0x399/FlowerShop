package Command;

import Bouquet.Bouquet;
import Menu.Menu;
import Warehouse.Warehouse;

import java.text.ParseException;

public class CommandDemo{
    public void command(final String[] arguments) throws ParseException {
        Menu menu = new Menu();
        Bouquet bouquet = new Bouquet();
        Warehouse wh = new Warehouse();

        Command newbq = menu::bq;
        Command display = wh::display2;

        Switch mySwitch = new Switch();
        mySwitch.register("create", newbq);
        mySwitch.register("display", display);

        mySwitch.execute("display");
        mySwitch.execute("create");
    }
}
