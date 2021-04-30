package sv.edu.udb.crud_app;

public class User {
    private String userId;
    private String userName;
    private String userLastName;
    private String userPhone;

    public User(){

    }

    public User(String userId, String userName, String userLastName, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
    }

    public String getUserId(){
        return userId;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserLastName(){
        return userLastName;
    }

    public String getUserPhone(){
        return userPhone;
    }

    public void setUserId(String userId){this.userId = userId;}
}
