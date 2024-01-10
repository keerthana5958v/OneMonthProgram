import java.util.Scanner;

public class UserFlow {
    public void signUpAsUser(){
        SignUp signUp = new SignUp();
        System.out.println("Sign up -->");
        if(signUp.userSignUp()){
            loginAsUser();
        }
    }
    public void loginAsUser(){
        Details details = new Details();
        String user = details.getValidUser();
        switch (user) {
            case "doctor":
                if(!doctorLogin()){
                    //call case 1
                    signUpAsUser();
                }
            case "patient":
                if(!patientLogin()){
                    signUpAsUser();
                }
        }
    }
    public boolean patientLogin(){
        Login login = new Login();
        System.out.println("login-->");
        PatientDetails patientDetails = new PatientDetails();
        patientDetails.setName(patientDetails.readName());
        PasswordChecker passwordChecker = new PasswordChecker();
        patientDetails.setPassword(passwordChecker.getValidPassword());
        if(login.loginAccount(patientDetails.getName(),patientDetails.getPassword())){
            patientLoginActivities(patientDetails.getName(), patientDetails.getPassword());
            return true;
        }
        return false;
    }
    public boolean doctorLogin(){
        Login login = new Login();
        System.out.println("login-->");
        DoctorDetails doctorDetails = new DoctorDetails();
        doctorDetails.setName(doctorDetails.readName());
        PasswordChecker passwordChecker = new PasswordChecker();
        doctorDetails.setPassword(passwordChecker.getValidPassword());
        if(login.loginAccount(doctorDetails.getName(),doctorDetails.getPassword())){
            doctorLoginActivities(doctorDetails.getName(), doctorDetails.getPassword());
            return true;
        }
        return false;
    }
    private void patientLoginActivities(String name, String password){
        PatientDetails patientDetails = new PatientDetails();
        while(patientDetails.getIsValidInput()){
            System.out.println("\n1 available doctors");
            System.out.println("2 book appointment");
            System.out.println("3 to delete appointment");
            System.out.println("4 delete account");
            System.out.println("5 to exit");
            Delete delete = new Delete();
            Scanner sc = new Scanner(System.in);
            patientDetails.setValidInput(true);
            switch (sc.nextLine()){
                case "1":
                    DoctorDetails doctorDetails = new DoctorDetails();
                    doctorDetails.getAllAvailableDoctors();
                    break; //
                case "2":
                    patientDetails.setGender(patientDetails.inputValidGender());
                    patientDetails.bookAppointment(name, password,
                            patientDetails.getGender(),
                            patientDetails.getValidAppointmentTime());
                    break; //
                case "3":
                    delete.deleteAppointment(name,password); //
                    break; //
                case "4":
                    delete.deletePatientAccount(name, password); //
                    System.exit(0);
                    break;
                case "5":
                    System.exit(0);//
                default://
                    patientDetails.setValidInput(false);
            }
        }
    }
    private void doctorLoginActivities(String name, String password){
        DoctorDetails doctorDetails = new DoctorDetails();
        Delete delete = new Delete();
            while(doctorDetails.getIsValidInput()){
                Scanner sc = new Scanner(System.in);
                System.out.println("1 --> view patients");
                System.out.println("2 --> add doctor details");
                System.out.println("3 --> delete doctor details");
                System.out.println("4 --> delete account");
                System.out.println("5 --> exit");
                String input = sc.nextLine();
                doctorDetails.setValidInput(true);
                switch (input) {
                    case "1":
                        PatientDetails patientDetails = new PatientDetails();
                        patientDetails.getAllPatients(); //
                        break;
                    case "2":
                        doctorDetails.setGender(doctorDetails.inputValidGender());
                        doctorDetails.setValidTimings();
                        doctorDetails.updateAllDoctorDetails(
                                name, password,
                                doctorDetails.getGender(), doctorDetails.getShiftStartTime(),
                                doctorDetails.getShiftEndTime(), doctorDetails.getDoctorsSpeciality()); //
                        break;
                    case "3":
                        delete.deleteDoctorDetails(name, password);
                        break;
                    case "4":
                        delete.deleteDoctorAccount(name, password); //
                        System.exit(0);
                        break;
                    case "5":
                        System.exit(0);//
                    default:
                        System.out.println("\nenter proper value\n");
                        doctorDetails.setValidInput(true);
                }
            }
    }

}
