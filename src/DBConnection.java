import java.sql.*;

public class DBConnection {
    public Connection getDBConnection() {
        return DBConnection;
    }
    public void setDBConnection(Connection connection) {
        this.DBConnection = connection;
    }
    private Connection DBConnection = requestDBConnection();
    private Connection requestDBConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalManagement", "username", "password");
            Class.forName("com.mysql.cj.jdbc.Driver");
            setDBConnection(connection);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public void executeQuery(String query){
        try(PreparedStatement preparedStatement = getDBConnection().prepareStatement(query)){
            int affectedRows = preparedStatement.executeUpdate();
        }
        catch (Exception e){System.out.println(e.getMessage());}
    }

    public ResultSet fetchValueFromDB(String query) {
//        PreparedStatement preparedStatement;
        try {
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {
        DBConnection obj = new DBConnection();
        try(ResultSet rs = obj.fetchValueFromDB("show tables;")) {
            if(rs == null){
                  System.out.println("Some problem occurred, please contact administrator");
            }
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
