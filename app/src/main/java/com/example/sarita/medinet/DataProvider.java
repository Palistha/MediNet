package com.example.sarita.medinet;

/**
 * Created by sarita on 6/20/2016.
 */
public class DataProvider {
    private String username;
    private String Email;
    private  String Password;
    private String ConfirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public DataProvider(String username, String Email, String Password, String ConfirmPassword){
 this.username=username;
        this.Email=Email;
        this.Password=Password;
        this.ConfirmPassword=ConfirmPassword;




    }


}
