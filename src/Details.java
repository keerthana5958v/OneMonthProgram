
public class Details{
    public Details(String name, String password) {
        this.name = name;
        this.password = password;
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

}
