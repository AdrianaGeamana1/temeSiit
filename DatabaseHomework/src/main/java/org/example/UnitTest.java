package org.example;

import model.RoomFare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UnitTest {
    public void interrogateUnitTest(){
        List<String> listOfPrices = new ArrayList<>();
        try (
                Connection connection =this.getDBConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT a.acc_type,rf.season,rf.value FROM accommodation_room_fare_relation arf JOIN accommodation a ON a.id=arf.accommodation_id JOIN room_fare rf ON rf.id=arf.room_fare_id ");
        ) {

            while (rs.next()) {
                String r1=rs.getString("acc_type");
                String r2=rs.getString("season");
                String r3=Double.toString(rs.getDouble("value"));
                String result=r1+" "+r2+" "+r3+" "+"lei";

                listOfPrices.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        listOfPrices.forEach(System.out::println);


    }
    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/booking";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Geamana191990");
        return DriverManager.getConnection(url, props);
    }

}
