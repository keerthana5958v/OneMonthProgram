import java.util.Scanner;
//
public class Main {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1 --> sign up");
        System.out.println("2 --> login");
        System.out.println("3 --> exit");
        String  input = sc.nextLine();
        UserFlow userFlow = new UserFlow();
        switch (input){
            case "1":
                userFlow.signUpAsUser();
                break;
            case "2":
                userFlow.loginAsUser();
                break;
            case "3":
                System.exit(0);
        }
    }
}



///*
//male female //
//db connection --> class //
//after sign up --> login
//validation for every input //
//timing check for doctor
//
// */
////regex api