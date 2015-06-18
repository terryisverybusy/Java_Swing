package dao.model;

import utils.Utils;

import java.time.LocalDate;

public class User {
    private long id;
    private String userName;
    private String password;
    private String email;
    private String firstName = "John";
    private String lastName = "Doe";
    private LocalDate birthday = LocalDate.now();
    private LocalDate licenseDate;
    private String occupation;
    private String address;

    public User(String userName, String password) {
        id = System.currentTimeMillis();
        this.userName = userName;
        this.password = password;
    }

    public User(int id, String userName, String password, String email,
                String firstName, String lastName, LocalDate birthday, String occupation, String address,LocalDate licenseDate) {
        this(userName, password);
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.occupation = occupation;
        this.address = address;
        this.licenseDate = licenseDate;
    }

    public User(String s) {
        String[] ss = s.split(Utils.regex);
        id = Long.parseLong(ss[1].substring(1));
        userName = ss[2];
        password = ss[3];
        email = ss[4];
        firstName = ss[5];
        lastName = ss[6];
        birthday = LocalDate.parse(ss[7]);
        occupation = ss[8];
        address = ss[9];
        licenseDate = LocalDate.parse(ss[10]);
    }

    public LocalDate getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(LocalDate licenseDate) {
        this.licenseDate = licenseDate;
    }

    public String toString() {
        String d = Utils.delim;
        return d + "u" + id + d + userName + d +
                password + d + email + d +
                firstName + d + lastName + d +
                birthday.toString() + d + occupation + d + address +d+ licenseDate.toString();
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
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
