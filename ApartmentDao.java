import java.sql.*;

public class ApartmentDao {
    private final Connection connection;

    public ApartmentDao(Connection connection) {
        this.connection = connection;
    }

    public Apartment getApartmentById(int id) throws SQLException {
        String query = "SELECT * FROM apartments WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int numberOfRooms = resultSet.getInt("number_of_rooms");
            int numberOfBathrooms = resultSet.getInt("number_of_bathrooms");
            double price = resultSet.getDouble("price");

            return new Apartment(id, numberOfRooms, numberOfBathrooms, price);
        }

        return null;
    }
}
