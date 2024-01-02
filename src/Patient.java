
import java.sql.*;
import java.util.Scanner;

public class Patient extends Details{
    public final int DEFAULT_APPOINTMENT_TIME = 6;
    public Patient(){}
    void getPatientName(){
        System.out.println("enter patient name: ");
        Scanner sc = new Scanner(System.in);
        setName(sc.nextLine());
    }
    public int getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(int appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    private int appointmentTime = 0;
    void getAllPatients(){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username","password")) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String query = "select * from patient";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            int count = 0 ;
            while(resultSet.next()){
                count++;
                System.out.println(count+". "+resultSet.getString(1)+ "\tconcern: "+ resultSet.getString(3)+"\tappointment time = "+ resultSet.getInt(4)+":00");
            }
            if(count==0){
                System.out.println("no new patients");
            }
        }
        catch (Exception e){System.out.println(e.getMessage());}
    }

    public static void main(String[] args) {
        new Patient().getAllPatients();
    }

}
