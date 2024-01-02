import java.sql.*;
import java.util.Scanner;

public class Doctor extends Details {
    public Doctor() {
    }

    void getDoctorName() {
        System.out.println("enter doctor's name: ");
        Scanner sc = new Scanner(System.in);
        setName(sc.nextLine());
    }

    void updateAvailability(String name, boolean isAvailable) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username", "password")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            String query;
            if (isAvailable) {
                query = "UPDATE doctor " + " SET isAvailable = '1' WHERE name = '" + name + "';";
            } else {
                query = "UPDATE doctor " + " SET isAvailable = '0' WHERE name = '" + name + "';";
            }
            statement.executeUpdate(query);
            System.out.println("availability changed");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void getAllAvailableDoctors() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username", "password")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query = "select * from doctor where isAvailable = 1";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
                System.out.println(count + ". " + resultSet.getString(1));
            }
            if (count == 0) {
                System.out.println("No available doctor");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Doctor obj = new Doctor();
        obj.getAllAvailableDoctors();
//        obj.updateAvailability("keerthana",true);
    }
}


