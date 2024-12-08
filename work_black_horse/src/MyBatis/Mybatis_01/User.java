package MyBatis.Mybatis_01;

import java.sql.Date;

/**
 * @author Frank
 * @date 2024/11/11/18:45
 */
public class User {
    private Integer id;
    private String name;
    //java.sql.Date
    private Date birthday;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer id, String name, Date birthday, String sex, String address) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}