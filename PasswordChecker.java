import java.util.Scanner;

public class PasswordChecker {
    public String getValidPassword(){
        String password;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("Enter your password-->");
            password  = sc.nextLine();
        }
        while (identifyStrength(password));
        return password;
    }
    private boolean identifyStrength(String givenPassword){
        String specialCharacters = "!@#$%^&*()><,./?";
        if(givenPassword.length()>=8) {
            for (int i = 0; i < givenPassword.length(); i++) {
                char c = givenPassword.charAt(i);
                if (!specialCharacters.contains(String.valueOf(c))) {
                    return false;
                }
                if (!Character.isUpperCase(c)) {
                    return false;
                }
                if (!Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }

}