package dao;

import model.Accommodation;
import model.RoomFare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RoomFareDao {
        public List<RoomFare> getAll() {
            List<RoomFare> roomFareList = new ArrayList<>();
            try (
                    Connection connection = getDBConnection();
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from room_fare ")
            ) {

                while (rs.next()) {
                    RoomFare roomFare=new RoomFare();
                    roomFare.setId(rs.getInt("id"));
                    roomFare.setValue(rs.getDouble("value"));
                    roomFare.setSeason(rs.getString("season"));

                    roomFareList.add(roomFare);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return roomFareList;
        }

        public void insert(RoomFare roomFare) {
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("insert into room_fare (value,season) values(?, ?)");
            ) {
                ps.setDouble(1,roomFare.getValue());
                ps.setString(2,roomFare.getSeason());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void update(RoomFare roomFare) {
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("update room_fare set value = ?, season = ? where id = ? ");
            ) {
                ps.setDouble(1,roomFare.getValue());
                ps.setString(2,roomFare.getSeason());
                ps.setInt(5,roomFare.getId());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void insertList(List<RoomFare>roomFareList) {
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("insert into room_fare (value,season) values(?, ?)");
            ) {
                connection.setAutoCommit(false);
                for (RoomFare r:roomFareList) {
                    ps.setDouble(1,r.getValue());
                    ps.setString(2,r.getSeason());
                    ps.addBatch();
                }
                ps.executeBatch();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public RoomFare getBy(Integer id) {
            RoomFare roomFare=null;
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("select * from room_fare where id in (?)");
            ) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                roomFare= new RoomFare();
                roomFare.setId(rs.getInt("id"));
                roomFare.setValue(rs.getDouble("value"));
                roomFare.setSeason(rs.getString("season"));

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return roomFare;
        }

        private Connection getDBConnection() throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/booking";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "Geamana191990");
            return DriverManager.getConnection(url, props);
        }
    }




