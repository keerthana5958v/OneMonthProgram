import java.sql.ResultSet;
import java.util.Scanner;


public class DoctorDetails extends Details {
    private final DBConnection dbConnection = new DBConnection();
    private int ShiftStartTime;
    private int ShiftEndTime;

    public int getShiftStartTime() {
        return ShiftStartTime;
    }
    public void setShiftStartTime(int shiftStartTime) {
        ShiftStartTime = shiftStartTime;
    }
    public int getShiftEndTime() {
        return ShiftEndTime;
    }
    public void setShiftEndTime(int shiftEndTime) {
        ShiftEndTime = shiftEndTime;
    }



    private int getShiftStartTimeFromUser(){
        System.out.println("enter shift start time (0-23):");
        Scanner sc = new Scanner(System.in);
        int startTime = Integer.parseInt(sc.nextLine());
        if(startTime<24 && startTime>=0){
            return startTime;
        }
        return -1;
    }
    private int getShiftEndTimeFromUser(){
        System.out.println("enter shift end time (0-23):");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int endTime = Integer.parseInt(input);
        if(endTime<24 && endTime>=0){
            return endTime;
        }
        return -1;
    }


    public String readName() {
        System.out.println("enter doctor's name: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public int getValidStartTime(){
        int startTime;
        do{
            startTime = getShiftStartTimeFromUser();
        }
        while (startTime == -1);
        return startTime;
    }
    public void setValidTimings(){
        setShiftStartTime(getValidStartTime());
        int endTime;
        do{
            endTime = getShiftEndTimeFromUser();
        }
        while (endTime == -1 || endTime < getShiftStartTime());
        setShiftEndTime(endTime);
    }
    public String getDoctorsSpeciality(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter doctor's speciality: ");
        return sc.nextLine();
    }
    public void getAllAvailableDoctors() {
        String query = "select * from doctor;";
        try (ResultSet resultSet = dbConnection.fetchValueFromDB(query)) {
            int count = 0 ;
            while (resultSet.next()) {
                count++;
                System.out.println(count + ". " + resultSet.getString(1)+
                        "\tavailable from: "+resultSet.getInt(4)+
                        "\tavailable till: "+resultSet.getInt(5)+
                        "\tspeciality: "+resultSet.getString(6));
            }
            if (count == 0) {
                System.out.println("No available doctor");
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong !");
            System.out.println(e.getMessage());
        }
    }
    public void updateAllDoctorDetails(String name, String password, Gender gender, int startTime, int endTime,String speciality){
        String query = "select * from doctor where name ='"+name+"' and password = '"+password+"';";
        try (ResultSet resultSet = dbConnection.fetchValueFromDB(query)) {
            int count = 0 ;
            if(resultSet.next()) {
                count++;
                query = "UPDATE doctor " +
                        "SET gender = '" + gender + "', start_time = " + startTime + ", end_time = " + endTime +", speciality = '"+speciality+"'"+
                        " WHERE name = '" + name + "' AND password = '" + password + "';";
                dbConnection.executeQuery(query);
                System.out.println("values entered");
            }
            if (count == 0) {
                query = "INSERT INTO doctor (name, password, gender, start_time, end_time, speciality) VALUES" +
                        " ('"+name+"','"+password+"','"+gender+"', "+startTime+", "+endTime+",'"+speciality+"');";
                dbConnection.executeQuery(query);
                System.out.println("values updated");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}


