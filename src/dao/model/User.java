package dao.model;

import java.time.LocalDate;

/**
 * Created by Rico on 6/13/15.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String occupation;
    private String address;

    public String toString() {
        return String.valueOf(id) + "||" + userName + "||" +
                password + "||" + email + "||" +
                firstName+"||"+lastName+"||"+
                birthday.toString()+"||"+occupation+"||"+
                address+"||";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
