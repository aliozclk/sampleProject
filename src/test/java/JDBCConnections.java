import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.sql.*;

public class JDBCConnections {

    public static void main(String[] args) throws SQLException {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Desktop\\drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        String host = "localhost";
        String port = "3306";

        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo" ,"root","rootpass");

        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from credentials where scenario ='user1';");

        while (rs.next()){
            driver.get("https://login.salesforce.com/");

            driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
            driver.findElement(By.id("password")).sendKeys(rs.getString("password"));

            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("password"));
        }

    }
}
