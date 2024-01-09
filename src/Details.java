import java.util.Scanner;

public class Details{
    public Details(String name, String password) {
        this.name = name;
        this.password = password;
    }
    public String readName() {
        System.out.println("enter your name: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public Details(){}
    private String name = "";

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
    private String password = "";
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Gender getGender() {
        return gender;
    }
    private Gender inputGender(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter you gender");
        System.out.println("1 -->male");
        System.out.println("2 -->female");
        System.out.println("3 -->other");
        String genderInput = sc.nextLine();
        switch (genderInput){
            case "1":
                setGender(Gender.Male);
                break;
            case "2":
                setGender(Gender.Female);
                break;
            case "3":
                setGender(Gender.NB);
                break;
            default:
                setGender(Gender.NA);
        }
        return getGender();
    }
    public Gender inputValidGender(){
        do{
            setGender(inputGender());
        }while(getGender()==Gender.NA);
        return getGender();
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    private Gender gender;
    public String getValidUser(){
        String user = "?";
        do{
            user = userChecker();
        }while (user.equals("?"));
        return user;
    }
    private String userChecker(){
        String user = "?";
        Scanner sc = new Scanner(System.in);
        System.out.println("1 --> doctor");
        System.out.println("2 --> patient");
        String input = sc.nextLine();
        switch (input){
            case "1":
                user = "doctor";
                break;
            case "2":
                user = "patient";
            default:
                user = "?";
        }
        return user;
    }

    public boolean getIsValidInput() {
        return isValidInput;
    }

    public void setValidInput(boolean validInput) {
        isValidInput = validInput;
    }

    private boolean isValidInput = true;

}
