package dao;

import model.Accommodation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AccommodationDao {
    public List<Accommodation> getAll() {
            List<Accommodation> accommodationList = new ArrayList<>();
            try (
                    Connection connection = getDBConnection();
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from accommodation ")
            ) {

                while (rs.next()) {
                    Accommodation accommodation = new Accommodation();
                    accommodation.setId(rs.getInt("id"));
                    accommodation.setType(rs.getString("acc_type"));
                    accommodation.setBedType(rs.getString("bed_type"));
                    accommodation.setMaxGuests(rs.getInt("max_guests"));
                    accommodation.setDescription(rs.getString("description"));

                    accommodationList.add(accommodation);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return accommodationList;
        }

        public void insert(Accommodation accommodation) {
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("insert into accommodation (acc_type,bed_type,max_guests,description) values(?, ?, ?, ?)");
            ) {
                ps.setString(1,accommodation.getType());
                ps.setString(2,accommodation.getBedType());
                ps.setInt(3,accommodation.getMaxGuests());
                ps.setString(4,accommodation.getDescription());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void update(Accommodation accommodation) {
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("update customers set acc_type = ?, bed_type = ?, max_guests = ?, description = ? where id = ? ");
            ) {
                ps.setString(1,accommodation.getType());
                ps.setString(2,accommodation.getBedType());
                ps.setInt(3,accommodation.getMaxGuests());
                ps.setString(4, accommodation.getDescription());
                ps.setInt(5,accommodation.getId());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public void insertList(List<Accommodation> accommodationList) {
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("insert into accommodation (acc_type,bed_type,max_guests,description) values(?, ?, ?, ?)");
            ) {
                connection.setAutoCommit(false);
                for (Accommodation a:accommodationList) {
                    ps.setString(1,a.getType());
                    ps.setString(2,a.getBedType());
                    ps.setInt(3,a.getMaxGuests());
                    ps.setString(4,a.getDescription());
                    ps.addBatch();
                }
                ps.executeBatch();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public Accommodation getBy(Integer id) {
            Accommodation accommodation = null;
            try (
                    Connection connection = getDBConnection();
                    PreparedStatement ps = connection.prepareStatement("select * from accommodation where id in (?)")
            ) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                accommodation= new Accommodation();
                accommodation.setId(rs.getInt("id"));
                accommodation.setType(rs.getString("acc_type"));
                accommodation.setBedType(rs.getString("bed_type"));
                accommodation.setMaxGuests(rs.getInt("max_guests"));
                accommodation.setDescription(rs.getString("birthday"));

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return accommodation;
        }

        private Connection getDBConnection() throws SQLException {
            String url = "jdbc:postgresql://localhost:5432/booking";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "Geamana191990");
            return DriverManager.getConnection(url, props);
        }
    }


