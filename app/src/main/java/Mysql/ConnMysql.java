package Mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnMysql {
    private static final String url = "jdbc:mysql://192.168.10.27:3306/BaseEnotv5";
    private static final String url2 = "jdbc:mysql://localhost:3306/baseenottest";
    private static final String user = "root";
    private static final String pass = "3asftorg";
    public static String log="";
    Connection con = null;

    public ConnMysql(){

        Conn();

    }

    private void Conn(){

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            log = log +"com.mysql.jdbc.Driver\n";
        }catch(Exception e){
            log = log +"Cannot create connection\n";
        }
        try{
            con =
                    DriverManager.getConnection(url,user,pass);
            /*
            Statement statement = connection.createStatement();

            String query = "SELECT column1, column2 FROM table1 WHERE column3 = ";
            query = query +"'" +variable+"'";
            ResultSet result = statement.executeQuery(query);
            */
            log = log + "Connect MySql!\n";
        }catch(SQLException  e) {
            log = log + e.toString() + "\n";

        }
    }
}
