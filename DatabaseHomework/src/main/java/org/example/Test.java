package org.example;

import dao.AccommodationDao;
import dao.RoomFareDao;
import model.Accommodation;
import model.RoomFare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class Test {
    private  AccommodationDao accommodationDao;
    private RoomFareDao roomFareDao;
    public Test(){
         this.accommodationDao=new AccommodationDao();
         this.roomFareDao=new RoomFareDao();
    }
    public void insertTest(Accommodation accommodation, List<RoomFare>roomFareList){
        accommodationDao.insert(accommodation);
        roomFareDao.insertList(roomFareList);
        try (
                Connection connection = this.getDBConnection();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO accommodation_room_fare_relation (accommodation_id,room_fare_id)SELECT(SELECT ID FROM accommodation WHERE ACC_TYPE=ACC_NAME),(SELECT ID FROM room_fare WHERE VALUE=VALUE_NR)FROM(values(?,?))AS T(ACC_NAME,VALUE_NR);");
        ) {
            connection.setAutoCommit(false);
            for (RoomFare r:roomFareList) {
                ps.setString(1,accommodation.getType());
                ps.setDouble(2,r.getValue());
                ps.executeUpdate();
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Connection getDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/booking";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "Geamana191990");
        return DriverManager.getConnection(url, props);
    }
}
