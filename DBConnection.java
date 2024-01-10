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
        try {
            PreparedStatement preparedStatement = getDBConnection().prepareStatement(query);
            return preparedStatement.executeQuery();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
