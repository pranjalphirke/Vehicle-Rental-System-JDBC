package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DBConnection;

public class VehicleDAO {

    // Display all available vehicles
    public void showAvailableVehicles() {

        String query = "SELECT * FROM vehicles WHERE available = 1";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()
        ) {

            System.out.println("\nAvailable Vehicles:");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("type")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Rent a vehicle
    public void rentVehicle(int vehicleId, String customerName) {

        String updateVehicle =
                "UPDATE vehicles SET available = 0 WHERE id = ?";

        String insertRental =
                "INSERT INTO rentals(vehicle_id, customer_name, rent_date) " +
                "VALUES (?, ?, SYSDATE)";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps1 = con.prepareStatement(updateVehicle);
            ps1.setInt(1, vehicleId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(insertRental);
            ps2.setInt(1, vehicleId);
            ps2.setString(2, customerName);
            ps2.executeUpdate();

            System.out.println("Vehicle booked successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Return a vehicle
    public void returnVehicle(int vehicleId) {

        String query =
                "UPDATE vehicles SET available = 1 WHERE id = ?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)
        ) {

            ps.setInt(1, vehicleId);
            ps.executeUpdate();
            System.out.println("Vehicle returned successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
