
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SignUp{

    void newDoctor(String name, String password , boolean isAvailable){
        Connection connection;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username","password");
            Statement statement = connection.createStatement();
            String query;
            if(isAvailable) {
                query = "INSERT INTO doctor (name, password , isAvailable) VALUES ('" + name + "','" + password + "','1');";
            }
            else{
                query = "INSERT INTO doctor (name, password , isAvailable) VALUES ('" + name + "','" + password + "','0');";
            }
            statement.executeUpdate(query);
            System.out.println("successfully signed up");
        }
        catch (Exception e){
            System.out.println("catch");
            System.out.println(e.getMessage());
        }
    }
    void newPatient(String name, String password , String concern, int appointmentTime){
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username","password")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = connection.createStatement();
            String query = "INSERT INTO patient (name, password , concern , appointment_time) VALUES ('" + name + "','" + password + "','"+concern+"','"+appointmentTime+"');";
            statement.executeUpdate(query);
            System.out.println("successfully signed up");
        }
        catch (Exception e){System.out.println(e.getMessage());}
    }

    public static void main(String[] args) {
        SignUp obj = new SignUp();
        obj.newPatient("patient7","password", "stomach pain" , 7);
    }
}
