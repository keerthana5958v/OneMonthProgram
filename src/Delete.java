import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Delete {
    void deleteDoctor(String name , String password){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username","password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = con.createStatement();
            String query = "delete from doctor where name = '"+name+"' and password = '"+password+"'";
            statement.executeUpdate(query);
            System.out.println("account deleted");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    void deletePatient(String name , String password){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username","password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Statement statement = con.createStatement();
            String query = "delete from patient where name = '"+name+"' and password = '"+password+"'";
            statement.executeUpdate(query);
            System.out.println("account deleted");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Delete().deletePatient("patient1" , "password");
    }

}
