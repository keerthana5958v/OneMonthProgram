import java.sql.ResultSet;

public class SignUp{
    private final DBConnection dbConnection = new DBConnection();
//    private boolean createNewAccount(String name, String password){
//        String query = "select * from accounts where username = '"+name+"'and password = '"+password+"';";
//        try (ResultSet resultSet = dbConnection.fetchValueFromDB(query)){
//            if(resultSet.next()){
//                System.out.println("account already exist");
//                return true;
//            }
//            else {
//                query = "insert into accounts (username, password) values ('"+name+"', password = '"+password+"');";
//                dbConnection.executeQuery(query);
//                System.out.println("successfully signed up");
//            }
//        }
//        catch (Exception e){System.out.println(e.getMessage());}
//        return false;
//    }
    public boolean userSignUp(){
        PasswordChecker ps = new PasswordChecker();
        Details details = new Details();
        details.setName(details.readName());
        String query = "select * from accounts where username = '"+details.getName()+"';";
        try (ResultSet resultSet = dbConnection.fetchValueFromDB(query)){
            if(resultSet.next()){
                System.out.println("account already exist");
                return true;
            }
            else {
                query = "INSERT INTO accounts (username, password) VALUES ('" + details.getName() + "', '" + ps.getValidPassword() + "')";
                dbConnection.executeQuery(query);
                System.out.println("successfully signed up");
            }
        }
        catch (Exception e){System.out.println(e.getMessage());}
        return false;

    }

}
