import java.util.Scanner;

public class PasswordChecker {
//    Details details = new Details();

    public String getValidPassword(){
        String password;
        do{
            password  = getInput();
        }
        while (!identifyStrength(password));
        return password;
    }
    private String getInput(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your password-->");
        String password = scan.nextLine();
        return password;
    }
    private boolean isValidLength(String givenPassword){
        if(givenPassword.length()>8){
            return true;
        }
        return false;
    }
    private boolean hasSpecialCharacters(String givenPassword){
        String specialCharacters = "!@#$%^&*()><,./?";
        for (int i = 0; i < givenPassword.length(); i++) {
            char c = givenPassword.charAt(i);
            if (specialCharacters.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDigit(String givenPassword){
        for (int i = 0; i < givenPassword.length(); i++) {
            char c = givenPassword.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    private boolean hasUpperCase(String givenPassword){
        for(int k=0; k< givenPassword.length() ; k++){
            char a = givenPassword.charAt(k);
            if(Character.isUpperCase(a)){
                return true;
            }
        }
        return false;
    }
    private boolean identifyStrength(String givenPassword){
        if(isValidLength(givenPassword)){
            return hasSpecialCharacters(givenPassword) && hasDigit(givenPassword) && hasUpperCase(givenPassword);
        }
        else{
            return false;
        }
    }
}