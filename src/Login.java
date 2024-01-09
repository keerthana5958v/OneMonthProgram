import java.sql.ResultSet;

public class Login{
    private final DBConnection dbConnection= new DBConnection();
    public boolean loginAccount(String name , String password){
//        String query = "SELECT * FROM accounts WHERE name like '"+name+"' and password like '"+password+"'";
        String query = "SELECT * FROM accounts WHERE username LIKE '"+name+"' AND password LIKE '"+password + "'";
        try(ResultSet resultSet = dbConnection.fetchValueFromDB(query)) {
            if (resultSet.next()) {
                System.out.println("logged in as " + name);
                return true;
            }
            else {
                System.out.println("Account not found. Try Signing up instead");
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}

