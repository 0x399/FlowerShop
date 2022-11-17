package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQL {
    static String url = "jdbc:sqlserver://LAPTOP-NV0JPFMU:1433;databaseName=FlowerShop;encrypt=true;trustServerCertificate=true;";
    static String username = "sa";
    static String password = "wf6520n7w";
    static Connection connection;
    static String sql = "INSERT INTO dbo.Color(color_name) VALUES ('red')";

    public static void execute() {
        {
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the SQL!");
                //Statement statement = connection.createStatement();
                //statement.executeUpdate(sql);
                System.out.println("Row inserted.");
            } catch (SQLException e) {
                System.out.println("Dovboyob suka, roby zanovo.");
                throw new RuntimeException(e);
            }
        }
    }
    public static void executeBouquet(String price, String qty1, String qty2) throws SQLException {
        String sql = "INSERT INTO dbo.Receipt(Price, FLowers, Decorations, [Time]) VALUES (";
        sql = sql + price + ", " + qty1 + ", " + qty2 + "," + "GETDATE()" + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    };
}
