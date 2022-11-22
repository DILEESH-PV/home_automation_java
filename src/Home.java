import java.sql.*;
import java.util.Scanner;

public class Home {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, humidity, moisture;
        float temperature;
        while (true) {
            System.out.println("Select an option: ");
            System.out.println("1. Add a data");
            System.out.println("2. View all datas");
            System.out.println("3. Search data");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the temperature");
                    temperature=sc.nextFloat();
                    System.out.println("Enter the humidity");
                    humidity=sc.nextInt();
                    System.out.println("Enter the moisture");
                    moisture=sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/homeautomationdb","root","");
                        String sql="INSERT INTO `sensorvalues`(`temperature`, `humidity`, `moisture`, `date`)VALUES (?,?,?,now())";
                        PreparedStatement stmt=con.prepareStatement(sql);
                        stmt.setFloat(1,temperature);
                        stmt.setInt(2,humidity);
                        stmt.setInt(3,moisture);
                        stmt.executeUpdate();
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);}
                    break;
                case 2:
                    System.out.println("View all data");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/homeautomationdb","root","");
                        String sql="SELECT `temperature`, `humidity`, `moisture`, `date` FROM `sensorvalues` ";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next())
                        {
                            temperature=rs.getFloat("temperature");
                            humidity=rs.getInt("humidity");
                            moisture=rs.getInt("moisture");
                            String date=rs.getString("date");
                            System.out.println("Temperature :"+temperature);
                            System.out.println("Humidity    :"+humidity);
                            System.out.println("Moisture    :"+moisture);

                            System.out.println("Date        :"+date+"\n");
                        }

                    }
                    catch (Exception e)
                    {
                        System.out.println(e);}
                    break;
                case 3:
                    System.out.println("Enter the date for seaching ");
                    String da=sc.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homeautomationdb", "root", "");
                        String sql = "SELECT `temperature`, `humidity`, `moisture` FROM `sensorvalues` WHERE `date`='"+da+"'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next())
                        {  String gettemperature=rs.getString("temperature");
                           String gethumidity=rs.getString("humidity");
                            String getmoisture=rs.getString("moisture");
                            String dat=rs.getString("date");
                            System.out.println("Temperature :"+gettemperature);
                            System.out.println("Humidity    :"+gethumidity);
                            System.out.println("Moisture    :"+getmoisture);

                            System.out.println("Date        :"+dat+"\n");
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
            }
        }
    }
}

