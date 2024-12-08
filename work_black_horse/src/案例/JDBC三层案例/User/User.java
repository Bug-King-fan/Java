package 案例.JDBC三层案例.User;

/**
 * @author Frank
 * @date 2024/11/09/18:46
 */
public class User {
    private Integer userId;
    private String userName;
    private String password;

    public User(Integer userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "userId=" + userId + ", userName='" + userName + '\'' + ", password='" + password + '\'';
    }
}