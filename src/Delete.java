import java.util.Scanner;

public class Delete {
    private final DBConnection dbConnection = new DBConnection();
    public void deleteDoctor(String name , String password){
        try{
            String query = "delete from doctor where name = '"+name+"' and password = '"+password+"';";
            dbConnection.executeQuery(query);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteDoctorAccount(String name , String password){
        Scanner sc = new Scanner(System.in);
        System.out.println("are you sure u want to delete");
        System.out.println("1 to delete, other keys to cancel");
        String input = sc.nextLine();
        switch (input){
            case "1":
                deleteAccount(name , password);
                deleteDoctor(name , password);
                System.out.println("Your account has been deleted --> doctor");
            default:
                System.out.println("delete account canceled");
        }
    }
    public void deleteAppointment(String name , String password){
        try{
            String query = "delete from patient_appointments where name = '"+name+"' and password = '"+password+"'";
            dbConnection.executeQuery(query);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deletePatientAccount(String name , String password){
        Scanner sc = new Scanner(System.in);
        System.out.println("are you sure u want to delete");
        System.out.println("1 to delete, other keys to cancel");
        switch (sc.nextLine()){
            case "1":
                deleteAccount(name , password);
                deleteAppointment(name , password);
                System.out.println("Your account has been deleted --> patient");
            default:
                System.out.println("delete account canceled");
        }
    }

    private void deleteAccount(String name , String password){
        try{
            String query = "delete from accounts where name = '"+name+"' and password = '"+password+"'";
            dbConnection.executeQuery(query);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
