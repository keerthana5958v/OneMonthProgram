import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to hospital management application");
        System.out.println("for Doctor  --> Enter 1\n" + "for Patient --> Enter 2");
        String temp = sc.nextLine();
        if(temp.equals("1")){
            System.out.println("Welcome Doctor");
            System.out.println("for SignUp --> Enter 1\n" + "for Login  --> Enter 2");
            String tem2 = sc.nextLine();
            if(tem2.equals("1")){
                Doctor doc = new Doctor();
                doc.getDoctorName();
                System.out.println("enter password: ");
                doc.setPassword(sc.nextLine());
                boolean isAvailable = true;
                SignUp signup = new SignUp();
                Details doctor  = new Details(doc.getName() , doc.getPassword());
                Login login = new Login();
                login.setDoctorLogin(true);
                signup.newDoctor(doctor.getName() , doctor.getPassword() , isAvailable);
                System.out.println("Enter 1 --> to edit availability\n" + "Enter 2 --> to display all patients\n" + "Enter 3 --> to delete account");
                String tem3 = sc.nextLine();
                if(tem3.equals("1")&&login.getDoctorLogin()){
                    System.out.println("Changing availability status...\n" + "Enter 1 --> Available\n" + "Enter 2 --> Not available");
                    String tem4 = sc.next();
                    if(tem4.equals("1")){
                        doc.updateAvailability(doc.getName() , isAvailable);
                    }
                    if(tem4.equals("2")){
                        isAvailable = false;
                        doc.updateAvailability(doc.getName() , isAvailable);
                    }
                }
                if(tem3.equals("2")&&login.getDoctorLogin()){
                    Patient patient = new Patient();
                    patient.getAllPatients();
                }
                if(tem3.equals("3")){
                    Delete delete = new Delete();
                    delete.deleteDoctor(doctor.getName(), doctor.getPassword());
                }
            }

            if(tem2.equals("2")){
                Doctor doc = new Doctor();
                System.out.println("Enter Doctor's name:");
                String docName = sc.nextLine();
                System.out.println("Enter password: ");
                String password = sc.nextLine();
                Login loginObj = new Login();
                loginObj.loginDoctor(docName , password);
                System.out.println("Enter 1 --> to edit availability\n" +
                        "Enter 2 --> to display all patients\n" +
                        "Enter 3 --> to delete account");
                String tem3 = sc.nextLine();
                boolean isAvailable;
                Login login = new Login();
                login.setDoctorLogin(true);
                if(tem3.equals("1")&&login.getDoctorLogin()){
                    System.out.println("Changing availability status...\n" +
                            "Enter 1 --> Available\n" +
                            "Enter 2 --> Not available");
                    String tem4 = sc.next();
                    if(tem4.equals("1")){
                        isAvailable = true;
                        doc.updateAvailability(doc.getName() , isAvailable);
                    }
                    if(tem4.equals("2")){
                        isAvailable = false;
                        doc.updateAvailability(doc.getName() , isAvailable);
                    }
                }
                if(tem3.equals("2") && login.getDoctorLogin()){
                    Patient patient = new Patient();
                    patient.getAllPatients();
                }
                if(tem3.equals("3")){
                    Delete delete = new Delete();
                    delete.deleteDoctor(doc.getName(), doc.getPassword());
                }
            }
        }
        if(temp.equals("2")){
            System.out.println("Welcome Patient");
            System.out.println("for SignUp --> Enter 1\n" + "for Login  --> Enter 2");
            String tem2 = sc.nextLine();
            if(tem2.equals("1")){
                SignUp signUp = new SignUp();
                Patient patient = new Patient();
                patient.getPatientName();
                System.out.println("Enter password: ");
                patient.setPassword(sc.nextLine());
                System.out.println("Enter your health concern: ");
                String concern = sc.nextLine();
                System.out.println("enter appointment time(0-24) hours");
                int appointmentTime = Integer.parseInt(sc.nextLine());
                if(!(appointmentTime<25 && appointmentTime >= 0))appointmentTime = patient.DEFAULT_APPOINTMENT_TIME;
                patient.setAppointmentTime(appointmentTime);
                signUp.newPatient(patient.getName() , patient.getPassword() , concern , patient.getAppointmentTime());
                System.out.println("appointment set on "+ patient.getAppointmentTime() +":00 hours");
                System.out.println("Enter 1 --> to display available doctors\n" + "Enter 2 --> to delete account");
                String temp1 = sc.nextLine();
                if(temp1.equals("1")){
                    Doctor doc = new Doctor();
                    doc.getAllAvailableDoctors();
                }
                if(temp1.equals("2")){
                    Delete delete = new Delete();
                    delete.deletePatient(patient.getName(), patient.getPassword());
                }
            }
            if(tem2.equals("2")){
                Patient patient = new Patient();
                Doctor doc = new Doctor();
                System.out.println("enter your name: ");
                patient.setName(sc.nextLine());
                System.out.println("enter password: ");
                patient.setPassword(sc.nextLine());
                Login login = new Login();
                login.setPatientLogin(true);
                login.loginPatient(patient.getName() , patient.getPassword());
                System.out.println("Enter 1 --> to display available doctors\n" + "Enter 2 --> to delete account");
                String temp1 = sc.nextLine();
                if(temp1.equals("1") && login.getPatientLogin())doc.getAllAvailableDoctors();
                if(temp1.equals("2") && login.getPatientLogin()){
                    Delete delete = new Delete();
                    delete.deletePatient(patient.getName(), patient.getPassword());
                }
            }
        }
    }
}
