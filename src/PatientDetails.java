import java.sql.ResultSet;
import java.util.Scanner;

public class PatientDetails extends Details{
    private final DBConnection dbConnection = new DBConnection();

    private int appointmentTime;
    public int getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(int appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    private int getAppointmentTimeFromUser(){
        System.out.println("enter appointment start time (0-23):");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        int appTime = Integer.parseInt(userInput);
        if(appTime<24&&appTime>=0){
            return appTime;
        }
        return -1;
    }
    public int getValidAppointmentTime(){
        int startTime;
        do{
            startTime = getAppointmentTimeFromUser();
        }
        while (startTime == -1);
        setAppointmentTime(startTime);
        return getAppointmentTime();
    }

//    public String readPatientName(){
//        System.out.println("enter patient name: ");
//        Scanner sc = new Scanner(System.in);
//        return sc.nextLine();
//    }
    public void getAllPatients(){
        String query = "select * from patient_appointments";
        try(ResultSet resultSet = dbConnection.fetchValueFromDB(query)){
            int count = 0 ;
            while(resultSet.next()){
                count++;
                System.out.println(count+". "+resultSet.getString(1)+
                        "\tGender: "+resultSet.getString(3).charAt(0)+ "\tconcern: "+ resultSet.getString(5)+"\tappointment time = "+ resultSet.getInt(4)+":00");
            }
            if(count==0){
                System.out.println("no new patients");
            }
        }
        catch (Exception e){System.out.println(e.getMessage());}
    }
    public void bookAppointment(String name , String password, Gender gender , int appointmentTime){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your concern: ");
        String concern = sc.nextLine();
        String query = "INSERT INTO patient_appointments (name, password, gender, appointment_time, concern) VALUES ('"+name+"','"+password+"','"+gender+"', "+appointmentTime+", '"+concern+"');";
        dbConnection.executeQuery(query);
        System.out.println("appointment booked.");
    }

}
